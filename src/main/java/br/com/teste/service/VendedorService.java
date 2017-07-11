package br.com.teste.service;

import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.teste.entites.Vendedor;

public interface VendedorService{
	public ResponseBuilder cadastrarFuncionario(Vendedor funcionario);

}
