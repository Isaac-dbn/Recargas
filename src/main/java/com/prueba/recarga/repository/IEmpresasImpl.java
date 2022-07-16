/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.GenericoJPA;
import static com.prueba.recarga.GenericoJPA.createEntityManager;
import com.prueba.recarga.dto.EmpresaDto;
import com.prueba.recarga.entity.Empresas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chas
 */
public class IEmpresasImpl extends GenericoJPA implements IEmpresas{
    
    @Override
    public List<EmpresaDto> getEmpresas() throws Exception{
        List<EmpresaDto> empresas = new ArrayList<>();
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
    
    private EmpresaDto entidadToDominio(Empresas entidad){
        EmpresaDto dominio = new EmpresaDto();
        dominio.setIdEmpresa(entidad.getIdEmpresa());
        dominio.setEmpresa(entidad.getNombre());
        return dominio;
    }
    
}
