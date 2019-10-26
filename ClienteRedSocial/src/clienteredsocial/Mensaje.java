/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

/**
 *
 * @author kduran
 */
public class Mensaje {
    private int id;
    private String texto;
    private int likes = 0;
    private int dislikes = 0;

    public Mensaje(String texto, int id) {
        this.texto = texto;
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes() {
        this.likes += 1;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes() {
        this.dislikes += 1;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Mensaje: " + texto + "\nLikes:" + likes + " Dislikes:" + dislikes;
    }
    
    public String toStringFollower() {
        return id + "Mensaje: " + texto + "\nLikes:" + likes + " Dislikes:" + dislikes;
    }
}
