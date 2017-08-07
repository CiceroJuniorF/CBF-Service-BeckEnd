package br.com.cbf.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.service.ClienteService;
import br.com.iwebservice.buscaCpf.BuscaCPF;

public class ClienteServiceImpl implements ClienteService {

	@Override
	public Response cadastrarOuAtualizarCliente(Cliente Cliente) {
		
		
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
	public Response realizarConsultaDeCPFdeCliente(String CPF, String dataNascimento) {
		ClienteDTO dto;

		try {
			dto = new BuscaCPF().buscaPorCPF(CPF, dataNascimento);
			 return Response.status(200).entity(dto).build();
		} catch (Exception e) {
		
			System.out.println("--------------------------------"+e.getMessage());
			return Response.status(500).header("Error", Exception.class).build();
		}
	}

}
