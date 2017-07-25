package br.com.teste.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.GenericDAO;
import br.com.teste.dao.MasterDAO;
import br.com.teste.dto.MasterDTO;
import br.com.teste.entites.Master;

public class MasterDAOImpl implements MasterDAO {

	EntityManager em;
	private GenericDAO<Master> dao;

	public MasterDAOImpl(EntityManager em) {
		this.em = em;
		this.dao = new GenericDAOImpl<Master>(this.em, Master.class);
	}

	@Override
	public void salvar(Master entity) throws SQLException {
		em.persist(entity.getEndereco());
		this.dao.adiciona(entity);

	}

	@Override
	public List<MasterDTO> listarSimples() throws SQLException {

		@SuppressWarnings("unchecked")
		List<MasterDTO> listaDeMastersDTO = (List<MasterDTO>) em
				.createQuery("SELECT new br.com.teste.dto.MasterDTO(idUsuario,nome,email,nivelAcesso) FROM Master")
				.getResultList();

		return listaDeMastersDTO;

	}

	@Override
	public MasterDTO buscaSimples(Integer id) throws SQLException {
		MasterDTO masterDTO = (MasterDTO) em.createQuery(
				"SELECT new br.com.teste.dto.MasterDTO(a.idUsuario,a.nome,a.email,a.nivelAcesso) FROM Master a where a.idUsuario = :pId")
				.setParameter("pId", id).getSingleResult();

		return masterDTO;
	}

	@Override
	public void atualiza(Master entity) throws SQLException {
		em.merge(entity.getEndereco());
		this.dao.atualiza(entity);

	}

}
