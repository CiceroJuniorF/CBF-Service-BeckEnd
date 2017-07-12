package br.com.teste.webservice.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;
import br.com.teste.service.impl.AjudanteServiceImpl;
@Path("/ajudante")
public class AjudanteEndpoint implements AjudanteService {
	
	private AjudanteService service = new AjudanteServiceImpl();
	
	
	@Path("/novo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarFuncionario(Ajudante funcionario) {		
		return this.service.cadastrarFuncionario(funcionario);
	}
	
	@Path("/listarTodos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Override
	public List<Ajudante> listarTodosAjudantes() {
		
		return this.service.listarTodosAjudantes();
	}
	
	
	@GET
	@Path("/listar/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	@Override
	public Ajudante buscaPorId(@PathParam("id") Integer id) {
		
		return this.service.buscaPorId(id);
		
	}	
	
	@Path("/deletar/{id}")
	@DELETE
	@Override
	public Response deletar(@PathParam("id") Integer id) {
		
		return this.service.deletar(id);
		
	}
	
	
	


}
