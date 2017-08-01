package br.com.cbf.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.cbf.dto.ConsultadorDTO;
import br.com.cbf.entites.Consultador;

public interface ConsultadorService {
	
	public Response cadastrarOuAtualizarConsultador(Consultador consultador);

	public List<Consultador> listarTodosConsultadorsDetalhado();

	public List<ConsultadorDTO> listarTodosConsultadoresSimples();

	public Response buscaPorIdSimples(Integer id);

	public Response buscaPorIdDetalhado(Integer id);

	public Response deletar(Integer id);
	
	public Response realizarConsultaDeCPFdeCliente(String CPF);
}
