# =========================
# CLASS NODE
# =========================
# Node adalah elemen dasar dalam LinkedList
# Setiap node menyimpan:
# - nim (data mahasiswa)
# - nama (data mahasiswa)
# - next (pointer ke node berikutnya)

class Node:
    def __init__(self, nim, nama):
        self.nim = nim      # menyimpan nim
        self.nama = nama    # menyimpan nama
        self.next = None    # pointer awalnya tidak menunjuk ke mana-mana


# head menunjuk ke node pertama dalam LinkedList
head = None

# count menyimpan jumlah data dalam LinkedList
count = 0


# =========================
# INSERT AT BEGINNING
# =========================
def insert_beginning():
    global head, count

    nim = input("Masukkan NIM: ")
    nama = input("Masukkan Nama: ")

    # Buat node baru
    new_node = Node(nim, nama)

    # Node baru menunjuk ke head lama
    new_node.next = head

    # Head dipindahkan ke node baru
    head = new_node

    # Karena ada penambahan data
    count += 1


# =========================
# INSERT AT END
# =========================
def insert_end():
    global head, count

    nim = input("Masukkan NIM: ")
    nama = input("Masukkan Nama: ")

    new_node = Node(nim, nama)

    # Jika LinkedList masih kosong
    if head is None:
        head = new_node
    else:
        # Mulai dari head
        temp = head

        # Bergerak sampai node terakhir
        while temp.next:
            temp = temp.next

        # Node terakhir menunjuk ke node baru
        temp.next = new_node

    count += 1


# =========================
# INSERT AT POSITION
# =========================
def insert_position():
    global head, count

    pos = int(input(f"Posisi (1 - {count+1}): "))

    # Validasi posisi
    if pos < 1 or pos > count + 1:
        print("Posisi tidak valid")
        return

    # Kalau posisi 1 berarti sama dengan insert awal
    if pos == 1:
        insert_beginning()
        return

    nim = input("Masukkan NIM: ")
    nama = input("Masukkan Nama: ")

    new_node = Node(nim, nama)

    temp = head

    # Bergerak ke node sebelum posisi tujuan
    # Misal mau insert di posisi 3
    # Maka berhenti di posisi 2
    for _ in range(pos - 2):
        temp = temp.next

    # Node baru menunjuk ke node setelah temp
    new_node.next = temp.next

    # Temp menunjuk ke node baru
    temp.next = new_node

    count += 1


# =========================
# DELETE FROM BEGINNING
# =========================
def delete_beginning():
    global head, count

    if head is None:
        print("List kosong")
        return

    # Head pindah ke node berikutnya
    head = head.next

    count -= 1


# =========================
# DELETE FROM END
# =========================
def delete_end():
    global head, count

    if head is None:
        print("List kosong")
        return

    # Jika hanya ada 1 node
    if head.next is None:
        head = None
    else:
        temp = head

        # Bergerak sampai node sebelum terakhir
        while temp.next.next:
            temp = temp.next

        # Putuskan node terakhir
        temp.next = None

    count -= 1


# =========================
# DELETE AT POSITION
# =========================
def delete_position():
    global head, count

    pos = int(input(f"Posisi (1 - {count}): "))

    if pos < 1 or pos > count:
        print("Posisi tidak valid")
        return

    if pos == 1:
        delete_beginning()
        return

    temp = head

    # Bergerak ke node sebelum yang mau dihapus
    for _ in range(pos - 2):
        temp = temp.next

    # Lewati node yang ingin dihapus
    temp.next = temp.next.next

    count -= 1


# =========================
# DELETE FIRST OCCURRENCE
# =========================
def delete_first_occurrence():
    global head, count

    key = input("Masukkan NIM yang dihapus: ")

    if head is None:
        print("List kosong")
        return

    # Jika node pertama yang cocok
    if head.nim == key:
        head = head.next
        count -= 1
        return

    temp = head

    # Cari node sebelum yang cocok
    while temp.next and temp.next.nim != key:
        temp = temp.next

    if temp.next:
        temp.next = temp.next.next
        count -= 1
    else:
        print("Data tidak ditemukan")


# =========================
# SHOW DATA
# =========================
def show_data():
    temp = head
    i = 1

    if temp is None:
        print("List kosong")
        return

    while temp:
        print(f"{i}. {temp.nim} - {temp.nama}")
        temp = temp.next
        i += 1


# =========================
# MENU UTAMA
# =========================
while True:

    # Menampilkan jumlah data saat ini
    print(f"\n=== MENU PYTHON (Data: {count}) ===")

    print("1.Insert Beginning")
    print("2.Insert Position")
    print("3.Insert End")
    print("4.Delete Beginning")
    print("5.Delete Position")
    print("6.Delete End")
    print("7.Delete First Occurrence")
    print("8.Show Data")
    print("9.Exit")

    choice = int(input("Pilih: "))

    if choice == 1:
        insert_beginning()
    elif choice == 2:
        insert_position()
    elif choice == 3:
        insert_end()
    elif choice == 4:
        delete_beginning()
    elif choice == 5:
        delete_position()
    elif choice == 6:
        delete_end()
    elif choice == 7:
        delete_first_occurrence()
    elif choice == 8:
        show_data()
    elif choice == 9:
        break
