/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Chas
 */
public class GenericoJPA {
    
    private static EntityManagerFactory entityManagerFactory = null;
    protected static final String CONSULTA="CONSULTA";
    protected static final String GUARDAR="GUARDAR";
    protected static final String ACTUALIZAR="ACTUALIZAR";
    protected static final String ELIMINAR="ELIMINAR";
    protected static final String ERROR_CONEXION="ERROR_CONEXION";
    
    public static EntityManager createEntityManager(){
        try {
            if(entityManagerFactory == null){
                entityManagerFactory = Persistence.createEntityManagerFactory("recargasPU");
            }           
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
         return entityManagerFactory.createEntityManager();
    }
    
    public static void desconectar(EntityManager entityManager){
        if(entityManager != null){
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    
    protected void Excepcion(String key, Exception ex, String ... values) throws Exception{
        if(entityManagerFactory == null){
            throw new Exception(getMensajeExcepcion(ERROR_CONEXION, ex, values));
        }else {
            throw new Exception(getMensajeExcepcion(key, ex, values));
        }        
    }
    
    private String getMensajeExcepcion(String key, Exception ex, String ... values) {
        String mensaje;
        switch (key){
            case CONSULTA:
                mensaje = "Error al consultar información";
                break;
            case GUARDAR:
                mensaje = "Error al guardar registros";
                break;
            case ACTUALIZAR:
                mensaje = "Error al modificar registros";
                break;
            case ELIMINAR:
                mensaje = "Error al eliminar registros";
                break;
            case ERROR_CONEXION:
                mensaje = "Existe inconveniente al conectarse a la fuente de datos, valida tu conexión.";
                break;
            default:
                mensaje = "Error " + key;
                break;
        }
        mensaje += "("+ex.getMessage()+")";
        for(String valor : values){
            mensaje += "\n - "+valor;
        }
        return mensaje;
    }
}
