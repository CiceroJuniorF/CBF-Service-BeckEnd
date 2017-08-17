package br.com.cbf.webservice;

import java.util.List;

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

public interface MasterWebService {
	// --------------------------------------------MASTER---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	Response cadastrarOuAtualizarMaster(Master master);

	Response deletarMaster(Integer id);

	List<Master> listarTodosMasterDetalhado();

	List<MasterDTO> listarTodosMasterSimples();

	Response buscaMasterPorIdSimples(Integer id);

	Response buscaMasterPorIdDetalhado(Integer id);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------VENDEDOR---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	Response cadastrarOuAtualizarVendedor(Vendedor funcionario);

	List<FuncionarioDTO> listarTodosVendedoresDetalhado();

	List<FuncionarioDTO> listarTodosVendedoresSimples();

	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------AJUDANTE---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	Response cadastrarOuAtualizarAjudante(Ajudante funcionario);

	List<FuncionarioDTO> listarTodosAjudantesDetalhado();

	List<FuncionarioDTO> listarTodosAjudantesSimples();

	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Consultador------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	Response cadastrarOuAtualizarConsultador(Consultador funcionario);

	List<Consultador> listarTodosConsultadorsDetalhado();

	List<ConsultadorDTO> listarTodosConsultadorsSimples();

	Response buscaConsultadorPorIdDetalhado(Integer id);

	Response buscaConsultadorPorIdSimples(Integer id);

	Response deletarConsultador(Integer id);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Funcionario------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	List<FuncionarioDTO> listarTodosFuncionariosDetalhado();

	List<FuncionarioDTO> listarTodosFuncionariosSimples();

	Response buscaFuncionarioPorIdDetalhado(Integer id);

	Response buscaFuncionarioPorIdSimples(Integer id);

	Response deletarFuncionario(Integer id);

	// ------------------------------------------Cliente------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	List<Cliente> listarTodosClientesDetalhado();

	List<ClienteDTO> listarTodosClienteSimples();

	Response buscaClientePorIdDetalhado(Integer id);

	Response buscaClientePorIdSimples(Integer id);
	
	Response cadastrarCliente(Cliente cliente);

	Response consultaCliente(String cpf, String dataNascimento, Funcionario vendedor);
	
	Response buscarClientePorFreguesia(Freguesia freguesia);
}
