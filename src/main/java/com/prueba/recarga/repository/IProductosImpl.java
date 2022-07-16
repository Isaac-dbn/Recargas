/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.GenericoJPA;
import com.prueba.recarga.dto.ProductosDto;
import com.prueba.recarga.entity.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chas
 */
public class IProductosImpl extends GenericoJPA implements IProductos{

    @Override
    public List<ProductosDto> getProductos(Integer idEmpresa) throws Exception{
        List<ProductosDto> productos = new ArrayList<>();
        try {
            String query = " SELECT p FROM Productos p WHERE p.empresas.idEmpresa = " + idEmpresa;
            List<Productos> lista = createEntityManager().createQuery(query).getResultList();
            lista.forEach(item -> {
                productos.add(entidadToDominio(item));
            }); 
        } catch (Exception e) {
            Excepcion(CONSULTA, e);
        }
        return productos;
    }
    
    
    private ProductosDto entidadToDominio(Productos ent){
        ProductosDto obj = new ProductosDto();
        obj.setIdProducto(ent.getIdProducto());
        obj.setProducto(ent.getNombreProducto());
        obj.setIdEmpresa(ent.getEmpresas().getIdEmpresa());
        return obj;
    }
    
    
}
