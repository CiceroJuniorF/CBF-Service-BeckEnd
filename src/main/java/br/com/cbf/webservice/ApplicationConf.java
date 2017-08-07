package br.com.cbf.webservice;

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
        resources.add(br.com.cbf.webservice.endpoint.ProductEndpoint.class);
        resources.add(br.com.cbf.webservice.endpoint.AjudanteEndpoint.class);
        resources.add(br.com.cbf.webservice.endpoint.MasterEndpoint.class);
        resources.add(br.com.cbf.webservice.endpoint.VendedorEndpoint.class);
        resources.add(br.com.cbf.webservice.endpoint.ConsultadorEndpoint.class);
    
    }
}
