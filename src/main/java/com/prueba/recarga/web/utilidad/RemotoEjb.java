/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.recarga.web.utilidad;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Chas
 */
public class RemotoEjb {
    
    public static Object getEJBRemoto(String nameEjb, String iface) throws Exception {
        Object object = null;
        try {
            Properties props = new Properties();
            props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//            props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:7070");
//            props.put(Context.SECURITY_PRINCIPAL, "savia");
//            props.put(Context.SECURITY_CREDENTIALS, "savia");
//            props.put("jboss.naming.client.ejb.context", true);
            Context context = new InitialContext(props);
            String preContext = "ejb:/Recarga-1.0//"+nameEjb+"!"+iface;
            //String nombre = preContext + nameEjb ;
            object = context.lookup(preContext);
        } catch (NamingException ex) {
            throw new Exception("It was not possible to connect to the remote EJB " + nameEjb + " : " + ex.getMessage());
        } catch (Exception ex) {
            throw new Exception("It was not possible to connect to the remote EJB " + nameEjb+ " : " + ex.getMessage());
        }
        return object;
    }
    
}
