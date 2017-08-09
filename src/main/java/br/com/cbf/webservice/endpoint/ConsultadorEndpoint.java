package br.com.cbf.webservice.endpoint;

import javax.ws.rs.Path;

import br.com.cbf.webservice.ConsultadorWebService;

@Path("/consultador")
public class ConsultadorEndpoint implements ConsultadorWebService  {
	
//	@GET
//	@Path("buscarCPF/{cpf}/{dataNascimento}")
//	@Produces(MediaType.APPLICATION_JSON)	
//	public Response buscarClienteCPF(@PathParam("cpf") String CPF, @PathParam("dataNascimento") String dataNascimento) {
//		
//	
//			return new ClienteServiceImpl().realizarConsultaDeCPF(CPF, dataNascimento);
//	
//	}
}
