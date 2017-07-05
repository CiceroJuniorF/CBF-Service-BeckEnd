package br.com.teste.dao;

import java.util.List;

import br.com.teste.entites.Produto;

public interface ProductDAO {
	public String adicionar();

	public void adicionar(Produto produto);
	
	public List<Produto> listaTodos();
	
	public String deletar(Integer id);
	
	public Produto pesquisarId(Integer id);
}
