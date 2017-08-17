package br.com.cbf.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.VendedorDAO;
import br.com.cbf.dao.impl.VendedorDAOImpl;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.VendedorService;

public class VendedorServiceImpl extends FuncionarioServiceImpl implements VendedorService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Vendedor---------------------------------------------------------------//

	private VendedorDAO daoVendedor = new VendedorDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Vendedor---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<FuncionarioDTO> lista = daoVendedor.listarSimples();
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
			for (Funcionario funcionario : daoVendedor.listaTodosDetalhado()) {
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
