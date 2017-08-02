package br.com.cbf.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.FuncionarioDAO;
import br.com.cbf.dao.impl.FuncionarioDAOImpl;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.Venda;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Funcionario---------------------------------------------------------------//
	private FuncionarioDAO daoFuncionario = new FuncionarioDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Funcionario---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarOuAtualizarFuncionario(Funcionario funcionario) {
		try {

			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoFuncionario.salvar(funcionario);
				em.getTransaction().commit();

				URI uri = URI.create("/Funcionario/listarDetalhado/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataAtualizacao(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoFuncionario.atualiza(funcionario);
				em.getTransaction().commit();
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	public List<Funcionario> listarTodosFuncionariosDetalhado() {
		try {
			em.getTransaction().begin();
			List<Funcionario> listaTodosDetalhado = daoFuncionario.listaTodosDetalhado();
			em.getTransaction().commit();
			return listaTodosDetalhado;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FuncionarioDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<FuncionarioDTO> lista = daoFuncionario.listarSimples();
			em.getTransaction().commit();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Response buscaPorIdDetalhado(Integer id) {
		try {
			em.getTransaction().begin();
			Funcionario buscaPorId = daoFuncionario.buscaPorId(id);
			em.getTransaction().commit();
			return Response.status(200).entity(buscaPorId).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		try {
			em.getTransaction().begin();
			FuncionarioDTO funcionario = daoFuncionario.buscaSimples(id);
			em.getTransaction().commit();

			return Response.status(200).entity(funcionario).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(204).build();
		}
	}

	@Override
	public Response deletar(Integer id) {
		try {
			em.getTransaction().begin();
			daoFuncionario.remove(id);
			em.getTransaction().commit();
			return Response.status(202).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(304).build();
		}

	}

	@Override
	public Response realizarVenda(Venda venda) {
		// TODO Auto-generated method stub
		return null;
	}
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}
}
