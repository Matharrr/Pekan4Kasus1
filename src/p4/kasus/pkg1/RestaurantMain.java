package p4.kasus.pkg1;

import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Bala-Bala", 1000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu", 1000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu", 1000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Molen", 1000, 20);
        Scanner input = new Scanner(System.in);
        int id_menu, jumlah;
        OUTER:
        while (true) {
            menu.tampilMenuMakanan();
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID makanan yang Anda pesan: ");
                    id_menu = input.nextInt();
                    System.out.print("Masukkan jumlah makanan yang Anda pesan: ");
                    jumlah = input.nextInt();
                    menu.pesanMakanan(id_menu, jumlah);
                    break;
                case 2:
                    System.out.print("Masukkan ID makanan yang akan ditambah stok: ");
                    id_menu = input.nextInt();
                    System.out.print("Masukkan jumlah stok yang akan ditambah: ");
                    int stok = input.nextInt();
                    menu.tambahStokMakanan(id_menu-1, stok);
                    break;
                case 99:
                    System.out.println("Terima kasih, program dihentikan.");
                    break OUTER;
                default:
                    System.out.println("Maaf, pilihan tidak tersedia.");
                    break;
            }
        }
    }
}
