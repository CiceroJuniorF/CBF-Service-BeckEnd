package br.com.teste.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.dto.ConsultadorDTO;
import br.com.teste.entites.Consultador;

public interface ConsultadorService {
	
	public Response cadastrarOuAtualizarConsultador(Consultador consultador);

	public List<Consultador> listarTodosConsultadorsDetalhado();

	public List<ConsultadorDTO> listarTodosConsultadoresSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);

	public Response deletar(Integer id);
	
	public Response realizarConsultaDeCPFdeCliente(String CPF);
}
