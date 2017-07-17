package br.com.teste.webservice.endpoint;

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
import javax.ws.rs.core.Response;

import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;
import br.com.teste.service.impl.AjudanteServiceImpl;

@Path("/ajudante")
public class AjudanteEndpoint implements AjudanteService {

	private AjudanteService service = new AjudanteServiceImpl();

	
	@POST
	@Path("/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarFuncionario(Ajudante funcionario) {
		return this.service.cadastrarFuncionario(funcionario);
	}

	
	@GET
	@Path("/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Ajudante> listarTodosAjudantesDetalhado() {
		
		return this.service.listarTodosAjudantesDetalhado();
	}

	
	@GET
	@Path("/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<AjudanteDTO> listarTodosAjudantesSimples() {

		return this.service.listarTodosAjudantesSimples();
	}

	@GET
	@Path("/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Ajudante buscaPorIdDetalhado(@PathParam("id") Integer id) {
		
		return service.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public AjudanteDTO buscaPorIdSimples(@PathParam("id") Integer id) {

		return this.service.buscaPorIdSimples(id);

	}
	@DELETE
	@Path("/deletar/{id}")	
	@Override
	public Response deletar(@PathParam("id") Integer id) {

		return this.service.deletar(id);

	}

	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response atualizar(Ajudante ajudante) {

		return service.atualizar(ajudante);

	}

}
