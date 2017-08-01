package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.MasterDTO;
import br.com.cbf.entites.Master;


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
