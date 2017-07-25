package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.dto.MasterDTO;
import br.com.teste.entites.Master;

public interface MasterDAO {
	void salvar(Master entity) throws SQLException;

	List<MasterDTO> listarSimples() throws SQLException;

	MasterDTO buscaSimples(Integer id) throws SQLException;

	void atualiza(Master entity) throws SQLException;
}
