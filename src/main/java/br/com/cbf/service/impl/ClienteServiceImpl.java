package br.com.cbf.service.impl;

import java.sql.SQLException;
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
		cliente.getRegistro().setDataCadastro(DataAuxiliar.dataAtual());
		cliente.getRegistro().setCliente(cliente);
		em.getTransaction().begin();
		ClienteDTO clienteCadastrado = new ClienteDTO(daoCliente.salvar(cliente));
		em.getTransaction().commit();
		return clienteCadastrado;
	}

	@Override
	public ClienteDTO atualizar(Cliente cliente, RegistroAlteracoesCliente alteracao) throws SQLException {
		
		alteracao.setDataAtualizacao(DataAuxiliar.dataAtual());
		alteracao.setDetalhesCliente(cliente.getRegistro());
		
		em.getTransaction().begin();
		ClienteDTO clienteAtualizado = new ClienteDTO(daoCliente.atualiza(cliente, alteracao));
		em.getTransaction().commit();
		return clienteAtualizado;

	}

	@Override
	public List<Cliente> listarTodosClientesDetalhado() {
		try {
			em.getTransaction().begin();
			List<Cliente> clientes = daoCliente.listaTodosDetalhado();
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
