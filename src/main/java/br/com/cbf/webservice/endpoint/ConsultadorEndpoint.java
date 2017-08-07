package br.com.cbf.webservice.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cbf.service.impl.ClienteServiceImpl;
import br.com.cbf.webservice.ConsultadorWebService;

@Path("/consultador")
public class ConsultadorEndpoint implements ConsultadorWebService  {
	
	@GET
	@Path("buscarCPF/{cpf}/{dataNascimento}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response buscarClienteCPF(@PathParam("cpf") String CPF, @PathParam("dataNascimento") String dataNascimento) {
		
	
			return new ClienteServiceImpl().realizarConsultaDeCPFdeCliente(CPF, dataNascimento);
	
	}
}
