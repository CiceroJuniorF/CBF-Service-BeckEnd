package br.com.cbf.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.ClienteDAO;
import br.com.cbf.dao.impl.ClienteDAOImpl;
import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;
import br.com.cbf.entites.RegistroDeConsulta;
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
	public ClienteDTO cadastrar(Cliente cliente) throws SQLException {

		em.getTransaction().begin();
		cliente.getRegistro().setDataCadastro(DataAuxiliar.dataAtual());
		ClienteDTO clienteCadastrado = new ClienteDTO(daoCliente.salvar(cliente));
		em.getTransaction().commit();
		return clienteCadastrado;
	}

	@Override
	public ClienteDTO atualizar(RegistroAlteracoesCliente alteracao) throws SQLException {

		
		em.getTransaction().begin();
		RegistroAlteracoesCliente alteracaoCliente = daoCliente.atualiza(alteracao);
		em.getTransaction().commit();
		return new ClienteDTO(alteracaoCliente.getClienteAlterado());

	}

	@Override
	public List<ClienteDTO> listarTodosClientesDetalhado() {
		try {
			em.getTransaction().begin();
			List<ClienteDTO> clientes = new ArrayList<>(); 
			for (Cliente cliente : daoCliente.listaTodosDetalhado() ) {
				clientes.add(new ClienteDTO(cliente));
			}
			
			em.getTransaction().commit();
			return clientes;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<ClienteDTO> listarTodosClienteesSimples() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente realizarConsultaDeCPF(String CPF, String dataNascimento, Funcionario consultador)
			throws ClienteException, SQLException {

		Cliente cliente = new BuscaCPF().buscaPorCPF(CPF, dataNascimento);

		RegistroDeConsulta registro = new RegistroDeConsulta(CPF, DataAuxiliar.coverteString(dataNascimento),
				consultador, DataAuxiliar.dataAtual());
		em.getTransaction().begin();
		daoCliente.registraConsultaCliente(registro);
		em.getTransaction().commit();

		return cliente;

	}

	@Override
	public boolean verificaCPFExistente(String CPF) throws ClienteException {
		boolean clienteExistente = daoCliente.verificaExisteCPF(CPF);
		return clienteExistente;
	}

	@Override
	public Cliente buscaPorIdSimples(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscaPorIdDetalhado(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
