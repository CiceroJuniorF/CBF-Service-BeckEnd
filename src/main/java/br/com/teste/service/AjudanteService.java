package br.com.teste.service;

import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.entites.Ajudante;

public interface AjudanteService {

	public Response cadastrarFuncionario(Ajudante funcionario);
	
	public List<Ajudante> listarTodosAjudantes();
	
	public Ajudante buscaPorId(Integer id);
	
	public Response deletar(Integer id);
			
}
