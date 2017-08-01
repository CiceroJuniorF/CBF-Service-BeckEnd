package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.entites.Consultador;

public interface ConsultadorDAO {

	void salvar(Consultador Consultador) throws SQLException;

	List<ConsultadorDTO> listarSimples() throws SQLException;

	ConsultadorDTO buscaSimples(Integer id) throws SQLException;

	void atualiza(Consultador Consultador) throws SQLException;

}
