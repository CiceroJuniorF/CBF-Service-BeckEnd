package br.com.cbf.dao;

import java.util.List;

import br.com.cbf.entites.Produto;

public interface ProductDAO {
	public String adicionar();

	public void adicionar(Produto produto);
	
	public List<Produto> listaTodos();
	
	public String deletar(Integer id);
	
	public Produto pesquisarId(Integer id);
}
