package br.com.teste.service.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.GenericDAO;
import br.com.teste.dao.impl.GenericDAOImpl;
import br.com.teste.factory.EMFactory;



@SuppressWarnings("serial")
public class GenericServiceImpl<Entity> implements Serializable{

	@SuppressWarnings("unused")
	private final Class<Entity> classe;
	private final GenericDAO<Entity> dao;
	private final EntityManager em =  new EMFactory().getEntityManager();

	public GenericServiceImpl(Class<Entity> classe) {
		this.classe = classe;
		this.dao = new GenericDAOImpl<Entity>(this.em, classe);
	}

	public void adiciona(Entity t){
		
		try {
			this.dao.adiciona(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Integer id){
		
		try {
			this.dao.remove(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualiza(Entity t){
		try {
			this.dao.atualiza(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Entity> listaTodosDetalhado(){
		try {
			return this.dao.listaTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Entity buscaPorId(Integer id){
		try {
			return this.dao.buscaPorId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
