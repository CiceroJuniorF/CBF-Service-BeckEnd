package br.com.teste.webservice;

import javax.ws.rs.core.Response;

import br.com.teste.entites.Ajudante;

public interface AjudanteWebservice extends FuncionarioWebservice {
	
	public Response cadastrarFuncionario(Ajudante funcionario);
	
}
