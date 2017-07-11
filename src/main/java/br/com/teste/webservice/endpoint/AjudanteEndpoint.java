package br.com.teste.webservice.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;
import br.com.teste.service.impl.AjudanteServiceImpl;
import br.com.teste.webservice.AjudanteWebservice;
@Path("/ajudante")
public class AjudanteEndpoint implements AjudanteWebservice {
	
	private AjudanteService service = new AjudanteServiceImpl();
	@Path("/novo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public Response cadastrarFuncionario(Ajudante funcionario) {		
		return this.service.cadastrarFuncionario(funcionario);
	}


}
