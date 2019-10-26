/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

import api.IObserver;
import java.util.ArrayList;

/**
 *
 * @author kduran
 */
public class Seguidor implements IObserver{
    
    private int id;
    private String nombre;
    private ArrayList<String> mensajes;
    private ArrayList<Celebridad> celebridades;
    
    public Seguidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.mensajes = new ArrayList<>();
        this.celebridades = new ArrayList<>();
    }

    public ArrayList<String> getMensajes() {
        return mensajes;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Celebridad> getCelebrities(){
        ArrayList<Celebridad> celebridades = new ArrayList<>();
        for (Celebridad celebridade : this.celebridades) {
            if (celebridade.isState()) {
                celebridades.add(celebridade);
            }
        }
        return celebridades;
    }
    
    @Override
    public void notify(String command, Object source) {
        String mensaje = "";
        System.out.println("Aquiiiiiiiii");
        if(command.equals(Controller.RECORD_LIKES)){
            mensaje += "La celibridad " + " ha conseguido "+ " likes";
        }if(command.equals(Controller.RECORD_SEGUIDORES)){
            mensaje += "La celibridad " + " ha conseguido " + " seguidores";
        }
        if(!mensaje.equals("")){
            Controller.sendMensajeFans(this, mensaje);
            mensajes.add(mensaje);
        }
    }

    public void seguir(Celebridad celebrity){
        celebrity.addFan(this);
        celebridades.add(celebrity);
        celebridades.
    }
    
    public void darDisLike(Mensaje message){
        Celebridad celebridad = Controller.getCelebridad(message.getId());
        celebridad.dislike(message);
    }
    
    public void darLike(Mensaje message){
        Celebridad celebridad = Controller.getCelebridad(message.getId());
        celebridad.likeMessage(message);
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + nombre;
    }
}
