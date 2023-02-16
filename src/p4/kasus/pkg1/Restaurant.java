package p4.kasus.pkg1;

import java.util.Scanner;

public class Restaurant {
    /*
    Mengubah keyword public menjadi private agar variabel hanya bisa diakses pada
    class Restaurant saja
    */
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id=0;
    
    public Restaurant(){
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }
    
    public void tambahMenuMakanan(String nama, double harga, int stok){
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }
    
    public void tampilMenuMakanan(){
        /*
        Menghapus kondisi isOutOfStock, agar bisa menampilkan menu yang kosong
        Menambahkan counter agar memudahkan user memasukan input
        Mengganti println menjadi printf untuk mengatur format menu
        */
        int counter = 1;
        for(int i=0; i<=id; i++){
//            System.out.println(+counter+". "+nama_makanan[i] +"["+stok[i]+"]"+"\tRp. "+harga_makanan[i]);
            System.out.printf("%d. %-15s[%-2d]\tRp. %,-10.2f\n", counter, nama_makanan[i], stok[i], harga_makanan[i]);
            counter++;
        }
    }
    
    
    public boolean isOutOfStock(int id){
        /*
        Menyederhanakan logika
        */
//                if(stok[id] == 0){
//            return true;
//        }else{
//            return false;
//        }
        return stok[id] == 0;
    }
    
    public static void nextId(){
        id++;
    }
    /*
    Mempesiapkan setter
    */
    public void setNamaMakanan(String[] nama_makanan){
        this.nama_makanan = nama_makanan;
    }
    public void setHargaMakanan(double[] harga_makanan){
        this.harga_makanan = harga_makanan;
    }public void setStok(int[] stok){
        this.stok = stok;
    }
    /*
    Mempersiapkan getter
    */
    public String[] getNamaMakanan(String[] nama_makanan){
        return nama_makanan;
    }
    public double[] getHargaMakanan(double[] harga_makanan){
        return harga_makanan;
    }
    public int[] getStok(int[] stok){
        return stok;
    }
    /*
    Menambahkan method baru untuk pemesanan
    */
    public void pesanMakanan(int id, int jumlah) {
        if (id >= 0 && id <= nama_makanan.length && stok[id] >= jumlah) {
            stok[id] -= jumlah;
            System.out.println("Pesanan berhasil! Anda telah memesan " + jumlah + " " + nama_makanan[id]);
        } else {
            System.out.println("Maaf, pesanan Anda tidak dapat diproses karena stok " + nama_makanan[id] + " tidak mencukupi.");
        }
    }
    /*
    Menambahkan method baru untuk input pesanan
    */
    public void inputPesanMakanan() {
        Scanner scanner = new Scanner(System.in);
        tampilMenuMakanan();
        System.out.print("Masukkan ID makanan yang Anda pesan: ");
        int id = scanner.nextInt();
        System.out.print("Masukkan jumlah makanan yang Anda pesan: ");
        int jumlah = scanner.nextInt();
        id -= 1;
        pesanMakanan(id, jumlah);
        tampilMenuMakanan();
    }
}