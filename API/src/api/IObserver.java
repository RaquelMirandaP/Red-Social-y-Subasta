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
public interface IObserver {
    public void notify(String command, Object source);
}
