package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.entites.Ajudante;

public interface AjudanteDAO extends FuncionarioDAO {
	
	public void cadastrarFuncionario(Ajudante funcionario) throws SQLException;
	
	public List<Ajudante> listarTodosAjudantes() throws SQLException;
	
	public Ajudante buscaPorId(Integer id) throws SQLException;
	
	public void deletar(Integer id) throws SQLException;
	
	public void atualizar(Ajudante ajudante) throws SQLException;
}
