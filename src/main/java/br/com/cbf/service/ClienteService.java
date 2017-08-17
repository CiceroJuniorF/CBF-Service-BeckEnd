package br.com.cbf.service;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;
import br.com.cbf.exception.ClienteException;

public interface ClienteService {
	
	public List<ClienteDTO> listarTodosClientesDetalhado();

	public List<ClienteDTO> listarTodosClienteesSimples();

	public Cliente buscaPorIdSimples(Integer id);

	public Cliente buscaPorIdDetalhado(Integer id);
	
	public Cliente realizarConsultaDeCPF(String CPF, String dataNascimento,Funcionario consultador) throws ClienteException, SQLException;
	
	public boolean verificaCPFExistente(String CPF) throws ClienteException;

	public ClienteDTO cadastrar(Cliente cliente) throws SQLException;

	public ClienteDTO atualizar(Cliente cliente, RegistroAlteracoesCliente alteracao) throws SQLException;
}
