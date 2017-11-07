package br.com.cbf.webservice;

import javax.ws.rs.core.Response;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;

public interface VendedorWebService {

	public Response cadastrarCliente(Cliente cliente);

	public Response consultaCliente(String cpf, String dataNascimento, Funcionario vendedor);

	Response atualizarCliente(RegistroAlteracoesCliente alteracao);

}
