/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

import InterfazGrafica.redSocialCelebrity;
import InterfazGrafica.redSocialFollower;
import java.util.ArrayList;

/**
 *
 * @author kduran
 */
public class Controller {
    public static final ArrayList<Celebridad> CELEBRITIES = new ArrayList<>();
    public static final String RECORD_LIKES = "RecordLikes";
    public static final String RECORD_SEGUIDORES = "RecordSeguidores";
    public static final ArrayList<Seguidor> FALLOWERS = new ArrayList<>();
    
    public static Celebridad getCelebridad(int id){
        for (Celebridad celebridad : CELEBRITIES) {
            if(celebridad.getId() == id){
                return celebridad;
            }
        }
        return null;
    }
    
    public static Seguidor getFans(int id){
        for (Seguidor fan : FALLOWERS) {
            if(fan.getId() == id){
                return fan;
            }
        }
        return null;
    }

    public static void sendMensajeFans(Seguidor fan, String mensaje){
        
    }
    
    public static void sendMensajeCelebridades(Celebridad celebridad, String mensaje){
        
    }
    
    public static void seguir(int idSeguidor, Celebridad celebrity){
        Seguidor seguir = getFans(idSeguidor);
        seguir.seguir(celebrity);
    }
    
    public static void postMessage(int idCelebridad, String message){
        Celebridad celebridad = getCelebridad(idCelebridad);
        celebridad.addPost(message);
    }

    public static void dislike(int idSeguidor, int idMessage, int idCelebridad){
        Seguidor seguidor = getFans(idSeguidor);
        seguidor.darDisLike(idCelebridad, idMessage);
    }
    
    public static boolean login(String user, int id){
        Celebridad celebrity = getCelebridad(id);
        if(celebrity != null) {
            if (celebrity.getNombre().equals(user)) {
                redSocialCelebrity window = new redSocialCelebrity(celebrity);
                window.setVisible(true);
            }
        } else {
            Seguidor follower = getFans(id);
            if(follower != null) {
                if (follower.getNombre().equals(user)) {
                    redSocialFollower window = new redSocialFollower(follower);
                    window.setVisible(true);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean singInCelebrity(String userName, int id){
        if (getCelebridad(id) == null) {
            Celebridad celebrity = new Celebridad(id, userName);
            CELEBRITIES.add(celebrity);
            return true;
        }
        return false;
    }
    
    public static boolean singInFollower(String userName, int id){
        if (getFans(id) == null) {
            Seguidor follower = new Seguidor(id, userName);
            FALLOWERS.add(follower);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Mensaje> getPostCelebrities(Seguidor follower){
        ArrayList<Mensaje> messages = new ArrayList<>();
        for (Celebridad celebrity : follower.getCelebrities()) {
            for (Mensaje message : celebrity.getPosts()) {
                messages.add(message);
            }
        }
        return messages;
    }
    
    public static ArrayList<String> getMessages(Seguidor follower){
        return follower.getMensajes();
    }
    
    public static ArrayList<Mensaje> getPosts(Celebridad celebrity) {
        return celebrity.getPosts();
    }
    
    public static ArrayList<Seguidor> getFollowers(Celebridad celebrity) {
        return celebrity.getFans();
    }
    
    public static void darseBaja(Celebridad celebridad){
        celebridad.setState(false);
    }
}