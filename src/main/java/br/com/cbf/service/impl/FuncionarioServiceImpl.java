package br.com.cbf.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.Alerts;
import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.FuncionarioDAO;
import br.com.cbf.dao.impl.FuncionarioDAOImpl;
import br.com.cbf.dto.FuncionarioDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;
import br.com.cbf.entites.Venda;
import br.com.cbf.exception.ClienteException;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.ClienteService;
import br.com.cbf.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Funcionario---------------------------------------------------------------//
	private FuncionarioDAO daoFuncionario = new FuncionarioDAOImpl(this.em);
	private ClienteService clienteService = new ClienteServiceImpl();
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
	public List<FuncionarioDTO> listarTodosFuncionariosDetalhado() {
		try {
			em.getTransaction().begin();
			List<FuncionarioDTO> listaTodosDetalhado  = new ArrayList<>();
			for (Funcionario funcionario : daoFuncionario.listaTodosDetalhado()) {
				listaTodosDetalhado.add(new FuncionarioDTO(funcionario));
			}
			
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
			FuncionarioDTO buscaPorId = new FuncionarioDTO(daoFuncionario.buscaPorId(id));
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

	public Response cadastrarCliente(Cliente cliente) {
		try {

			return Response.status(201).entity(clienteService.cadastrar(cliente)).build();
		} catch (SQLException e) {
			System.out.println("ERRRRROOOORRR" + e.getMessage());
			e.printStackTrace();
			return Response.status(304).entity(new Alerts(e.getMessage())).build();
		} catch (Exception e) {
			System.out.println("ERRRRROOOORRR" + e.getMessage());
			e.printStackTrace();
			return Response.status(500).entity(new Alerts(e.getLocalizedMessage())).build();
		}

	}

	@Override
	public Response realizarConsultaDeCPFDeCliente(String cpfCliente, String dataNascimentoCliente,
			Funcionario funcionario) {
		try {
			clienteService.verificaCPFExistente(cpfCliente);
			Cliente clienteBuscado = clienteService.realizarConsultaDeCPF(cpfCliente, dataNascimentoCliente,
					funcionario);
			return Response.status(200).entity(clienteBuscado).build();
		} catch (ClienteException e) {
			e.printStackTrace();
			return Response.status(500).entity(new Alerts(e.getMessage())).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).entity(new Alerts(e.getMessage())).build();
		}
	}

	@Override
	public Response atualizarCliente(RegistroAlteracoesCliente alteracao) {
		try {

			return Response.status(201).entity(clienteService.atualizar(alteracao)).build();
		} catch (SQLException e) {
		
			e.printStackTrace();
			return Response.status(304).entity(new Alerts(e.getMessage())).build();
		} catch (Exception e) {
			System.out.println("ERRRRROOOORRR" + e.getMessage());
			e.printStackTrace();
			return Response.status(500).entity(new Alerts(e.getMessage())).build();
		}
	}
	
	
}
