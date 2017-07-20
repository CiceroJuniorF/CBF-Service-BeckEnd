package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.ConversorDTO;
import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dao.AjudanteDAO;
import br.com.teste.dao.impl.AjudanteDAOImpl;
import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {
	private AjudanteDAO dao = new AjudanteDAOImpl();

	@Override
	public Response cadastrarOuAtualizarFuncionario(Ajudante funcionario) {
		if(funcionario.getIdUsuario() == null) {
		try {
			funcionario.setDataCadastro(DataAuxiliar.dataAtual());
			dao.adiciona(funcionario);
			URI uri = URI.create("/ajudante/listar/" + funcionario.getIdUsuario());
			return Response.created(uri).build();

		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		}else {
			try {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				dao.atualiza(funcionario);				
				return Response.status(200).build();
			} catch (SQLException e) {
				e.printStackTrace();
				return Response.status(500).build();
			}
		}
	}

	@Override
	public List<Ajudante> listarTodosFuncionariosDetalhado() {
		try {
			return dao.listaTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<AjudanteDTO> listarTodosFuncionariosSimples() {
		try {
			return new ConversorDTO().coverteListaAjudante(dao.listaTodos());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ajudante buscaPorIdDetalhado(Integer id) {
		try {
			return dao.buscaPorId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AjudanteDTO buscaPorIdSimples(Integer id) {
		try {

			return new ConversorDTO().converteAjudante(dao.buscaPorId(id));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Response deletar(Integer id) {
		try {
			dao.remove(id);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();

		}

	}


}
