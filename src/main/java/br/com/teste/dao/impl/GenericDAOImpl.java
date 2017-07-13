package br.com.teste.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.teste.dao.GenericDAO;



@SuppressWarnings("serial")
public class GenericDAOImpl<T> implements Serializable,GenericDAO<T> {

	private final Class<T> classe;
	private EntityManager em;

	public GenericDAOImpl(EntityManager manager, Class<T> classe) {
		this.em = manager;
		this.classe = classe;
	}

	public void adiciona(T t)throws SQLException {
		// persiste o objeto
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public void remove(Integer id) throws SQLException{
		em.getTransaction().begin();
		em.remove(em.merge(em.find(classe, id)));
		em.getTransaction().commit();
	}

	public void atualiza(T t) throws SQLException{
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}

	public List<T> listaTodos() throws SQLException {
		em.getTransaction().begin();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();
		em.getTransaction().commit();

		return lista;
	}

	public T buscaPorId(Integer id) throws SQLException{
		em.getTransaction().begin();
		T instancia = em.find(classe, id);
		em.getTransaction().commit();
		return instancia;
	}


}
