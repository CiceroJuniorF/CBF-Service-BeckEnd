package br.com.cbf.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.VendedorDAO;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.enums.Acesso;

public class VendedorDAOImpl extends FuncionarioDAOImpl implements VendedorDAO {

	public VendedorDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<FuncionarioDTO> listarSimples() {
		@SuppressWarnings("unchecked")
		List<FuncionarioDTO> listaDeAjudantesDTO = (List<FuncionarioDTO>) em.createQuery(
				"SELECT new br.com.cbf.dto.FuncionarioDTO(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) FROM Funcionario where Funcionario.nivelAcesso = :pAcesso")
				.setParameter("pAcesso", Acesso.VENDEDOR)
				.getResultList();

		return listaDeAjudantesDTO;
	}

	@Override
	public List<Funcionario> listaTodosDetalhado() {
		
		
		@SuppressWarnings("unchecked")
		List<Funcionario> listaDeAjudantes = (List<Funcionario>) em.createQuery(
				"SELECT a FROM Funcionario a where a.nivelAcesso = :pAcesso")
				.setParameter("pAcesso", Acesso.VENDEDOR)
				.getResultList();

		return listaDeAjudantes;
		
	}
	

}	


