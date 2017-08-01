package br.com.cbf.webservice.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cbf.entites.Produto;
import br.com.cbf.service.ProductService;
import br.com.cbf.service.impl.ProductServiceImpl;
import br.com.cbf.webservice.ProductWebservice;

@Path("/product")
public class ProductEndpoint implements ProductWebservice {
	ProductService service = new ProductServiceImpl();
	
	@Path("hello")
	@GET
	@Override
	public String hello() {
		return "Hello";
	}
	
	@Path("persistir")
	@GET
	@Override
	public String persistir() {
		return service.persistir();
	}
	
	@Path("cadastrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)	
	@Override
	public String cadastrar(Produto string) {
		return service.cadastrar(string);
	}
	
	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Produto> listar() {
		return service.listar();			
	}
	
	@Path("pesquisa/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Produto pesquisarId(@PathParam("id")Integer id) {
		return service.pesquisarId(id);			
	}
	
	
	@Path("deletar/{id}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String deletar(@PathParam("id")Integer id) {
		
		return service.deletar(id);
	}
	
	
	

}
