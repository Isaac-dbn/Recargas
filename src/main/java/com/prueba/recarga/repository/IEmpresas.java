/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.dominio.EmpresaDominio;
import java.util.List;

/**
 *
 * @author Chas
 */
public interface IEmpresas  {
    
    List<EmpresaDominio> getEmpresas() throws Exception ;
    
}
