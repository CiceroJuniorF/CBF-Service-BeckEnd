package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;
import br.com.cbf.entites.Venda;

public interface FuncionarioService{
	//T =  Entity A = DTO
	
	public Response cadastrarOuAtualizarFuncionario(Funcionario funcionario);

	public List<FuncionarioDTO> listarTodosFuncionariosDetalhado();

	public List<FuncionarioDTO> listarTodosFuncionariosSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);

	public Response deletar(Integer id);
	
	public Response realizarVenda(Venda venda);
	
	public Response cadastrarCliente(Cliente cliente);
	
	public Response realizarConsultaDeCPFDeCliente(String cpfCliente, String dataNascimentoCliente, Funcionario funcionario);
	
	public Response atualizarCliente(RegistroAlteracoesCliente alteracao);
}