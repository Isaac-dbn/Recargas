/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.beans;

import com.prueba.recarga.GenericoBeans;
import com.prueba.recarga.dominio.EmpresaDominio;
import com.prueba.recarga.dominio.VentasDominio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Chas
 */
@Named
@ViewScoped
public class VentasBean extends GenericoBeans implements Serializable{
 
            
    private VentasDominio ventas;
    private List<EmpresaDominio> listaempresas;
    
 
    public VentasBean() {
        //super.setContext(FacesContext.getCurrentInstance());      
        listaempresas = new ArrayList<>();
        ventas = new VentasDominio();
        addMensaje("Bienvenido");
    }

        
    @PostConstruct
    public void cargaInicial() {           
    }
    
    public void guardar(){
        
    }

    public VentasDominio getVentas() {
        return ventas;
    }

    public void setVentas(VentasDominio ventas) {
        this.ventas = ventas;
    }
    
    public List<EmpresaDominio> getListaempresas() {
        return listaempresas;
    }

    public void setListaempresas(List<EmpresaDominio> listaempresas) {
        this.listaempresas = listaempresas;
    }
    
    public void mostrarMensajes(){
        generarMensajes();
    }
       
}
