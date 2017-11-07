package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.RegistroAlteracoesCliente;
import br.com.cbf.entites.RegistroDeConsulta;
import br.com.cbf.exception.ClienteException;

public interface ClienteDAO {
	
	Cliente salvar(Cliente cliente) throws SQLException;

	List<ClienteDTO> listarSimples() throws SQLException;

	ClienteDTO buscaSimples(Integer id) throws SQLException;
	
	Cliente buscaPorId(Integer id) throws SQLException;
	
	List<Cliente> listaTodosDetalhado() throws SQLException;

	RegistroAlteracoesCliente atualiza(RegistroAlteracoesCliente alteracoa) throws SQLException;
	
	boolean verificaExisteCPF(String CPF) throws ClienteException;

	void registraConsultaCliente(RegistroDeConsulta registro) throws SQLException;

	

}
