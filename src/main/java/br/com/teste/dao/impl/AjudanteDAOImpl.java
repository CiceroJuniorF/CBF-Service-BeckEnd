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
	EntityManager em = new EMFactory().getEntityManager();
	
	private GenericDAO<Ajudante> dao = new GenericDAOImpl<Ajudante>(this.em, Ajudante.class);
	
	@Override
	public void cadastrarFuncionario(Ajudante funcionario) throws SQLException {
		
		
		this.ajudante = (Ajudante) funcionario;		
		this.dao.adiciona(ajudante);
		
		
	}

	@Override
	public List<Ajudante> listarTodosAjudantes() throws SQLException {
		
		return dao.listaTodos();
	}
 
}
