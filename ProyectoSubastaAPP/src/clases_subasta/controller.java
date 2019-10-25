/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;

import api.AbstractServer;
import api.SocketMessage;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class controller extends AbstractServer{
    public static final ArrayList<Subasta> subastas = new ArrayList<>();
    public static final ArrayList<Oferente> oferentes = new ArrayList<>();
    public static final ArrayList<Subastador> subastadores = new ArrayList<>();
    public static final String COLOCAR_PRODUCTO = "colocarProducto";
    public static final String ACEPTAR_OFERTAS = "aceptarProducto";
    public static final String CERRAR_SUBASTAS= "cerrarSubasta";
    public static final String CANCELAR_SUBASTAS = "cancelarSubasta";
    public static final String ENVIAR_MENSAJE = "enviarMensaje";
    public static final String UNIRSE_SUBASTA = "unirseSubasta";
    public static final String OFERTAR= "ofertar";
  
    public controller() throws IOException {
    }
    public static Subasta getSubasta(String nombre){
        for (Subasta subasta : subastas) {
            if(subasta.getNombre() == nombre){
                return subasta;
            }
        }
        return null;
    }
    public static Oferente getOferente(int id){
        for (Oferente oferente : oferentes) {
            if(oferente.getIdOferente()== id){
                return oferente;
            }
        }
        return null;
    }
    
     public static Subastador getSubastador(int id){
        for (Subastador subastador : subastadores) {
            if(subastador.getId()== id){
                return subastador;
            }
        }
        return null;
    }
    public static  void colocarProducto(Subasta subasta, Mensaje mensaje){
        subasta.setProductoSubasta(mensaje.getProducto());
    }
    public static void aceptarOfertas(Subastador subastador, Mensaje ms){
       subastador.aceptarOferta(Double.parseDouble(ms.getTexto()));
    }
    public static void cancelarSubastas(Subasta subasta, Mensaje ms){
     subasta.setEstado(ms.getTexto());
    }
    public static void cerrarSubastas(Subasta subasta, Mensaje ms){
     subasta.setEstado(ms.getTexto());
    }
    public static void enviarMensaje(Subastador subastador, Mensaje ms){
        subastador.enviarMensaje(ms);
    }
    public static void unirseSubasta(Subasta subasta, Oferente oferente){
        subasta.addObserver(oferente);
    }
    public static void ofertar(Oferente oferente, Mensaje me){
        oferente.ofertar(me);
    }
    
    @Override
    public void evaluete(SocketMessage socketMessage) {
        switch (socketMessage.name) {
            case COLOCAR_PRODUCTO:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Subasta subasta = (Subasta) socketMessage.observable;
                colocarProducto(subasta, request.getMensaje());
                break;
            }
            case ACEPTAR_OFERTAS:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Subastador subastador = (Subastador) socketMessage.observable;
                aceptarOfertas(subastador, request.getMensaje());
                break;
            }
            case CERRAR_SUBASTAS:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Subasta subasta = (Subasta) socketMessage.observable;
                cerrarSubastas(subasta, request.getMensaje());
                break;
            }
            case CANCELAR_SUBASTAS:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Subasta subasta = (Subasta) socketMessage.observable;
                cerrarSubastas(subasta, request.getMensaje());
                break;
            }
            case ENVIAR_MENSAJE:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Subastador subastador = (Subastador) socketMessage.observable;
                enviarMensaje(subastador, request.getMensaje());
                break;
            }
            case UNIRSE_SUBASTA:
            {
                Subasta subasta = (Subasta) socketMessage.observable;
                Oferente oferente = (Oferente) socketMessage.observer;
                unirseSubasta(subasta, oferente);
                break;
            }
            case OFERTAR:
            {
                RequestSubasta  request = (RequestSubasta) socketMessage.request;
                Oferente oferente = (Oferente) socketMessage.observer;
                ofertar(oferente, request.getMensaje());
                break;
            }
        }
        
    }
}
