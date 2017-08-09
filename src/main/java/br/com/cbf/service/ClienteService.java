package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.exception.ClienteException;

public interface ClienteService {
	
	public Response cadastrarOuAtualizarCliente(Cliente cliente);

	public List<Cliente> listarTodosClientesDetalhado();

	public List<ClienteDTO> listarTodosClienteesSimples();

	public Cliente buscaPorIdSimples(Integer id);

	public Cliente buscaPorIdDetalhado(Integer id);
	
	public Cliente realizarConsultaDeCPF(String CPF, String dataNascimento) throws ClienteException;
	
	public boolean verificaCPFExistente(String CPF) throws ClienteException;
}
