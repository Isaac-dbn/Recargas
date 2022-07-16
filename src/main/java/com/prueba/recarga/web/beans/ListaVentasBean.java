/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.beans;

import com.prueba.recarga.GenericoBeans;
import com.prueba.recarga.dto.EmpresaDto;
import com.prueba.recarga.dto.VentasDto;
import com.prueba.recarga.web.servicio.DetalleVentasServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Chas
 */
@Named
@ViewScoped
public class ListaVentasBean extends GenericoBeans implements Serializable{
    
    
    private DetalleVentasServicio detalleServicio;    
    private List<VentasDto> listado;
    private List<VentasDto> listadoFiltro;
    private List<EmpresaDto> listadoEmpresas;

    public ListaVentasBean() {
        detalleServicio = new DetalleVentasServicio();
        listado = new ArrayList<>();   
        detalleServicio.cargaInicial(this);
    }
    
    @PostConstruct
    public void init(){
        detalleServicio.consultarListado(this);
    }
    
    
    public List<VentasDto> getListado() {
        return listado;
    }

    public void setListado(List<VentasDto> listado) {
        this.listado = listado;
    }

    public List<VentasDto> getListadoFiltro() {
        return listadoFiltro;
    }

    public void setListadoFiltro(List<VentasDto> listadoFiltro) {
        this.listadoFiltro = listadoFiltro;
    }

    public List<EmpresaDto> getListadoEmpresas() {
        return listadoEmpresas;
    }

    public void setListadoEmpresas(List<EmpresaDto> listadoEmpresas) {
        this.listadoEmpresas = listadoEmpresas;
    }
        
}
