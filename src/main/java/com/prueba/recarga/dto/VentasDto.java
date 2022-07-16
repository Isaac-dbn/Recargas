/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.dto;

/**
 *
 * @author Chas
 */
public class VentasDto {
    
    private Integer idVenta;
    private EmpresaDto idOperador;
    private String celular;
    private String valorRecarga;
    private VenderoresDto idVendedor;
    private String fecha;
    
    

    public VentasDto() {
        idOperador = new EmpresaDto();
        idVendedor = new VenderoresDto();
    }
    

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public EmpresaDto getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(EmpresaDto idOperador) {
        this.idOperador = idOperador;
    }

    public VenderoresDto getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(VenderoresDto idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(String valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

   
    
    
    
}
