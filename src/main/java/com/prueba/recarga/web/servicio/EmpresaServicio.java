/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.servicio;

import com.prueba.recarga.GenericoJPA;
import com.prueba.recarga.dominio.EmpresaDominio;
import com.prueba.recarga.entity.Empresas;
import com.prueba.recarga.repository.IEmpresas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chas
 */
public class EmpresaServicio extends GenericoJPA implements IEmpresas{

    @Override
    public List<EmpresaDominio> getEmpresas() throws Exception{
        List<EmpresaDominio> empresas = new ArrayList<>();
        try {
            String query = " SELECT e FROM Empresas e ";
            List<Empresas> lista = createEntityManager().createQuery(query).getResultList();
            lista.forEach(item -> {
                empresas.add(entidadToDominio(item));
            }); 
        } catch (Exception e) {
            Excepcion(CONSULTA, e);
        }
        return empresas;
    }
    
    private EmpresaDominio entidadToDominio(Empresas entidad){
        EmpresaDominio dominio = new EmpresaDominio();
        dominio.setIdEmpresa(entidad.getIdEmpresa());
        dominio.setEmpresa(entidad.getNombre());
        return dominio;
    }
    
}
