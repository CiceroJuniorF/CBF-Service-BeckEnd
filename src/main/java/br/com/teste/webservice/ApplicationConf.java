package br.com.teste.webservice;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ApplicationConf extends Application
{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.teste.webservice.endpoint.ProductEndpoint.class);
        resources.add(br.com.teste.webservice.endpoint.AjudanteEndpoint.class);
        resources.add(br.com.teste.webservice.endpoint.MasterEndpoint.class);
        resources.add(br.com.teste.webservice.endpoint.VendedorEndpoint.class);
    
    }
}
