/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;
import api.Request;
/**
 *
 * @author raque
 */
public class RequestSubasta implements Request{
    private Mensaje mensaje;
    private String name;

    public RequestSubasta(Mensaje mensaje, String name) {
        this.mensaje = mensaje;
        this.name = name;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    
    
}
