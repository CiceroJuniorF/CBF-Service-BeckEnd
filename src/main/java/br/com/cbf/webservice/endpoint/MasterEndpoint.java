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

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.dto.MasterDTO;
import br.com.cbf.entites.Ajudante;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Consultador;
import br.com.cbf.entites.Freguesia;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.Master;
import br.com.cbf.entites.Vendedor;
import br.com.cbf.service.AjudanteService;
import br.com.cbf.service.ClienteService;
import br.com.cbf.service.ConsultadorService;
import br.com.cbf.service.FuncionarioService;
import br.com.cbf.service.MasterService;
import br.com.cbf.service.VendedorService;
import br.com.cbf.service.impl.AjudanteServiceImpl;
import br.com.cbf.service.impl.ClienteServiceImpl;
import br.com.cbf.service.impl.ConsultadorServiceImpl;
import br.com.cbf.service.impl.FuncionarioServiceImpl;
import br.com.cbf.service.impl.MasterServiceImpl;
import br.com.cbf.service.impl.VendedorServiceImpl;
import br.com.cbf.webservice.MasterWebService;

@Path("/oMaster")
public class MasterEndpoint implements MasterWebService {

	private MasterService serviceMaster = new MasterServiceImpl();
	private AjudanteService serviceAjudante = new AjudanteServiceImpl();
	private VendedorService serviceVendedor = new VendedorServiceImpl();
	private FuncionarioService serviceFuncionario = new FuncionarioServiceImpl();
	private ConsultadorService serviceConsultador = new ConsultadorServiceImpl();
	private ClienteService serviceCliente = new ClienteServiceImpl();

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
	@Path("funcionario/vendedor/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarVendedor(Vendedor vendedor) {
		Funcionario func = vendedor;
		return this.serviceVendedor.cadastrarOuAtualizarFuncionario(func);
	}

	@GET
	@Path("funcionario/vendedor/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosVendedoresDetalhado() {
		return this.serviceVendedor.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("funcionario/vendedor/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosVendedoresSimples() {

		return this.serviceVendedor.listarTodosFuncionariosSimples();
	}


	@PUT
	@Path("funcionario/vendedor/atualizar")
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
	@Path("funcionario/ajudante/novo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarOuAtualizarAjudante(Ajudante ajudante) {
		Funcionario func = ajudante;
		return this.serviceAjudante.cadastrarOuAtualizarFuncionario(func);
	}

	@GET
	@Path("funcionario/ajudante/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosAjudantesDetalhado() {

		return this.serviceAjudante.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("funcionario/ajudante/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosAjudantesSimples() {

		return this.serviceAjudante.listarTodosFuncionariosSimples();
	}

	@PUT
	@Path("funcionario/ajudante/atualizar")
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

	@GET
	@Path("funcionario/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosDetalhado() {

		return this.serviceFuncionario.listarTodosFuncionariosDetalhado();
	}

	@GET
	@Path("funcionario/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosSimples() {

		return this.serviceFuncionario.listarTodosFuncionariosSimples();
	}

	@GET
	@Path("funcionario/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaFuncionarioPorIdDetalhado(@PathParam("id") Integer id) {

		return serviceFuncionario.buscaPorIdDetalhado(id);
	}

	@GET
	@Path("funcionario/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaFuncionarioPorIdSimples(@PathParam("id") Integer id) {

		return this.serviceFuncionario.buscaPorIdSimples(id);

	}

	@DELETE
	@Path("funcionario/deletar/{id}")
	@Override
	public Response deletarFuncionario(@PathParam("id") Integer id) {

		return this.serviceFuncionario.deletar(id);

	}
	
	// ------------------------------------------Cliente------------------------------------------------------------//
		// -----------------------------------------------------------------------------------------------------------------//
		// -----------------------------------------------------------------------------------------------------------------//
		// -----------------------------------------------------------------------------------------------------------------//

	@GET
	@Path("cliente/listarTodosDetalhado")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Cliente> listarTodosClientesDetalhado() {
		// TODO Auto-generated method stub
		return serviceCliente.listarTodosClientesDetalhado();
	}

	@GET
	@Path("cliente/listarTodosSimples")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<ClienteDTO> listarTodosClienteSimples() {
		
		return serviceCliente.listarTodosClienteesSimples();
	}

	@GET
	@Path("cliente/listarDetalhado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaClientePorIdDetalhado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("cliente/listarSimples/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response buscaClientePorIdSimples(Integer id) {
		
		return null;
	}
	@POST
	@Path("cliente/novoCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarCliente(Cliente cliente) {
		
		return serviceFuncionario.cadastrarCliente(cliente);
	}

	@POST
	@Path("cliente/consultaCliente/{cpf}/{dataNascimento}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultaCliente(String cpf, String dataNascimento, Funcionario funcionario) {
		
		return serviceFuncionario.realizarConsultaDeCPFDeCliente(cpf, dataNascimento, funcionario);
	}

	@Override
	public Response buscarClientePorFreguesia(Freguesia freguesia) {
		
		return null;
	}
	
	// -----------------------------------------------------------------------------------------------------------------//
}
