/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.beans;

import com.prueba.recarga.GenericoBeans;
import com.prueba.recarga.dto.EmpresaDto;
import com.prueba.recarga.dto.ProductosDto;
import com.prueba.recarga.dto.VenderoresDto;
import com.prueba.recarga.dto.VentasDto;
import com.prueba.recarga.web.servicio.VentasServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Chas
 */
@Named
@ViewScoped
public class VentasBean extends GenericoBeans implements Serializable{
     
    private VentasServicio ventasServicio;            
    private VentasDto ventas;
    private List<EmpresaDto> listaempresas;
    private List<VenderoresDto> listaVendedores;
    private List<ProductosDto> listaProducto;
    
 
    public VentasBean() {
        listaempresas = new ArrayList<>();
        listaVendedores = new ArrayList<>();
        ventas = new VentasDto();
        ventasServicio = new VentasServicio();
    }

        
    @PostConstruct
    public void init() {    
        ventasServicio.cargaInicial(this);
    }
    
    
    public void guardarRecarga(){
        ventasServicio.guardarRecarga(this);
        this.ventas = new VentasDto();
        PrimeFaces.current().resetInputs("frmCrear:panel");
        PrimeFaces.current().ajax().update("frmCrear");
        mostrarMensajes();
    }
    
    public void consultarProductos(){
        ventasServicio.consultarProductos(this);
        mostrarMensajes();
    }
    
   
    public VentasDto getVentas() {
        return ventas;
    }

    public void setVentas(VentasDto ventas) {
        this.ventas = ventas;
    }
    
    public List<EmpresaDto> getListaempresas() {
        return listaempresas;
    }

    public void setListaempresas(List<EmpresaDto> listaempresas) {
        this.listaempresas = listaempresas;
    }

    public List<VenderoresDto> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<VenderoresDto> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public VentasServicio getVentasServicio() {
        return ventasServicio;
    }

    public void setVentasServicio(VentasServicio ventasServicio) {
        this.ventasServicio = ventasServicio;
    }

    public List<ProductosDto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<ProductosDto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public void mostrarMensajes(){
        generarMensajes();
    }
    
           
}
