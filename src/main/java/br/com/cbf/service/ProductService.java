package br.com.cbf.service;

import java.util.List;

import br.com.cbf.entites.Produto;

public interface ProductService {
	public String persistir();

	public String cadastrar(Produto produto);

	public List<Produto> listar();
	
	public String deletar(Integer id);
	
	public Produto pesquisarId(Integer id);

}
