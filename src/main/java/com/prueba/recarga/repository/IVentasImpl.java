/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.GenericoJPA;
import com.prueba.recarga.dto.EmpresaDto;
import com.prueba.recarga.dto.VenderoresDto;
import com.prueba.recarga.dto.VentasDto;
import com.prueba.recarga.entity.Empresas;
import com.prueba.recarga.entity.Vendedores;
import com.prueba.recarga.entity.Ventas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Chas
 */
public class IVentasImpl extends GenericoJPA implements IVentas{

    @Override
    public void guardar(VentasDto obj) throws Exception{
        EntityManager em = null ;
        try {
            em = createEntityManager();    
            em.getTransaction().begin();
            em.persist(dominioToEntidad(obj));            
            em.getTransaction().commit();
        } catch (Exception e) {
            Excepcion(GUARDAR, e);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    private Ventas dominioToEntidad(VentasDto obj){
        Ventas ent = new Ventas();
        ent.setEmpresas(new Empresas(obj.getIdOperador().getIdEmpresa()));
        ent.setFecha(new Date());
        ent.setNumero(obj.getCelular().toString().replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
        ent.setTotal(obj.getValorRecarga());
        ent.setVendedores(new Vendedores(obj.getIdVendedor().getIdVendedor()));
        return ent;
    }

    @Override
    public List<VentasDto> consultarVentas() throws Exception {
        List<VentasDto> lista = new ArrayList<>();
        try {
            String query = " SELECT v FROM Ventas v ";
            List<Ventas> listado = createEntityManager().createQuery(query).getResultList();
            listado.forEach(item -> {
                lista.add(entidadToDominio(item));
            }); 
        } catch (Exception e) {
            Excepcion(CONSULTA, e);
        }
        return lista;
    }
    
    private VentasDto entidadToDominio(Ventas ent){
        VentasDto obj = new VentasDto();
        obj.setIdVenta(ent.getIdVenta());
        obj.setIdOperador(new EmpresaDto(ent.getEmpresas().getIdEmpresa(), ent.getEmpresas().getNombre()));
        obj.setCelular(ent.getNumero());
        obj.setValorRecarga(ent.getTotal());
        obj.setIdVendedor(new VenderoresDto(ent.getVendedores().getIdVendedor(), ent.getVendedores().getNombre()));
        obj.setFecha(ent.getFecha().toString());
        return obj;        
    }
    
    
}
