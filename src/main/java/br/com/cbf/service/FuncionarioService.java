package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.Venda;

public interface FuncionarioService{
	//T =  Entity A = DTO
	
	public Response cadastrarOuAtualizarFuncionario(Funcionario funcionario);

	public List<Funcionario> listarTodosFuncionariosDetalhado();

	public List<FuncionarioDTO> listarTodosFuncionariosSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);

	public Response deletar(Integer id);
	
	Response realizarVenda(Venda venda);
	
	Response cadastrarCliente(Cliente cliente);

}