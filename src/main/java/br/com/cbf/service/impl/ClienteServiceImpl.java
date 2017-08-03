package br.com.cbf.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	@Override
	public Response cadastrarOuAtualizarCliente(Cliente Cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listarTodosClientesDetalhado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> listarTodosClienteesSimples() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaPorIdDetalhado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response realizarConsultaDeCPFdeCliente(String CPF) {
		// TODO Auto-generated method stub
		return null;
	}

}
