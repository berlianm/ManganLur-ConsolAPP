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
public class Reviewer extends User{
    private int idReviewer;

    public Reviewer(int idReviewer, int id, String nama, String username, String email, String password) {
        super(id, nama, username, email, password);
        this.idReviewer = idReviewer;
    }

    public int getIdReviewer() {
        return idReviewer;
    }

    public void setIdReviewer(int idReviewer) {
        this.idReviewer = idReviewer;
    }

    
}
