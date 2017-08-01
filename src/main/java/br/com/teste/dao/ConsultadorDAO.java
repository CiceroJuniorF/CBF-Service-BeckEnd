package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.dto.ConsultadorDTO;
import br.com.teste.entites.Consultador;

public interface ConsultadorDAO {

	void salvar(Consultador Consultador) throws SQLException;

	List<ConsultadorDTO> listarSimples() throws SQLException;

	ConsultadorDTO buscaSimples(Integer id) throws SQLException;

	void atualiza(Consultador Consultador) throws SQLException;

}
