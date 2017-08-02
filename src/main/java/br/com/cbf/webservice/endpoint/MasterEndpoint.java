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
import javax.ws.rs.core.Response;

import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.dto.MasterDTO;
import br.com.cbf.entites.Ajudante;
import br.com.cbf.entites.Consultador;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.Master;
import br.com.cbf.entites.Vendedor;
import br.com.cbf.service.AjudanteService;
import br.com.cbf.service.ConsultadorService;
import br.com.cbf.service.MasterService;
import br.com.cbf.service.VendedorService;
import br.com.cbf.service.impl.AjudanteServiceImpl;
import br.com.cbf.service.impl.ConsultadorServiceImpl;
import br.com.cbf.service.impl.MasterServiceImpl;
import br.com.cbf.service.impl.VendedorServiceImpl;
import br.com.cbf.webservice.MasterWebService;

@Path("/oMaster")
public class MasterEndpoint implements MasterWebService {

	private MasterService serviceMaster = new MasterServiceImpl();
	private AjudanteService serviceAjudante = new AjudanteServiceImpl();
	private VendedorService serviceVendedor = new VendedorServiceImpl();
	private ConsultadorService serviceConsultador = new ConsultadorServiceImpl();

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
	public Response buscaMasterPorIdSimples(@PathParam("id") Integer id) {
		return this.serviceMaster.buscaMasterPorIdSimples(id);
	}

	@GET
	@Path("master/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaMasterPorIdDetalhado(@PathParam("id") Integer id) {
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
	public Response cadastrarOuAtualizarVendedor(Vendedor vendedor) {
		Funcionario func = (Funcionario) vendedor;
		return this.serviceVendedor.cadastrarOuAtualizarFuncionario(func);
	}

	@GET
	@Path("vendedor/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Funcionario> listarTodosVendedoresDetalhado() {

		return this.serviceVendedor.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("vendedor/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosVendedoresSimples() {

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
	public Response cadastrarOuAtualizarAjudante(Ajudante ajudante) {
		Funcionario func = (Funcionario) ajudante;
		return this.serviceAjudante.cadastrarOuAtualizarFuncionario(func);
	}

	@GET
	@Path("ajudante/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Funcionario> listarTodosAjudantesDetalhado() {

		return this.serviceAjudante.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("ajudante/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosAjudantesSimples() {

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

	// ------------------------------------------Consultador------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	@POST
	@Path("consultador/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarConsultador(Consultador consultador) {

		return this.serviceConsultador.cadastrarOuAtualizarConsultador(consultador);
	}

	@GET
	@Path("consultador/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Consultador> listarTodosConsultadorsDetalhado() {

		return this.serviceConsultador.listarTodosConsultadorsDetalhado();
	}

	@GET
	@Path("consultador/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<ConsultadorDTO> listarTodosConsultadorsSimples() {

		return this.serviceConsultador.listarTodosConsultadoresSimples();
	}

	@GET
	@Path("consultador/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaConsultadorPorIdDetalhado(@PathParam("id") Integer id) {

		return serviceConsultador.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("consultador/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaConsultadorPorIdSimples(@PathParam("id") Integer id) {

		return this.serviceConsultador.buscaPorIdSimples(id);

	}

	@DELETE
	@Path("consultador/deletar/{id}")
	@Override
	public Response deletarConsultador(@PathParam("id") Integer id) {

		return this.serviceConsultador.deletar(id);

	}

	@PUT
	@Path("consultador/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Consultador Consultador) {

		return this.cadastrarOuAtualizarConsultador(Consultador);

	}
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Funcionario------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public List<Funcionario> listarTodosFuncionariosDetalhado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosSimples() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaFuncionarioPorIdDetalhado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaFuncionarioPorIdSimples(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// -----------------------------------------------------------------------------------------------------------------//
}
