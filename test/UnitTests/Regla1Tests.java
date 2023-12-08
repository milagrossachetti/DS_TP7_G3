/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import dstp7.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import  static  org.junit.jupiter.api.Assertions.*;

public class Regla1Tests  {
    
    public Regla1Tests() {
        Repositorio.iniciar();
    }

    @Test
    public void siNoHayProductosDePanaderiaElDescuentoEsCero(){
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[1], 2);

        //Ejecución
        double descuento = regla.calcularDescuento(venta);

        //Comprobación
        assertEquals (0, descuento, 0);
    }

    @Test
    public void llevandoDosProductosDePanaderiaElSegundoTieneDescuentoAlCincuentaPorCiento(){
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 2);
        
        //Ejecución
        double descuento = regla.calcularDescuento(venta);
        
        //Comprobación
        assertEquals (25, descuento, 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,10})
    public void llevandoTresOMasProductosDePanaderiaElSegundoYTerceroTieneDescuentoAlCincuentaPorCiento(int cantidades){
        //Datos o definiciones
        Regla1 regla = new Regla1(Repositorio.getRubros()[0]);
        Venta venta = new Venta();
        venta.agregarDetalle(Repositorio.getProductos()[0], 3);

        //Ejecución
        double descuento = regla.calcularDescuento(venta);

        //Comprobación
        assertEquals (50, descuento, 0);
    }
}
