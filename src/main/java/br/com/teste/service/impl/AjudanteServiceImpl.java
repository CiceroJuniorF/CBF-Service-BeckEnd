package br.com.teste.service.impl;

import java.net.URI;
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

	private GenericServiceImpl<Ajudante> genericservice = new GenericServiceImpl<Ajudante>(Ajudante.class);
	private AjudanteDAO dao = new AjudanteDAOImpl();

	@Override
	public Response cadastrarOuAtualizarFuncionario(Ajudante funcionario) {
		try {
			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.adiciona(funcionario);
				URI uri = URI.create("/ajudante/listarDetalhado/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.atualiza(funcionario);
				return Response.status(201).build();
			}
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@Override
	public List<Ajudante> listarTodosFuncionariosDetalhado() {

		return genericservice.listaTodosDetalhado();

	}

	@Override
	public List<AjudanteDTO> listarTodosFuncionariosSimples() {

		return new ConversorDTO().coverteListaAjudante(dao.buscaSimples());

	}

	@Override
	public Response buscaPorIdDetalhado(Integer id) {
		try {
			return Response.status(200).entity(genericservice.buscaPorId(id)).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		try {
			return Response.status(200).entity(new ConversorDTO().converteAjudante(genericservice.buscaPorId(id)))
					.build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericservice.remove(id);
			return Response.status(202).build();
		} catch (Exception e) {
			return Response.status(304).build();
		}

	}

}
