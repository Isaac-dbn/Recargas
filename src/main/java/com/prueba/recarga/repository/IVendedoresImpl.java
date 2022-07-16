/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.GenericoJPA;
import com.prueba.recarga.dto.VenderoresDto;
import com.prueba.recarga.entity.Vendedores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chas
 */
public class IVendedoresImpl extends GenericoJPA implements IVendedores{

    @Override
    public List<VenderoresDto> getListaVendedores() throws Exception{
        List<VenderoresDto> vendedores = new ArrayList<>();
        try {
            String query = " SELECT v FROM Vendedores v ";
            List<Vendedores> lista = createEntityManager().createQuery(query).getResultList();
            lista.forEach(item -> {
                vendedores.add(entidadToDominio(item));
            }); 
        } catch (Exception e) {
            Excepcion(CONSULTA, e);
        }
        return vendedores;
    }
    
    private VenderoresDto entidadToDominio(Vendedores entidad){
        VenderoresDto dto = new VenderoresDto();
        dto.setIdVendedor(entidad.getIdVendedor());
        dto.setNombre(entidad.getNombre());
        return dto;
    }
    
    
}
