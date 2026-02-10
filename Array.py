class Mahasiswa:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama

# Inisialisasi array dengan None dan kapasitas 10
data_mhs = [None] * 10
count = 0

def show_data():
    if count == 0:
        print("\n[!] Data kosong.")
        return
    print("\n--- Daftar Mahasiswa ---")
    for i in range(count):
        print(f"{i}. NIM: {data_mhs[i].nim} | Nama: {data_mhs[i].nama}")

def insert_at_pos(pos):
    global count
    if count >= 10:
        print("[!] Kapasitas penuh!")
        return
    if pos < 0 or pos > count:
        print("[!] Posisi tidak valid.")
        return

    # Geser elemen ke kanan
    for i in range(count, pos, -1):
        data_mhs[i] = data_mhs[i-1]

    nim = input("Masukkan NIM: ")
    nama = input("Masukkan Nama: ")
    data_mhs[pos] = Mahasiswa(nim, nama)
    count += 1
    print("[+] Data berhasil ditambahkan.")

def delete_at_pos(pos):
    global count
    if count == 0:
        print("[!] Data kosong.")
        return
    if pos < 0 or pos >= count:
        print("[!] Posisi tidak ditemukan.")
        return

    # Geser elemen ke kiri
    for i in range(pos, count - 1):
        data_mhs[i] = data_mhs[i+1]
    
    data_mhs[count-1] = None # Bersihkan sisa data
    count -= 1
    print("[-] Data berhasil dihapus.")

# Main Loop (Ringkasan Menu)
while True:
    print(f"\n=== MENU PYTHON (Data: {count}/10) ===")
    print("1. Insert Beginning")
    print("2. Insert Pos")
    print("3. Insert End")
    print("4. Delete Beginning")
    print("5. Delete Pos")
    print("6. Delete End")
    print("7. Delete First Occurrence")
    print("8. Show")
    print("9. Exit")
    
    pilih = input("Pilih menu: ")
    if pilih == '1': insert_at_pos(0)
    elif pilih == '2': insert_at_pos(int(input("Posisi: ")))
    elif pilih == '3': insert_at_pos(count)
    elif pilih == '4': delete_at_pos(0)
    elif pilih == '5': delete_at_pos(int(input("Posisi: ")))
    elif pilih == '6': delete_at_pos(count - 1)
    elif pilih == '7':
        target = input("Masukkan NIM: ")
        found = False
        for i in range(count):
            if data_mhs[i].nim == target:
                delete_at_pos(i)
                found = True
                break
        if not found: print("NIM tidak ditemukan.")
    elif pilih == '8': show_data()
    elif pilih == '9': break
