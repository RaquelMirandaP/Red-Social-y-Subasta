/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_subasta;

import api.IObserver;

public class Subastador implements api.IObservable{
    
    public Subasta subastaEnCurso;
    public Producto productoSubastado;
    
    public int id;
    
    
    public Subastador(int id){
        
        this.id = id;
    }
    
    public void comenzarSubasta(Producto producto, 
            String nombreSubasta, String descripcionSubasta, String estadoSubasta, 
            String fechaInicioSubasta, String fechaFinSubasta){
    
        Subasta subasta = new Subasta(producto, nombreSubasta, descripcionSubasta,
                estadoSubasta, fechaInicioSubasta, fechaFinSubasta);
        
        this.subastaEnCurso = subasta;
    }
    
    public void agregarOferenteASubasta(IObserver oferente){
        this.subastaEnCurso.addObserver(oferente);
    }
    
    public String consultarSubasta(){
    
        String informacionSubasta = "";
        
        informacionSubasta = this.subastaEnCurso.toString();
        
        return informacionSubasta;
    }
    
    public void aceptarOferta(double nuevaOferta){
    
        this.subastaEnCurso.subirApuesta(nuevaOferta);
    }
    
    
   public void enviarMensaje(Mensaje mensaje){
       controller.getOferente(mensaje.getId());
   }
    public Subasta getSubastaEnCurso() {
        return subastaEnCurso;
    }

    public void setSubastaEnCurso(Subasta subastaEnCurso) {
        this.subastaEnCurso = subastaEnCurso;
    }

    public Producto getProductoSubastado() {
        return productoSubastado;
    }

    public void setProductoSubastado(Producto productoSubastado) {
        this.productoSubastado = productoSubastado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    @Override
    public void addObserver(IObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(IObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyAllObservers(String command, Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
