/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;

/**
 *
 * @author kduran
 */
public class Mensaje {
    private int id;
    private Producto producto;
    private Oferente oferente;
    private Subastador subastador;
    private Subasta subasta;
    private String texto;

    public Mensaje(int id, Producto producto, Oferente oferente, Subastador subastador, Subasta subasta, String texto) {
        this.id = id;
        this.producto = producto;
        this.oferente = oferente;
        this.subastador = subastador;
        this.subasta = subasta;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Oferente getOferente() {
        return oferente;
    }

    public void setOferente(Oferente oferente) {
        this.oferente = oferente;
    }

    public Subastador getSubastador() {
        return subastador;
    }

    public void setSubastador(Subastador subastador) {
        this.subastador = subastador;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    

    
}
