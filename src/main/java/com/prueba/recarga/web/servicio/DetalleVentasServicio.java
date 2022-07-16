/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.servicio;

import com.prueba.recarga.repository.IEmpresas;
import com.prueba.recarga.repository.IEmpresasImpl;
import com.prueba.recarga.repository.IVentas;
import com.prueba.recarga.repository.IVentasImpl;
import com.prueba.recarga.web.beans.ListaVentasBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chas
 */

public class DetalleVentasServicio implements Serializable {

    private IVentas iVentas;
    private IEmpresas iEmpresas = null;
    
    public DetalleVentasServicio() {
        if (iVentas == null) {
            iVentas = new IVentasImpl();
        }
        if (iEmpresas == null) {
            iEmpresas = new IEmpresasImpl();
        }
    }
    
    public void cargaInicial(ListaVentasBean bean){
        try {
            bean.setListadoEmpresas(iEmpresas.getEmpresas());
        } catch (Exception ex) {
            Logger.getLogger(DetalleVentasServicio.class.getName()).log(Level.SEVERE, ex.getMessage(), "");
            bean.addError(ex.getMessage());
        }
    }
    
    public void consultarListado(ListaVentasBean bean){
        try {
            bean.setListado(iVentas.consultarVentas());
        } catch (Exception ex) {
            Logger.getLogger(DetalleVentasServicio.class.getName()).log(Level.SEVERE, ex.getMessage(), "");
            bean.addError(ex.getMessage());
        }
    }

    public IVentas getiVentas() {
        return iVentas;
    }

    public void setiVentas(IVentas iVentas) {
        this.iVentas = iVentas;
    }
    
    
    
}
