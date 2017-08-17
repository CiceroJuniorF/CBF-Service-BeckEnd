package br.com.cbf.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.AjudanteDAO;
import br.com.cbf.dao.impl.AjudanteDAOImpl;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.AjudanteService;

public class AjudanteServiceImpl extends FuncionarioServiceImpl implements AjudanteService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Ajudante---------------------------------------------------------------//

	private AjudanteDAO daoAjudante = new AjudanteDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Ajudante---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<FuncionarioDTO> lista = daoAjudante.listarSimples();
			em.getTransaction().commit();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosDetalhado() {
		try {
			em.getTransaction().begin();
			List<FuncionarioDTO> listaTodosDetalhado  = new ArrayList<>();
			for (Funcionario funcionario : daoAjudante.listaTodosDetalhado()) {
				listaTodosDetalhado.add(new FuncionarioDTO(funcionario));
			}
			em.getTransaction().commit();
			return listaTodosDetalhado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
