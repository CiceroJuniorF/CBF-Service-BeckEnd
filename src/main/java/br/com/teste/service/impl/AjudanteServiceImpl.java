package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dao.AjudanteDAO;
import br.com.teste.dao.impl.AjudanteDAOImpl;
import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.factory.EMFactory;
import br.com.teste.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {
	
	private EntityManager em = new EMFactory().getEntityManager();
	private GenericServiceImpl<Ajudante> genericservice = new GenericServiceImpl<Ajudante>(Ajudante.class, this.em);	
	private AjudanteDAO dao = new AjudanteDAOImpl(this.em);

	@Override
	public Response cadastrarOuAtualizarFuncionario(Ajudante funcionario) {
		try {
			
			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				dao.salvar(funcionario);
				em.getTransaction().commit();
				
				URI uri = URI.create("/ajudante/listarDetalhado/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.atualiza(funcionario);				
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	public List<Ajudante> listarTodosFuncionariosDetalhado() {

		return genericservice.listaTodosDetalhado();

	}

	@Override
	public List<AjudanteDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<AjudanteDTO> lista = dao.listarSimples();
			em.getTransaction().commit();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

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
			em.getTransaction().begin();
			AjudanteDTO ajudante = dao.buscaSimples(id);
			em.getTransaction().commit();
			
			return Response.status(200).entity(ajudante).build();
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
