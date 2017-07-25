package br.com.teste.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.dto.MasterDTO;
import br.com.teste.entites.Master;


public interface MasterService {

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
	
	

	
	

	

	
}
