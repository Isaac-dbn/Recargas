/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.servicio;

import com.prueba.recarga.repository.IEmpresas;
import com.prueba.recarga.repository.IEmpresasImpl;
import com.prueba.recarga.repository.IProductos;
import com.prueba.recarga.repository.IProductosImpl;
import com.prueba.recarga.repository.IVendedores;
import com.prueba.recarga.repository.IVendedoresImpl;
import com.prueba.recarga.repository.IVentas;
import com.prueba.recarga.repository.IVentasImpl;
import com.prueba.recarga.web.beans.VentasBean;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chas
 */
public class VentasServicio implements Serializable {

    private IEmpresas iEmpresas = null;
    private IVendedores iVendedores = null;
    private IVentas iVentas;
    private IProductos iProductos;

    public VentasServicio() {
        if (iEmpresas == null) {
            iEmpresas = new IEmpresasImpl();
        }
        if (iVendedores == null) {
            iVendedores = new IVendedoresImpl();
        }
        if (iVentas == null) {
            iVentas = new IVentasImpl();
        }
        if (iProductos == null) {
            iProductos = new IProductosImpl();
        }
    }

    public void cargaInicial(VentasBean bean) {
        try {
            bean.setListaempresas(iEmpresas.getEmpresas());
            bean.setListaVendedores(iVendedores.getListaVendedores());            
        } catch (Exception ex) {
            Logger.getLogger(VentasServicio.class.getName()).log(Level.SEVERE, ex.getMessage(), "");
            bean.addError(ex.getMessage());
        }
    }
    
    public void consultarProductos(VentasBean bean){
        try {
            bean.setListaProducto(iProductos.getProductos(bean.getVentas().getIdOperador().getIdEmpresa()));
        } catch (Exception e) {
            Logger.getLogger(VentasServicio.class.getName()).log(Level.SEVERE, e.getMessage(), "");
            bean.addError(e.getMessage());
        }
    }

    public void guardarRecarga(VentasBean bean) {
        try {
            boolean guardar = true;
            if (bean.getVentas().getIdOperador().getIdEmpresa() == null) {
                bean.addAlerta("Debe seleccionar el operador");
                guardar = false;
            }
            if (bean.getVentas().getCelular() == null || bean.getVentas().getCelular().isEmpty()) {
                bean.addAlerta("Debe agregar el número celular");
                guardar = false;
            }
            if (bean.getVentas().getValorRecarga() == null || bean.getVentas().getValorRecarga().isEmpty()) {
                bean.addAlerta("Debe ingresar el valor de la recarga");
                guardar = false;
            }
            if (bean.getVentas().getIdVendedor().getIdVendedor() == null) {
                bean.addAlerta("Debe indicar el vendedor que hizo la recarga");
                guardar = false;
            }
            if (guardar) {
                iVentas.guardar(bean.getVentas());
                bean.addMensaje("Recarga realizada correctamente");
            }            
        } catch (Exception e) {
            bean.addError(e.getMessage());
        }
    }
    

}
