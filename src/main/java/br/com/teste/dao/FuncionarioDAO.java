package br.com.teste.dao;



import java.sql.SQLException;

import br.com.teste.entites.Ajudante;

public interface FuncionarioDAO {
	
	public void cadastrarFuncionario(Ajudante funcionario) throws SQLException; 
}
