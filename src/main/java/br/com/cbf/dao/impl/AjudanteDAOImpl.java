package br.com.cbf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.AjudanteDAO;
import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dto.AjudanteDTO;
import br.com.cbf.entites.Ajudante;

public class AjudanteDAOImpl implements AjudanteDAO {

	EntityManager em;
	private GenericDAO<Ajudante> dao;

	public AjudanteDAOImpl(EntityManager em) {
		this.em = em;
		this.dao = new GenericDAOImpl<Ajudante>(this.em, Ajudante.class);
	}

	@Override
	public List<AjudanteDTO> listarSimples() {
		@SuppressWarnings("unchecked")
		List<AjudanteDTO> listaDeAjudantesDTO = (List<AjudanteDTO>) em.createQuery(
				"SELECT new br.com.cbf.dto.AjudanteDTO(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) FROM Ajudante")
				.getResultList();

		return listaDeAjudantesDTO;
	}

	@Override
	public AjudanteDTO buscaSimples(Integer id) {

		AjudanteDTO ajudanteDTO = (AjudanteDTO) em.createQuery(
				"SELECT new br.com.cbf.dto.AjudanteDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Ajudante a where a.idUsuario = :pId")
				.setParameter("pId", id).getSingleResult();

		return ajudanteDTO;
	}

	@Override
	public void salvar(Ajudante entity) throws SQLException {		
		em.persist(entity.getEndereco());
		this.dao.adiciona(entity);	
	}
	
	@Override
	public void atualiza (Ajudante entity) throws SQLException {
		em.merge(entity.getEndereco());
		this.dao.atualiza(entity);
	}

}
