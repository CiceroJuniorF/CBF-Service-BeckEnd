package br.com.teste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.VendedorDAO;
import br.com.teste.entites.Vendedor;
import br.com.teste.factory.EMFactory;

public class VendedorDAOImpl implements VendedorDAO {

	EntityManager em = new EMFactory().getEntityManager();

	@Override
	public List<Vendedor> buscaSimples() {
		em.getTransaction().begin();
	
		@SuppressWarnings("unchecked")
		List<Vendedor> listaDeVendedor = (List<Vendedor>) em.createQuery(
				"select new br.com.teste.entites.Vendedor(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) from Vendedor")
				.getResultList();
		em.getTransaction().commit();
		return listaDeVendedor;
	}



}
