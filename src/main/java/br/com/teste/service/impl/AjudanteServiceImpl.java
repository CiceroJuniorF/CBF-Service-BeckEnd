package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.ConversorDTO;
import br.com.teste.dao.AjudanteDAO;
import br.com.teste.dao.impl.AjudanteDAOImpl;
import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {
	private AjudanteDAO dao = new AjudanteDAOImpl();
	@Override
	public Response cadastrarFuncionario(Ajudante funcionario) {
		try {
			dao.cadastrarFuncionario(funcionario);
			URI uri = URI.create("/ajudante/listar/"+funcionario.getIdUsuario());
			System.out.println(uri);
			return Response.created(uri).build();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	@Override
	public List<AjudanteDTO> listarTodosAjudantes() {
		try {
		return new ConversorDTO().coverteListaAjudante(dao.listarTodosAjudantes());
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AjudanteDTO buscaPorId(Integer id) {
		try {
			
			return new ConversorDTO().coverteAjudante(dao.buscaPorId(id));
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;			
		}
		
	}

	@Override
	public Response deletar(Integer id) {
		
		try {
			dao.deletar(id);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
			
		}
		
	}

	@Override
	public Response atualizar(Ajudante ajudante) {
		try {			
			dao.atualizar(ajudante);
			return Response.status(200).build();
		}catch(SQLException e) {			
			e.printStackTrace();
			return Response.status(500).build();
		}
		
	}

}
