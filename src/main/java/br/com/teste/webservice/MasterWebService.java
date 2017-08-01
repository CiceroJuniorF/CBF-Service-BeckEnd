package br.com.teste.webservice;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.dto.AjudanteDTO;
import br.com.teste.dto.ConsultadorDTO;
import br.com.teste.dto.MasterDTO;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.entites.Consultador;
import br.com.teste.entites.Master;
import br.com.teste.entites.Vendedor;

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

	List<Vendedor> listarTodosVendedoresDetalhado();

	List<VendedorDTO> listarTodosVendedoresSimples();

	Response buscaVendedorPorIdDetalhado(Integer id);

	Response buscaVendedorPorIdSimples(Integer id);

	Response deletarVendedor(Integer id);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------AJUDANTE---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	Response cadastrarOuAtualizarAjudante(Ajudante funcionario);

	List<Ajudante> listarTodosAjudantesDetalhado();

	List<AjudanteDTO> listarTodosAjudantesSimples();

	Response buscaAjudantePorIdDetalhado(Integer id);

	Response buscaAjudantePorIdSimples(Integer id);

	Response deletarAjudante(Integer id);
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
}
