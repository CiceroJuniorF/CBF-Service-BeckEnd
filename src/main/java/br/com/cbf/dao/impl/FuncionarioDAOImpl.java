package br.com.cbf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.FuncionarioDAO;
import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	protected EntityManager em;
	private GenericDAO<Funcionario> dao;

	public FuncionarioDAOImpl(EntityManager em) {
		this.em = em;
		dao = new GenericDAOImpl<Funcionario>(this.em, Funcionario.class);
	}

	@Override
	public List<FuncionarioDTO> listarSimples() {
		//List<FuncionarioDTO> listaDeFuncionarioDTO = (List<FuncionarioDTO>) em.createNamedQuery("Funcionario.findDTO", FuncionarioDTO.class).getResultList();
		@SuppressWarnings("unchecked")
		List<FuncionarioDTO> listaDeAjudantesDTO = (List<FuncionarioDTO>) em.createQuery(
				"SELECT new br.com.cbf.dto.FuncionarioDTO(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) FROM Funcionario")
				.getResultList();

		return listaDeAjudantesDTO;
	}

	@Override
	public FuncionarioDTO buscaSimples(Integer id) {
		//List<FuncionarioDTO> listaDeFuncionarioDTO = (List<FuncionarioDTO>) em.createNamedQuery("Funcionario.findDTOID", FuncionarioDTO.class).setParameter("pId", id).getSingleResult();
		FuncionarioDTO funcionarioDTO = (FuncionarioDTO) em.createQuery(
				"SELECT new br.com.cbf.dto.FuncionarioDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Funcionario a where a.idUsuario = :pId")
				.setParameter("pId", id).getSingleResult();

		return funcionarioDTO;
	}

	@Override
	public void salvar(Funcionario entity) throws SQLException {		
		em.persist(entity.getEndereco());
		dao.adiciona(entity);	
	}
	
	@Override
	public void atualiza (Funcionario entity) throws SQLException {
		em.merge(entity.getEndereco());
		dao.atualiza(entity);
	}

	@Override
	public List<Funcionario> listaTodosDetalhado() throws SQLException {
		
		return dao.listaTodos();
	}

	@Override
	public Funcionario buscaPorId(Integer id) throws SQLException {
		
		return dao.buscaPorId(id);
	}

	@Override
	public void remove(Integer id)  throws SQLException{
		dao.remove(id);
		
	}


}
