/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

import InterfazGrafica.redSocialCelebrity;
import InterfazGrafica.redSocialFollower;
import api.AbstractServer;
import api.SocketMessage;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kduran
 */
public class Controller extends AbstractServer{
    
    public static final ArrayList<Celebridad> CELEBRITIES = new ArrayList<>();
    public static final String RECORD_LIKES = "RecordLikes";
    public static final String RECORD_SEGUIDORES = "RecordSeguidores";
    public static final ArrayList<Seguidor> FALLOWERS = new ArrayList<>();
    public static final String LIKE = "like";
    public static final String DIS_LIKE = "dislike";
    public static final String FOLLOW = "follow";
    public static final String POST = "post";
    public static final String LOGIN = "login";
    public static final String SING_IN_CELEBRITY = "singCelebrity";
    public static final String SING_IN_FOLLOWER = "singFollower";
    public static final String DARSE_BAJA = "baja";

    public Controller() throws IOException {
    }
    
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
    
    public static void seguir(Seguidor follower, Celebridad celebrity){
        follower.seguir(celebrity);
    }
    
    public static void postMessage(Celebridad celebridad, String message){
        celebridad.addPost(message);
    }

    public static void dislike(Seguidor follower, Mensaje message){
        follower.darDisLike(message);
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
    
    public static void like(Seguidor follower, Mensaje message){
        follower.darLike(message);
    }
    
    @Override
    public void evaluete(SocketMessage socketMessage) {
        switch (socketMessage.name) {
            case LIKE:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                Seguidor follower = (Seguidor) socketMessage.observer;
                like(follower, requestSocial.message);
                break;
            }
            case DIS_LIKE:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                Seguidor follower = (Seguidor) socketMessage.observer;
                dislike(follower, requestSocial.message);
                break;
            }
            case FOLLOW:
            {
                Seguidor follower = (Seguidor) socketMessage.observer;
                Celebridad celebrity = (Celebridad) socketMessage.observable;
                seguir(follower, celebrity);
                break;
            }
            case DARSE_BAJA:
            {
                Celebridad celebrity = (Celebridad) socketMessage.observable;
                darseBaja(celebrity);
                break;
            }
            case POST:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                Celebridad celebrity = (Celebridad) socketMessage.observable;
                postMessage(celebrity, requestSocial.post);
                break;
            }
            case LOGIN:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                login(requestSocial.userName, requestSocial.id);
                break;
            }
            case SING_IN_CELEBRITY:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                singInCelebrity(requestSocial.userName, requestSocial.id);
                break;
            }
            case SING_IN_FOLLOWER:
            {
                RequestSocial  requestSocial = (RequestSocial) socketMessage.request;
                singInFollower(requestSocial.userName, requestSocial.id);
                break;
            }
        }    
    }
}
