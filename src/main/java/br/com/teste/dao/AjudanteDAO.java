package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.entites.Ajudante;

public interface AjudanteDAO extends FuncionarioDAO {
	
	public void cadastrarFuncionario(Ajudante funcionario) throws SQLException;
	
	public List<Ajudante> listarTodosAjudantes() throws SQLException;
	
}
