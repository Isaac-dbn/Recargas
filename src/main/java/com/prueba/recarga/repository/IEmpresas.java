/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.dto.EmpresaDto;
import java.util.List;

/**
 *
 * @author Chas
 */
public interface IEmpresas  {
    
    List<EmpresaDto> getEmpresas() throws Exception ;
    
}
