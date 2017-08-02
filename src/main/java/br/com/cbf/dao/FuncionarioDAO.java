package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;

public interface FuncionarioDAO {
	void salvar(Funcionario ajudante) throws SQLException;

	List<FuncionarioDTO> listarSimples() throws SQLException;

	FuncionarioDTO buscaSimples(Integer id) throws SQLException;
	
	Funcionario buscaPorId(Integer id) throws SQLException;
	
	List<Funcionario> listaTodosDetalhado() throws SQLException;

	void atualiza(Funcionario ajudante) throws SQLException;

	void remove(Integer id) throws SQLException;

	

}
