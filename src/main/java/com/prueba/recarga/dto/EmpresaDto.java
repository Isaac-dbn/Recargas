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
public class EmpresaDto {
    
    private Integer idEmpresa;
    private String empresa;

    public EmpresaDto() {
    }

    public EmpresaDto(int idEmpresa, String empresa) {
        this.idEmpresa = idEmpresa;
        this.empresa = empresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
       

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return empresa;
    }
    
    
}
