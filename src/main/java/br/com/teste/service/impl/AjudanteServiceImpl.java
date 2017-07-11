package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import br.com.teste.dao.AjudanteDAO;
import br.com.teste.dao.impl.AjudanteDAOImpl;
import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {
	private AjudanteDAO dao = new AjudanteDAOImpl();
	@Override
	public Response cadastrarFuncionario(Ajudante funcionario) {
		try {
			dao.cadastrarFuncionario(funcionario);
			URI uri = URI.create("/ajudante/json/"+funcionario.getIdUsuario());
			System.out.println(uri);
			return Response.created(uri).build();
			
		} catch (SQLException e) {
			
			return null;
		}
	}

}
