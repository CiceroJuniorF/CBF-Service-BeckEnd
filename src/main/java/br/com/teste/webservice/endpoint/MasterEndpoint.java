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
import br.com.teste.dto.MasterDTO;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.entites.Master;
import br.com.teste.entites.Vendedor;
import br.com.teste.service.AjudanteService;
import br.com.teste.service.MasterService;
import br.com.teste.service.VendedorService;
import br.com.teste.service.impl.AjudanteServiceImpl;
import br.com.teste.service.impl.MasterServiceImpl;
import br.com.teste.service.impl.VendedorServiceImpl;
import br.com.teste.webservice.MasterWebService;

@Path("/oMaster")
public class MasterEndpoint implements MasterWebService {

	private MasterService serviceMaster = new MasterServiceImpl();
	private AjudanteService serviceAjudante = new AjudanteServiceImpl();
	private VendedorService serviceVendedor = new VendedorServiceImpl();
	
	// --------------------------------------------MASTER---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	@POST
	@Path("master/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarMaster(Master master) {
		return this.serviceMaster.cadastrarOuAtualizarMaster(master);

	}
	
	@GET
	@Path("master/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Master> listarTodosMasterDetalhado() {
		return this.serviceMaster.listarTodosMasterDetalhado();
	}
	
	@GET
	@Path("master/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<MasterDTO> listarTodosMasterSimples() {
		return this.serviceMaster.listarTodosMasterSimples();
	}
	
	@GET
	@Path("master/listarSimpes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaMasterPorIdSimples(@PathParam("id")Integer id) {
		return this.serviceMaster.buscaMasterPorIdSimples(id);
	}
	@GET
	@Path("master/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaMasterPorIdDetalhado(@PathParam("id")Integer id) {
		return this.serviceMaster.buscaMasterPorIdDetalhado(id);
	}

	@DELETE
	@Path("master/deletar/{id}")
	@Override
	public Response deletarMaster(Integer id) {
		return this.serviceMaster.deletarMaster(id);

	}
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------VENDEDOR---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@POST
	@Path("vendedor/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarVendedor(Vendedor Vendedor) {
		return this.serviceVendedor.cadastrarOuAtualizarFuncionario(Vendedor);
	}

	@GET
	@Path("vendedor/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Vendedor> listarTodosVendedoresDetalhado() {

		return this.serviceVendedor.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("vendedor/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<VendedorDTO> listarTodosVendedoresSimples() {

		return this.serviceVendedor.listarTodosFuncionariosSimples();
	}

	@GET
	@Path("vendedor/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaVendedorPorIdDetalhado(@PathParam("id") Integer id) {

		return serviceVendedor.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("vendedor/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaVendedorPorIdSimples(@PathParam("id") Integer id) {

		return this.serviceVendedor.buscaPorIdSimples(id);

	}

	@DELETE
	@Path("vendedor/deletar/{id}")
	@Override
	public Response deletarVendedor(@PathParam("id") Integer id) {

		return this.serviceVendedor.deletar(id);

	}

	@PUT
	@Path("vendedor/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Vendedor Vendedor) {

		return this.cadastrarOuAtualizarVendedor(Vendedor);

	}
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------AJUDANTE---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	@POST
	@Path("ajudante/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarAjudante(Ajudante Ajudante) {
		
		return this.serviceAjudante.cadastrarOuAtualizarFuncionario(Ajudante);
	}

	@GET
	@Path("ajudante/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Ajudante> listarTodosAjudantesDetalhado() {

		return this.serviceAjudante.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("ajudante/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<AjudanteDTO> listarTodosAjudantesSimples() {

		return this.serviceAjudante.listarTodosFuncionariosSimples();
	}

	@GET
	@Path("ajudante/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaAjudantePorIdDetalhado(@PathParam("id") Integer id) {

		return serviceAjudante.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("ajudante/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaAjudantePorIdSimples(@PathParam("id") Integer id) {

		return this.serviceAjudante.buscaPorIdSimples(id);

	}

	@DELETE
	@Path("ajudante/deletar/{id}")
	@Override
	public Response deletarAjudante(@PathParam("id") Integer id) {

		return this.serviceAjudante.deletar(id);

	}

	@PUT
	@Path("ajudante/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Ajudante ajudante) {
	
		return this.cadastrarOuAtualizarAjudante(ajudante);

	}



	// -----------------------------------------------------------------------------------------------------------------//

}
