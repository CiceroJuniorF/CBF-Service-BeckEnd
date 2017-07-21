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
		em.getTransaction().begin();
	
		@SuppressWarnings("unchecked")
		List<Ajudante> listaDeAjudantes = (List<Ajudante>) em.createQuery(
				"select new br.com.teste.entites.Ajudante(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) from Ajudante")
				.getResultList();
		em.getTransaction().commit();
		return listaDeAjudantes;
	}



}
