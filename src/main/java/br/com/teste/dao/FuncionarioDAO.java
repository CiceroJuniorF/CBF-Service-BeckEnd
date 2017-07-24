package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

public interface FuncionarioDAO<Entity,DTO> {
	
	void salvar(Entity entity)throws SQLException;
	
	List<DTO> listarSimples()throws SQLException;

	DTO buscaSimples(Integer id)throws SQLException;
}
