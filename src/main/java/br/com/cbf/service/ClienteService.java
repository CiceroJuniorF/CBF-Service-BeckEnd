package br.com.cbf.service;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.exception.ClienteException;

public interface ClienteService {
	
	public List<Cliente> listarTodosClientesDetalhado();

	public List<ClienteDTO> listarTodosClienteesSimples();

	public Cliente buscaPorIdSimples(Integer id);

	public Cliente buscaPorIdDetalhado(Integer id);
	
	public Cliente realizarConsultaDeCPF(String CPF, String dataNascimento) throws ClienteException;
	
	public boolean verificaCPFExistente(String CPF) throws ClienteException;

	Cliente cadastrar(Cliente cliente) throws SQLException;

	Cliente atualizar(Cliente cliente) throws SQLException;
}
