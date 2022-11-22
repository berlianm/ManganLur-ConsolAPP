/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo;

/**
 *
 * @author Acer
 */
public class Restoran {
    private int id, tempat_duduk;
    private String nama, alamat, layanan, nomorTelepon;

    public Restoran(int id, String nama, int tempat_duduk, String alamat, String layanan, String nomorTelepon) {
        this.id = id;
        this.tempat_duduk = tempat_duduk;
        this.nama = nama;
        this.alamat = alamat;
        this.layanan = layanan;
        this.nomorTelepon = nomorTelepon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempat_duduk() {
        return tempat_duduk;
    }

    public void setTempat_duduk(int tempat_duduk) {
        this.tempat_duduk = tempat_duduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
    
    
}
