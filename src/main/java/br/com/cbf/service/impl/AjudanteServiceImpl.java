package br.com.cbf.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.AjudanteDAO;
import br.com.cbf.dao.impl.AjudanteDAOImpl;
import br.com.cbf.dto.AjudanteDTO;
import br.com.cbf.entites.Ajudante;
import br.com.cbf.entites.Venda;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.AjudanteService;

public class AjudanteServiceImpl implements AjudanteService {
	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------AJUDANTE---------------------------------------------------------------//
	private GenericServiceImpl<Ajudante> genericserviceAjudante = new GenericServiceImpl<Ajudante>(Ajudante.class,
			this.em);
	private AjudanteDAO daoAjudante = new AjudanteDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------AJUDANTE---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarOuAtualizarFuncionario(Ajudante funcionario) {
		try {

			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoAjudante.salvar(funcionario);
				em.getTransaction().commit();

				URI uri = URI.create("/ajudante/listarDetalhado/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataAtualizacao(DataAuxiliar.dataAtual());				
				em.getTransaction().begin();
				daoAjudante.atualiza(funcionario);
				em.getTransaction().commit();
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	public List<Ajudante> listarTodosFuncionariosDetalhado() {

		return genericserviceAjudante.listaTodosDetalhado();

	}

	@Override
	public List<AjudanteDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<AjudanteDTO> lista = daoAjudante.listarSimples();
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
			return Response.status(200).entity(genericserviceAjudante.buscaPorId(id)).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		try {
			em.getTransaction().begin();
			AjudanteDTO ajudante = daoAjudante.buscaSimples(id);
			em.getTransaction().commit();

			return Response.status(200).entity(ajudante).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericserviceAjudante.remove(id);
			return Response.status(202).build();
		} catch (Exception e) {
			return Response.status(304).build();
		}

	}
	
	@Override
	public Response realizarVenda(Venda venda) {
		// TODO Auto-generated method stub
		return null;
	}
	// -----------------------------------------------------------------------------------------------------------------//



}