package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;

public interface ClienteService {
	
	public Response cadastrarOuAtualizarCliente(Cliente Cliente);

	public List<Cliente> listarTodosClientesDetalhado();

	public List<ClienteDTO> listarTodosClienteesSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);
	
	public Response realizarConsultaDeCPFdeCliente(String CPF);
}
