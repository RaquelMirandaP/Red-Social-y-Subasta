/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author kduran
 */
public abstract class AbstractServer  {
    
    public ArrayList<IObservable> observables;

    public AbstractServer() throws IOException {
//        super("Server");
        observables = new ArrayList<>();
    }
    
    public void reply(){
        
    }
    
    public ArrayList<IObservable> getAllObservables() {
        return this.observables;
    }
    
    public void add(IObservable observable) {
        this.observables.add(observable);
    }
    
    public void readMessage() {
        
    }
    
//    public void startServer(int req) throws IOException {
//        try
//        {
//            System.out.println("Esperando..."); //Esperando conexión
//
//            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
//
//            System.out.println("Cliente en línea");
//
//            //Se obtiene el flujo de salida del cliente para enviarle mensajes
//            salidaCliente = new DataOutputStream(cs.getOutputStream());
//
//            //Se le envía un mensaje al cliente usando su flujo de salida
//            salidaCliente.writeUTF("Petición recibida y aceptada");
//
//            //Se obtiene el flujo entrante desde el cliente
//            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//
//            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
//            {
//                //Se muestra por pantalla el mensaje recibido
//                System.out.println(mensajeServidor);
//            }
//
//            System.out.println("Fin de la conexión");
//
//            ss.close();//Se finaliza la conexión con el cliente
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//    }
    
    public abstract void evaluete(SocketMessage socketMessage);
}
