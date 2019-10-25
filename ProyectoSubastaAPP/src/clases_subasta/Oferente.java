/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;

import api.IObserver;

public class Oferente implements IObserver{

    public int idOferente;
    public String nombre;
   
    
    public Oferente (int idOferente, String nombre){ 
        
        this.idOferente = idOferente;
        this.nombre = nombre;
    }
    public void recibirMensaje(String mensaje){
        System.out.println(" "+ mensaje);
    }
    @Override
    public void notify(String s, Object o) {
        System.out.println("Oferente: " + this.nombre + " la apuesta ha sido aumentada"); // ACCION A REALIZAR LUEGO DE QUE SE AUMENTA LA SUBASTA
    }
    
    public int getIdOferente(){
        
        return this.idOferente;
    }
    
    public void setIdOferente(int idOferente){
        
        this.idOferente = idOferente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void ofertar(Mensaje mensaje){
       Subasta subasta = controller.getSubasta(mensaje.getSubasta().getNombre());
       subasta.listaOferentes_Observadores.add((IObserver) mensaje);
    }

    @Override
    public String toString() {
        return "\n  Oferentes{" + "idOferente=" + idOferente + ", nombre=" + nombre + '}';
    }
}