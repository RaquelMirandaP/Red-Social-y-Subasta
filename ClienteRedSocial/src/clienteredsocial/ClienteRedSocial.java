/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

import InterfazGrafica.Login;
import api.AbstractServer;

/**
 *
 * @author kduran
 */
public class ClienteRedSocial{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Celebridad celebridad = new Celebridad(767, "Kris");
        celebridad.addPost("Hola mucho gusto");
        celebridad.addPost("Tengo sueño");
        celebridad.addPost("Aaaaaaay");
        celebridad.addPost("Buuuu");
        Seguidor seguidor = new Seguidor(787, "Raque");
        seguidor.seguir(celebridad);
        Controller.FALLOWERS.add(seguidor);
        Seguidor seguidor2 = new Seguidor(788, "Luz");
        Controller.FALLOWERS.add(seguidor2);
        Seguidor seguidor3 = new Seguidor(786, "Ada");
        Controller.FALLOWERS.add(seguidor3);
        
        celebridad.addFan(seguidor2);
        celebridad.addFan(seguidor3);
        Celebridad celebridad2 = new Celebridad(988, "Ronny");
        celebridad2.addPost("Holaaaaa");
        Controller.CELEBRITIES.add(celebridad);
        Controller.CELEBRITIES.add(celebridad2);
        
        Login login = new Login();
        login.setVisible(true);
    }
    
}
