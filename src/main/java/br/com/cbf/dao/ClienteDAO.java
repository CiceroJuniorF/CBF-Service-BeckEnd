package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.exception.ClienteException;

public interface ClienteDAO {
	
	void salvar(Cliente cliente) throws SQLException;

	List<ClienteDTO> listarSimples() throws SQLException;

	ClienteDTO buscaSimples(Integer id) throws SQLException;
	
	Cliente buscaPorId(Integer id) throws SQLException;
	
	List<Cliente> listaTodosDetalhado() throws SQLException;

	void atualiza(Cliente cliente) throws SQLException;
	
	boolean verificaExisteCPF(String CPF) throws ClienteException;

	

}
