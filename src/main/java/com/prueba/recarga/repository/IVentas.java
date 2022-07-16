/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.repository;

import com.prueba.recarga.dto.VentasDto;
import java.util.List;

/**
 *
 * @author Chas
 */
public interface IVentas {
    
    void guardar(VentasDto obj) throws Exception;
    
    List<VentasDto> consultarVentas() throws Exception;
    
}
