package p4.kasus.pkg1;

import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Bala-Bala", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu ", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu ", 1_000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Molen", 1_000, 20);
        menu.tampilMenuMakanan();
        Scanner input = new Scanner(System.in);
        int id_menu, jumlah;
        while (true) {
            menu.tampilMenuMakanan();
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            id_menu = input.nextInt();
            if (id_menu == 99) {
                System.out.println("Terima kasih, program dihentikan.");
                break;
            }
            System.out.print("Jumlah: ");
            jumlah = input.nextInt();
            // panggil method inputPesanMenuMakanan
            menu.inputPesanMakanan(id_menu, jumlah);
        }
    }
}
