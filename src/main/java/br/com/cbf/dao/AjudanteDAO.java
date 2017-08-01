package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.AjudanteDTO;
import br.com.cbf.entites.Ajudante;

public interface AjudanteDAO{
	
	void salvar(Ajudante ajudante)throws SQLException;
	
	List<AjudanteDTO> listarSimples()throws SQLException;

	AjudanteDTO buscaSimples(Integer id)throws SQLException;
	
	void atualiza (Ajudante ajudante) throws SQLException;

}
