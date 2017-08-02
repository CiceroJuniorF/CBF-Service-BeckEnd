package br.com.cbf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.AjudanteDAO;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.enums.Acesso;

public class AjudanteDAOImpl extends FuncionarioDAOImpl implements AjudanteDAO {

	public AjudanteDAOImpl(EntityManager em) {
		super(em);		
	}
	
	@Override
	public List<Funcionario> listaTodosDetalhado() {
		
		
		@SuppressWarnings("unchecked")
		List<Funcionario> listaDeAjudantes = (List<Funcionario>) em.createQuery(
				"SELECT a FROM Funcionario a where a.nivelAcesso = :pAcesso")
				.setParameter("pAcesso", Acesso.AJUDANTE)
				.getResultList();

		return listaDeAjudantes;
		
	}
	
	@Override
	public List<FuncionarioDTO> listarSimples() {
		@SuppressWarnings("unchecked")
		List<FuncionarioDTO> listaDeAjudantesDTO = (List<FuncionarioDTO>) em.createQuery(
				"SELECT new br.com.cbf.dto.FuncionarioDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Funcionario a where a.nivelAcesso = :pAcesso")
				.setParameter("pAcesso", Acesso.AJUDANTE)
				.getResultList();

		return listaDeAjudantesDTO;
	}
	



}
