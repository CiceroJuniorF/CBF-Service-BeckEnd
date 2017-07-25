package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dao.VendedorDAO;
import br.com.teste.dao.impl.VendedorDAOImpl;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Vendedor;
import br.com.teste.factory.EMFactory;
import br.com.teste.service.VendedorService;

public class VendedorServiceImpl implements VendedorService {
	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Vendedor---------------------------------------------------------------//
	private GenericServiceImpl<Vendedor> genericserviceVendedor = new GenericServiceImpl<Vendedor>(Vendedor.class,
			this.em);
	private VendedorDAO daoVendedor = new VendedorDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Vendedor---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarOuAtualizarFuncionario(Vendedor funcionario) {
		try {

			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoVendedor.salvar(funcionario);
				em.getTransaction().commit();

				URI uri = URI.create("/Vendedor/listarDetalhado/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				daoVendedor.atualiza(funcionario);
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	public List<Vendedor> listarTodosFuncionariosDetalhado() {

		return genericserviceVendedor.listaTodosDetalhado();

	}

	@Override
	public List<VendedorDTO> listarTodosFuncionariosSimples() {

		try {
			em.getTransaction().begin();
			List<VendedorDTO> lista = daoVendedor.listarSimples();
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
			return Response.status(200).entity(genericserviceVendedor.buscaPorId(id)).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		try {
			em.getTransaction().begin();
			VendedorDTO Vendedor = daoVendedor.buscaSimples(id);
			em.getTransaction().commit();

			return Response.status(200).entity(Vendedor).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericserviceVendedor.remove(id);
			return Response.status(202).build();
		} catch (Exception e) {
			return Response.status(304).build();
		}

	}
	// -----------------------------------------------------------------------------------------------------------------//

}
