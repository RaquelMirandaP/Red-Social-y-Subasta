/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;

public class Producto {
    
    public String nombre;
    public String descripcion;
    
    public double precioInicial;
    public double precioFinal;
    
    public Producto(String nombre, String descripcion, double precioInicial, double precioFinal){
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" +  "\n  nombre=" + nombre + ", descripcion=" + descripcion + ", precioInicial=" + precioInicial + ", precioFinal=" + precioFinal + '}';
    }
}