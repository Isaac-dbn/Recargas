/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.dto;

import java.io.Serializable;

/**
 *
 * @author Chas
 */
public class VenderoresDto implements Serializable{
    
    private Integer idVendedor;
    private String nombre;

    public VenderoresDto() {
    }

    public VenderoresDto(int idVendedor, String nombre) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
