/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosubastaapp;

import clases_subasta.Oferente;
import clases_subasta.Producto;
import clases_subasta.Subasta;
import clases_subasta.Subastador;

/**
 *
 * @author marco
 */
public class ProyectoSubastaAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Subastador subastador = new Subastador(100);
        
        Producto producto1 = new Producto("VENUS", "PLANETA PEQUEÑILLO QUE PEREZA", 100, 1000);
        
        // INFORMACIÓN SUBASTA 
        String nombreSubasta = "Subasta # 1";
        String descripcionSubasta = "Planetas en Subasta APROVECHEE";
        String estadoSubasta = "Abierta";
        String fechaInicioSubasta = "Hoy";
        String fechaFinSubasta = "Mañana";
       
        
        subastador.comenzarSubasta(producto1, nombreSubasta, descripcionSubasta, estadoSubasta, fechaInicioSubasta, fechaFinSubasta);
        
        Oferente oferente1 = new Oferente(100, "Marco");
        subastador.agregarOferenteASubasta(oferente1);
        
        Oferente oferente2 = new Oferente(200, "Kri");
        subastador.agregarOferenteASubasta(oferente2);
        
        System.out.println(subastador.consultarSubasta());
        
        subastador.aceptarOferta(1050.10);
        
        System.out.println(subastador.consultarSubasta());
    }
}