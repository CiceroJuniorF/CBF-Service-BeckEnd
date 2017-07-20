package br.com.teste.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.GenericDAO;
import br.com.teste.dao.VendedorDAO;
import br.com.teste.entites.Vendedor;
import br.com.teste.factory.EMFactory;

public class VendedorDAOImpl implements VendedorDAO{

EntityManager em =  new EMFactory().getEntityManager();
	
	private GenericDAO<Vendedor> dao = new GenericDAOImpl<Vendedor>(this.em, Vendedor.class);

	@Override
	public Vendedor buscaPorId(Integer id) throws SQLException {
		
		return this.dao.buscaPorId(id);
	}

	

	@Override
	public void adiciona(Vendedor Vendedor) throws SQLException {
		
		this.dao.adiciona(Vendedor);
		
	}

	@Override
	public void remove(Integer id) throws SQLException {
		dao.remove(id);
		
	}

	@Override
	public void atualiza(Vendedor Vendedor) throws SQLException {
		dao.atualiza(Vendedor);
		
	}

	@Override
	public List<Vendedor> listaTodos() throws SQLException {
		return dao.listaTodos();
	}

}
