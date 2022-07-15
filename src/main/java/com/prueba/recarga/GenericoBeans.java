/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Chas
 */
public class GenericoBeans implements Serializable{
    
    private List<String> mensajes = new ArrayList<>();
    private List<String> alertas = new ArrayList<>();
    private List<String> errores = new ArrayList<>();

    public GenericoBeans() {
//        context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    }
    
    
    public void addMensaje(String mensaje){
        if(mensaje != null && !mensaje.isEmpty()){
            this.mensajes.add(mensaje);
        }
    }
    
    public void addAlerta(String alerta){
        if(alerta != null && !alerta.isEmpty()){
            this.alertas.add(alerta);
        }
    }
    
    public void addError(String error){
        if(error != null && !error.isEmpty()){
            this.errores.add(error);
        }
    }

    protected void generarMensajes(){
        this.mensajes.forEach(item -> {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", item));
        });
        this.alertas.forEach(item -> {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", item));
        });
        this.errores.forEach(item -> {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", item));
        });
        this.mensajes = new ArrayList<>();
        this.alertas = new ArrayList<>();
        this.errores = new ArrayList<>();
    }
    
    public List<String> getMensajes() {
        return mensajes;
    }   

    public List<String> getAlertas() {
        return alertas;
    }    

    public List<String> getErrores() {
        return errores;
    }

    
}
