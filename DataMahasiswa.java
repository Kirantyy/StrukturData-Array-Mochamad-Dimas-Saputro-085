import java.util.Scanner;

class Mahasiswa {
    String nim, nama;
    Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }
}

public class DataMahasiswa{
    static Mahasiswa[] dataMhs = new Mahasiswa[10];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU JAVA (Data: " + count + "/10) ===");
            System.out.println("1. Insert Start");
            System.out.println("2. Insert Pos");
            System.out.println("3. Insert End");
            System.out.println("4. Del Start");
            System.out.println("5. Del Pos");
            System.out.println("6. Del End");
            System.out.println("7. Del First Occur");
            System.out.println("8. Show");
            System.out.println("9. Exit");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1 -> insertPos(0);
                case 2 -> {
                    System.out.print("Posisi: ");
                    insertPos(sc.nextInt());
                }
                case 3 -> insertPos(count);
                case 4 -> deletePos(0);
                case 5 -> {
                    System.out.print("Posisi: ");
                    deletePos(sc.nextInt());
                }
                case 6 -> deletePos(count - 1);
                case 7 -> deleteFirstOccurrence();
                case 8 -> show();
            }
        } while (pilihan != 9);
    }

    static void insertPos(int pos) {
        if (count >= 10) { System.out.println("Penuh!"); return; }
        if (pos < 0 || pos > count) { System.out.println("Posisi salah!"); return; }

        for (int i = count; i > pos; i--) dataMhs[i] = dataMhs[i-1];

        System.out.print("NIM: "); String nim = sc.next();
        sc.nextLine(); // clear buffer
        System.out.print("Nama: "); String nama = sc.nextLine();
        
        dataMhs[pos] = new Mahasiswa(nim, nama);
        count++;
    }

    static void deletePos(int pos) {
        if (count == 0 || pos < 0 || pos >= count) { System.out.println("Gagal!"); return; }
        for (int i = pos; i < count - 1; i++) dataMhs[i] = dataMhs[i+1];
        dataMhs[count - 1] = null;
        count--;
    }

    static void deleteFirstOccurrence() {
        System.out.print("Cari NIM: ");
        String target = sc.next();
        for (int i = 0; i < count; i++) {
            if (dataMhs[i].nim.equals(target)) {
                deletePos(i);
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    static void show() {
        if (count == 0) System.out.println("Kosong.");
        for (int i = 0; i < count; i++) 
            System.out.println(i + ". " + dataMhs[i].nim + " - " + dataMhs[i].nama);
    }
}
