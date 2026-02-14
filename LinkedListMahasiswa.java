package LinkedList;
import java.util.Scanner;

public class LinkedListMahasiswa {

    // ==========================================
    // CLASS NODE
    // ==========================================
    // Node adalah elemen dalam LinkedList.
    // Setiap node menyimpan:
    // - nim
    // - nama
    // - next (pointer ke node berikutnya)

    static class Node {
        String nim;     // data nim mahasiswa
        String nama;    // data nama mahasiswa
        Node next;      // pointer ke node berikutnya

        // Constructor untuk mengisi data node
        Node(String nim, String nama) {
            this.nim = nim;
            this.nama = nama;
            this.next = null; // awalnya tidak menunjuk ke node lain
        }
    }

    // head menunjuk ke node pertama dalam LinkedList
    static Node head = null;

    // count menyimpan jumlah data dalam LinkedList
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // ==========================================
    // INSERT AT BEGINNING
    // ==========================================
    static void insertAtBeginning() {

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        // Buat node baru
        Node newNode = new Node(nim, nama);

        // Node baru menunjuk ke head lama
        newNode.next = head;

        // Head dipindah ke node baru
        head = newNode;

        // Karena ada penambahan data
        count++;
    }

    // ==========================================
    // INSERT AT END
    // ==========================================
    static void insertAtEnd() {

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        Node newNode = new Node(nim, nama);

        // Jika LinkedList kosong
        if (head == null) {
            head = newNode;
        } else {

            // Mulai dari head
            Node temp = head;

            // Bergerak sampai node terakhir
            while (temp.next != null) {
                temp = temp.next;
            }

            // Node terakhir menunjuk ke node baru
            temp.next = newNode;
        }

        count++;
    }

    // ==========================================
    // INSERT AT GIVEN POSITION
    // ==========================================
    static void insertAtPosition() {

        System.out.print("Posisi (1 - " + (count + 1) + "): ");
        int pos = sc.nextInt();
        sc.nextLine();

        // Validasi posisi
        if (pos < 1 || pos > count + 1) {
            System.out.println("Posisi tidak valid");
            return;
        }

        // Jika posisi pertama
        if (pos == 1) {
            insertAtBeginning();
            return;
        }

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        Node newNode = new Node(nim, nama);

        Node temp = head;

        // Bergerak ke node sebelum posisi tujuan
        // Misal mau insert di posisi 3
        // Maka berhenti di posisi 2
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        // Hubungkan node baru ke node setelah temp
        newNode.next = temp.next;

        // Temp menunjuk ke node baru
        temp.next = newNode;

        count++;
    }

    // ==========================================
    // DELETE FROM BEGINNING
    // ==========================================
    static void deleteFromBeginning() {

        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        // Head dipindahkan ke node berikutnya
        head = head.next;

        count--;
    }

    // ==========================================
    // DELETE FROM END
    // ==========================================
    static void deleteFromEnd() {

        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        // Jika hanya ada satu node
        if (head.next == null) {
            head = null;
        } else {

            Node temp = head;

            // Bergerak sampai node sebelum terakhir
            while (temp.next.next != null) {
                temp = temp.next;
            }

            // Putuskan node terakhir
            temp.next = null;
        }

        count--;
    }

    // ==========================================
    // DELETE GIVEN POSITION
    // ==========================================
    static void deleteAtPosition() {

        System.out.print("Posisi (1 - " + count + "): ");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos < 1 || pos > count) {
            System.out.println("Posisi tidak valid");
            return;
        }

        if (pos == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;

        // Bergerak ke node sebelum yang ingin dihapus
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        // Lewati node yang ingin dihapus
        temp.next = temp.next.next;

        count--;
    }

    // ==========================================
    // DELETE FIRST OCCURRENCE (berdasarkan NIM)
    // ==========================================
    static void deleteFirstOccurrence() {

        System.out.print("Masukkan NIM yang dihapus: ");
        String key = sc.nextLine();

        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        // Jika node pertama yang cocok
        if (head.nim.equals(key)) {
            head = head.next;
            count--;
            return;
        }

        Node temp = head;

        // Cari node sebelum yang cocok
        while (temp.next != null && !temp.next.nim.equals(key)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            count--;
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    // ==========================================
    // SHOW DATA
    // ==========================================
    static void showData() {

        if (head == null) {
            System.out.println("List kosong");
            return;
        }

        Node temp = head;
        int i = 1;

        while (temp != null) {
            System.out.println(i + ". " + temp.nim + " - " + temp.nama);
            temp = temp.next;
            i++;
        }
    }

    // ==========================================
    // MAIN MENU
    // ==========================================
    public static void main(String[] args) {

        int choice;

        do {

            // Menampilkan jumlah data saat ini
            System.out.println("\n=== MENU JAVA (Data: " + count + ") ===");

            System.out.println("1.Insert Beginning");
            System.out.println("2.Insert Position");
            System.out.println("3.Insert End");
            System.out.println("4.Delete Beginning");
            System.out.println("5.Delete Position");
            System.out.println("6.Delete End");
            System.out.println("7.Delete First Occurrence");
            System.out.println("8.Show Data");
            System.out.println("9.Exit");

            System.out.print("Pilih: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> insertAtBeginning();
                case 2 -> insertAtPosition();
                case 3 -> insertAtEnd();
                case 4 -> deleteFromBeginning();
                case 5 -> deleteAtPosition();
                case 6 -> deleteFromEnd();
                case 7 -> deleteFirstOccurrence();
                case 8 -> showData();
            }

        } while (choice != 9);
    }
}
