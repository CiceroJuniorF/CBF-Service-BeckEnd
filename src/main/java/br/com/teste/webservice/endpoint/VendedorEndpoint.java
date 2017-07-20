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

import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Vendedor;
import br.com.teste.service.VendedorService;
import br.com.teste.service.impl.VendedorServiceImpl;

@Path("/vendedor")
public class VendedorEndpoint implements VendedorService {

	private VendedorService service = new VendedorServiceImpl();

	
	@POST
	@Path("/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarFuncionario(Vendedor funcionario) {
		return this.service.cadastrarOuAtualizarFuncionario(funcionario);
	}

	
	@GET
	@Path("/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Vendedor> listarTodosFuncionariosDetalhado() {
		
		return this.service.listarTodosFuncionariosDetalhado();
	}

	
	@GET
	@Path("/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<VendedorDTO> listarTodosFuncionariosSimples() {

		return this.service.listarTodosFuncionariosSimples();
	}

	@GET
	@Path("/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Vendedor buscaPorIdDetalhado(@PathParam("id") Integer id) {
		
		return service.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public VendedorDTO buscaPorIdSimples(@PathParam("id") Integer id) {

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
	public Response atualizar(Vendedor Vendedor) {

		return this.cadastrarOuAtualizarFuncionario(Vendedor);

	}

}
