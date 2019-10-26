/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.ArrayList;

/**
 *
 * @author kduran
 */
public class AbstractObservable implements IObservable{
    private final ArrayList<IObserver> observers = new ArrayList<>();
          
    @Override       
    public void addObserver(IObserver observer) {           
        this.observers.add(observer);
    }                 
    
    @Override       
    public void removeObserver(IObserver observer) {           
        this.observers.remove(observer);
    }          
    
    @Override       
    public void notifyAllObservers(String command, Object source) {           
        for (IObserver observer : observers) {               
            observer.notify(command, source);
        }           
    }
    
}
