package br.com.teste.service;

import java.util.List;

import javax.ws.rs.core.Response;

public interface FuncionarioService<T,A> {
	//T =  Entity A = DTO
	
	public Response cadastrarOuAtualizarFuncionario(T funcionario);

	public List<T> listarTodosFuncionariosDetalhado();

	public List<A> listarTodosFuncionariosSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);

	public Response deletar(Integer id);

}