package br.com.teste.service.impl;

import java.util.List;

import com.google.gson.Gson;

import br.com.teste.dao.ProductDAO;
import br.com.teste.dao.impl.ProductDAOImpl;
import br.com.teste.entites.Produto;
import br.com.teste.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDAO dao = new ProductDAOImpl();
	@Override
	public String persistir() {
		return dao.adicionar();
	}

	@Override
	public String cadastrar(String string) {
		Produto produto = new Gson().fromJson(string, Produto.class);
		try {

			dao.adicionar(produto);

			return "Registro cadastrado com sucesso!";

		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}

	@Override
	public List<Produto> listar() {
		return dao.listaTodos();
	}

	@Override
	public String deletar(Integer id) {
		
		return dao.deletar(id);
	}

	@Override
	public Produto pesquisarId(Integer id) {
		
		return dao.pesquisarId(id);
	}
	
}
