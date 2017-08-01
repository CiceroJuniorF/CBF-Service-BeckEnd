package br.com.cbf.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.entites.Venda;
import br.com.cbf.service.FuncionarioService;

public class FuncionarioServiceImpl<Entity, DTO, DAO> implements FuncionarioService<Entity,DTO>{

	@Override
	public Response cadastrarOuAtualizarFuncionario(Entity funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> listarTodosFuncionariosDetalhado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> listarTodosFuncionariosSimples() {
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
	public Response deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response realizarVenda(Venda venda) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
