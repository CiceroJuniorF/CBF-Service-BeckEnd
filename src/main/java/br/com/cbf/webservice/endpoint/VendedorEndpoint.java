package br.com.cbf.webservice.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.service.VendedorService;
import br.com.cbf.service.impl.VendedorServiceImpl;
import br.com.cbf.webservice.VendedorWebService;

@Path("/vendedor")
public class VendedorEndpoint implements VendedorWebService {

	private VendedorService service = new VendedorServiceImpl();

	
	@POST
	@Path("novoCliente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarCliente(Cliente cliente) {
		return this.service.cadastrarCliente(cliente);
	}
	
	@POST
	@Path("consultaCliente/{cpf}/{dataNascimento}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response consultaCliente(@PathParam("cpf") String cpfCliente, @PathParam("dataNascimento") String dataNascimentoCliente, Funcionario vendedor) {
		return this.service.realizarConsultaDeCPFDeCliente(cpfCliente, dataNascimentoCliente, vendedor);
	}

}
