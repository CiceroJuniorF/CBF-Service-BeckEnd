package br.com.cbf.webservice;

import javax.ws.rs.core.Response;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;

public interface VendedorWebService {

	Response cadastrarCliente(Cliente cliente);

	Response consultaCliente(String cpf, String dataNascimento, Funcionario vendedor);

}
