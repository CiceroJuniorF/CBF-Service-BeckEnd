package br.com.cbf.service.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dao.impl.GenericDAOImpl;



@SuppressWarnings("serial")
public class GenericServiceImpl<Entity> implements Serializable{

	@SuppressWarnings("unused")
	private final Class<Entity> classe;
	private final GenericDAO<Entity> dao;
	private final EntityManager em;

	public GenericServiceImpl(Class<Entity> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
		this.dao = new GenericDAOImpl<Entity>(this.em, classe);
		
	}

	public void adiciona(Entity t){
		
		try {
			em.getTransaction().begin();
			this.dao.adiciona(t);
			em.getTransaction().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Integer id){
		
		try {
			em.getTransaction().begin();
			this.dao.remove(id);
			em.getTransaction().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualiza(Entity t){
		try {
			em.getTransaction().begin();
			this.dao.atualiza(t);
			em.getTransaction().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Entity> listaTodosDetalhado(){
		try {
			em.getTransaction().begin();
			List<Entity> list = dao.listaTodos();
			em.getTransaction().commit();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Entity buscaPorId(Integer id){
		try {
			em.getTransaction().begin();
			Entity entity = dao.buscaPorId(id);
			em.getTransaction().commit();
			return entity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
