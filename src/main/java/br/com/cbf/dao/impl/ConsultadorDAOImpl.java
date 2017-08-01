package br.com.cbf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.ConsultadorDAO;
import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.entites.Consultador;

public class ConsultadorDAOImpl implements ConsultadorDAO {

	EntityManager em;
	private GenericDAO<Consultador> dao;

	public ConsultadorDAOImpl(EntityManager em) {
		this.em = em;
		this.dao = new GenericDAOImpl<Consultador>(this.em, Consultador.class);
	}

	@Override
	public List<ConsultadorDTO> listarSimples() {
		@SuppressWarnings("unchecked")
		List<ConsultadorDTO> listaDeConsultadorsDTO = (List<ConsultadorDTO>) em.createQuery(
				"SELECT new br.com.cbf.dto.ConsultadorDTO(idUsuario,nome,email,nivelAcesso) FROM Consultador")
				.getResultList();

		return listaDeConsultadorsDTO;
	}

	@Override
	public ConsultadorDTO buscaSimples(Integer id) {

		ConsultadorDTO ConsultadorDTO = (ConsultadorDTO) em.createQuery(
				"SELECT new br.com.cbf.dto.ConsultadorDTO(a.idUsuario,a.nome,a.email,a.nivelAcesso) FROM Consultador a where a.idUsuario = :pId")
				.setParameter("pId", id).getSingleResult();

		return ConsultadorDTO;
	}

	@Override
	public void salvar(Consultador entity) throws SQLException {		
		em.persist(entity.getEndereco());
		this.dao.adiciona(entity);	
	}
	
	@Override
	public void atualiza (Consultador entity) throws SQLException {
		em.merge(entity.getEndereco());
		this.dao.atualiza(entity);
	}

}
