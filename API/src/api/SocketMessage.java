/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author kduran
 */
public class SocketMessage {
    public IObserver observer;
    public IObservable observable;
    public String name;
    public Request request;

    public SocketMessage(IObserver observer, IObservable observable, String name, Request request) {
        this.observer = observer;
        this.observable = observable;
        this.name = name;
        this.request = request;
    }
    
}
