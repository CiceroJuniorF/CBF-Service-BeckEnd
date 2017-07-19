package br.com.teste.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.AjudanteDAO;
import br.com.teste.dao.GenericDAO;
import br.com.teste.entites.Ajudante;
import br.com.teste.factory.EMFactory;

public class AjudanteDAOImpl implements AjudanteDAO {
	private Ajudante ajudante;
	

	EntityManager em =  new EMFactory().getEntityManager();
	
	private GenericDAO<Ajudante> dao = new GenericDAOImpl<Ajudante>(this.em, Ajudante.class);
	
	@Override
	public void cadastrarFuncionario(Ajudante funcionario) throws SQLException {
		
		this.ajudante = funcionario;		
		this.dao.adiciona(ajudante);
	}

	@Override
	public List<Ajudante> listarTodosAjudantes() throws SQLException {
		
		return dao.listaTodos();
	}

	@Override
	public Ajudante buscaPorId(Integer id) throws SQLException {
		
		return this.dao.buscaPorId(id);
	}

	@Override
	public void deletar(Integer id) throws SQLException {
		
		dao.remove(id);
	}

	@Override
	public void atualizar(Ajudante ajudante) throws SQLException {
		
		dao.atualiza(ajudante);
		
	}
 
}
