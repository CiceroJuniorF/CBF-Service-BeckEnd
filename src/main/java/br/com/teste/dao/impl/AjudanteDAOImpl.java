package br.com.teste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.AjudanteDAO;
import br.com.teste.entites.Ajudante;
import br.com.teste.factory.EMFactory;

public class AjudanteDAOImpl implements AjudanteDAO {

	EntityManager em = new EMFactory().getEntityManager();

	@Override
	public List<Ajudante> buscaSimples() {
		
		List<Ajudante> recebe = em.createNamedQuery("Ajudante.findDTO", Ajudante.class).getResultList();
		System.out.println(recebe);
		return recebe;
	}
	
	//
	
	

}
