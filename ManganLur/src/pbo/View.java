/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author Acer
 */
public class View {
    public static void menuAwal(){
        System.out.println("=====ManganLur=====");
        System.out.println("Set Role");
        System.out.println("1. Reviewer");
        System.out.println("2. Pihak Restoran");
        System.out.println("3. Admin");
        System.out.println("9. Keluar");
        System.out.println("=====ManganLur=====");
    }
    
    public static void menuAkun(){
        System.out.println("=====ManganLur=====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("=====ManganLur=====");
    }
    
    public static void menuReviewer(){
        System.out.println("=====ManganLur=====");
        System.out.println("1. Cari Restoran");
        System.out.println("2. Cari Makanan/Minuman");
        System.out.println("3. Review Restoran");
        System.out.println("4. Review Menu");
        
        System.out.println("=====ManganLur=====");
    }
    
    public static void menuPihakRestoran(){
        System.out.println("1. Kelola Restoran");
        System.out.println("2. Daftar Fasilitas");
    }
    
    public static void menuRestoran(){
        System.out.println("1. Jual Makanan/Minuman");
    }
    
    public static void menuResto(){
        System.out.println("1. Daftar Menu");
        System.out.println("2. Tambah Makanan/Minuman");
        System.out.println("3. Hapus Makanan/Minuman");
        System.out.println("4. Detail Makanan");
        System.out.println("5. Detail Minuman");
        System.out.println("6. Tampilkan Gambar");
        System.out.println("7. Daftar Harga");
    }
    
    public static void menuAdmin(){
        System.out.println("1. Masukkan Data Baru");
        System.out.println("2. Ambil Data");
        System.out.println("3. Kelola Data");
        System.out.println("4. Hapus Data");
    }
    
    public static void pilihanUser(){
        System.out.println("1. Reviewer");
        System.out.println("2. Restoran");
    }
}