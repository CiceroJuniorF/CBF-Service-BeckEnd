package br.com.teste.service;

import java.util.List;

import br.com.teste.entites.Produto;

public interface ProductService {
	public String persistir();

	public String cadastrar(String string);

	public List<Produto> listar();
	
	public String deletar(Integer id);
	
	public Produto pesquisarId(Integer id);

}
