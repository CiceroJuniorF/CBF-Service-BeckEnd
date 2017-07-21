package br.com.teste.service.impl;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.ConversorDTO;
import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {

	private GenericServiceImpl<Ajudante> genericservice = new GenericServiceImpl<Ajudante>(Ajudante.class);
	//private AjudanteDAO dao = new AjudanteDAOImpl();

	@Override
	public Response cadastrarOuAtualizarFuncionario(Ajudante funcionario) {
		try {
			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.adiciona(funcionario);
				URI uri = URI.create("/ajudante/listar/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.atualiza(funcionario);
				return Response.status(200).build();
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

		return new ConversorDTO().coverteListaAjudante(genericservice.listaTodosDetalhado());

	}

	@Override
	public Ajudante buscaPorIdDetalhado(Integer id) {
		return genericservice.buscaPorId(id);
	}

	@Override
	public AjudanteDTO buscaPorIdSimples(Integer id) {

		return new ConversorDTO().converteAjudante(genericservice.buscaPorId(id));

	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericservice.remove(id);
			return Response.status(200).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}

	}

}
