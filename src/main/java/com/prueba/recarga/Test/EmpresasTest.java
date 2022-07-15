/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.Test;

import com.prueba.recarga.dominio.EmpresaDominio;
import com.prueba.recarga.repository.IEmpresas;
import com.prueba.recarga.web.servicio.EmpresaServicio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chas
 */
public class EmpresasTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IEmpresas empresa = new EmpresaServicio();
            List<EmpresaDominio> lista = empresa.getEmpresas();
            lista.forEach(item -> {
                System.err.println("Empresa : " + item.getEmpresa());
            });
        } catch (Exception ex) {
            Logger.getLogger(EmpresasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
