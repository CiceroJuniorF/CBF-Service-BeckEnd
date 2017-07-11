package br.com.teste.webservice.endpoint;

import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.teste.entites.Vendedor;
import br.com.teste.service.VendedorService;

public class VendedorEndpoint implements VendedorService{

	@Override
	public ResponseBuilder cadastrarFuncionario(Vendedor funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

}
