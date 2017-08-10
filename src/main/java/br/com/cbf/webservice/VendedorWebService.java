package br.com.cbf.webservice;

import javax.ws.rs.core.Response;

import br.com.cbf.entites.Cliente;

public interface VendedorWebService {

	Response cadastrarClientwe(Cliente cliente);

}
