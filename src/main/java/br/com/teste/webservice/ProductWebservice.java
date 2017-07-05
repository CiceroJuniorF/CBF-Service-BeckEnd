package br.com.teste.webservice;

import java.util.List;

import br.com.teste.entites.Produto;

public interface ProductWebservice {
	public String persistir();
	 public String hello();
	 public String cadastrar(String string);
	 public List<Produto> listar();
	 public String deletar(Integer id);
	public Produto pesquisarId(Integer id);
}
