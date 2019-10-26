/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteredsocial;

import api.Request;

/**
 *
 * @author kduran
 */
public class RequestSocial implements Request{
    
    public Mensaje message;
    public String post;
    public String userName;
    public int id;

    public RequestSocial(Mensaje message, String post, String userName, int id) {
        this.message = message;
        this.post = post;
        this.userName = userName;
        this.id = id;
    }
    
    
}
