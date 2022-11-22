/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;
/**
 *
 * @author Acer
 */
public class PihakRestoran extends User{
    private int idPihakRestoran;
    private String nik, noTelp;

    public PihakRestoran(int idPihakRestoran, String nik, String noTelp, int id, String nama, String username, String email, String password) {
        super(id, nama, username, email, password);
        this.idPihakRestoran = idPihakRestoran;
        this.nik = nik;
        this.noTelp = noTelp;
    }

    public int getIdPihakRestoran() {
        return idPihakRestoran;
    }

    public void setIdPihakRestoran(int idPihakRestoran) {
        this.idPihakRestoran = idPihakRestoran;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
    
    
}
