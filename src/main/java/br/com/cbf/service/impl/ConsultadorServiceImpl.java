package br.com.cbf.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.ConsultadorDAO;
import br.com.cbf.dao.impl.ConsultadorDAOImpl;
import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.entites.Consultador;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.ConsultadorService;

public class ConsultadorServiceImpl implements ConsultadorService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Consultador---------------------------------------------------------------//
	private GenericServiceImpl<Consultador> genericserviceConsultador = new GenericServiceImpl<Consultador>(Consultador.class,
			this.em);
	private ConsultadorDAO daoConsultador = new ConsultadorDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Consultador---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarOuAtualizarConsultador(Consultador Consultador) {
		try {

			if (Consultador.getIdUsuario() == null) {
				Consultador.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoConsultador.salvar(Consultador);
				em.getTransaction().commit();

				URI uri = URI.create("/consultador/listarDetalhado/" + Consultador.getIdUsuario());
				return Response.created(uri).build();

			} else {
				Consultador.setDataAtualizacao(DataAuxiliar.dataAtual());				
				em.getTransaction().begin();
				daoConsultador.atualiza(Consultador);
				em.getTransaction().commit();
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	public List<Consultador> listarTodosConsultadorsDetalhado() {

		return genericserviceConsultador.listaTodosDetalhado();

	}

	@Override
	public List<ConsultadorDTO> listarTodosConsultadoresSimples() {

		try {
			em.getTransaction().begin();
			List<ConsultadorDTO> lista = daoConsultador.listarSimples();
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
			return Response.status(200).entity(genericserviceConsultador.buscaPorId(id)).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		try {
			em.getTransaction().begin();
			ConsultadorDTO Consultador = daoConsultador.buscaSimples(id);
			em.getTransaction().commit();

			return Response.status(200).entity(Consultador).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericserviceConsultador.remove(id);
			return Response.status(202).build();
		} catch (Exception e) {
			return Response.status(304).build();
		}

	}

	

	// -----------------------------------------------------------------------------------------------------------------//



}
