package br.com.cbf.webservice;

import java.util.List;

import br.com.cbf.entites.Produto;

public interface ProductWebservice {
	public String persistir();
	 public String hello();
	 public String cadastrar(Produto string);
	 public List<Produto> listar();
	 public String deletar(Integer id);
	public Produto pesquisarId(Integer id);
}
