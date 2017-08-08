package br.com.cbf.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.Alerts;
import br.com.cbf.dao.ClienteDAO;
import br.com.cbf.dao.impl.ClienteDAOImpl;
import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.enums.CodigosErros;
import br.com.cbf.exception.ClienteException;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.ClienteService;
import br.com.iwebservice.buscaCpf.BuscaCPF;

public class ClienteServiceImpl implements ClienteService {

	private EntityManager em = new EMFactory().getEntityManager();
	// ------------------------------------------Cliente---------------------------------------------------------------//
	private ClienteDAO daoCliente = new ClienteDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------Cliente---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	@Override
	public Response cadastrarOuAtualizarCliente(Cliente Cliente) {

		return null;
	}

	@Override
	public List<Cliente> listarTodosClientesDetalhado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> listarTodosClienteesSimples() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaPorIdSimples(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buscaPorIdDetalhado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response realizarConsultaDeCPFdeCliente(String CPF, String dataNascimento) {
		try {
			em.getTransaction().begin();
			daoCliente.verificaExisteCPF(CPF);
			em.getTransaction().commit();
			
			ClienteDTO dto = new BuscaCPF().buscaPorCPF(CPF, dataNascimento);

			if (dto.getSintuacao().toUpperCase().equals("REGULAR"))
				return Response.status(200).entity(dto).build();
			else {
				System.out.println("-----------------"+dto.getSintuacao());
				throw new ClienteException(
						"O cliente não obteve a liberação para cadastro devido não estar com a sintuação regular",
						CodigosErros.CLIENTEIRREGULAR);
			}
		} catch (ClienteException e) {
			e.printStackTrace();
			return Response.status(500).entity(new Alerts(e.getMessage())).build();
		}
	}

}
