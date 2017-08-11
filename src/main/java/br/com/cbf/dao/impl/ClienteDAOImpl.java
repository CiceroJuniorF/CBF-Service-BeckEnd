package br.com.cbf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.cbf.dao.ClienteDAO;
import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.RegistroDeConsulta;
import br.com.cbf.enums.CodigosErros;
import br.com.cbf.exception.ClienteException;

public class ClienteDAOImpl implements ClienteDAO {
	
	protected EntityManager em;
	private GenericDAO<Cliente> dao;

	public ClienteDAOImpl(EntityManager em) {
		this.em = em;
		dao = new GenericDAOImpl<Cliente>(this.em, Cliente.class);
	}
	
	@Override
	public void salvar(Cliente cliente) throws SQLException {
		
		em.persist(cliente.getEndereco());
		dao.adiciona(cliente);
		em.persist(cliente.getRegistro());		
		

	}

	@Override
	public List<ClienteDTO> listarSimples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO buscaSimples(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscaPorId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listaTodosDetalhado() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualiza(Cliente cliente) throws SQLException {
		
		em.persist(cliente.getRegistro().getAlteracao().size());
		em.merge(cliente.getRegistro());
		dao.atualiza(cliente);

	}

	@Override
	public boolean verificaExisteCPF(String CPF) throws ClienteException{
		
		try {
		
			@SuppressWarnings("unused")
			Cliente cliente = (Cliente)	em.createQuery("SELECT c FROM Cliente c where c.cpf = :pCPF")
				.setParameter("pCPF", CPF).getSingleResult();
			
			throw new ClienteException("O cliente ja esta cadastrado no banco de dados",CodigosErros.CLIENTECADASTRADO);
		}catch(NoResultException nre) {			
			return false;
		}
			
		
	}

	@Override
	public void registraConsultaCliente(RegistroDeConsulta registro)throws SQLException {
		
		em.persist(registro);
		
	}

}
