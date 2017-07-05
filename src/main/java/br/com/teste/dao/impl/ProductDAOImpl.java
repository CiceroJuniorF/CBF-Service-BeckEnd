package br.com.teste.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.teste.dao.ProductDAO;
import br.com.teste.entites.Produto;
import br.com.teste.factory.EMFactory;



public class ProductDAOImpl implements ProductDAO{

	EntityManager em = new EMFactory().getEntityManager();
	
	public Produto produto(){
		return new Produto("Pipoca");
	}
	
	@Override
	public String adicionar(){
		this.em.getTransaction().begin();
		this.em.merge(this.produto());
		this.em.getTransaction().commit();
	
	
		return this.produto().toString();
	}

	@Override
	public void adicionar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		
		
	}

	@Override
	public List<Produto> listaTodos() {
		em.getTransaction().begin();
		String jpql = "select p from Product p";
		Query query = em.createQuery(jpql);
		this.em.getTransaction().commit();
		
		@SuppressWarnings("unchecked")
		List<Produto> list = query.getResultList();
		return list;
	}

	@Override
	public String deletar(Integer id) {
		try{
		em.getTransaction().begin();
		em.remove(em.find(Produto.class,id));
		this.em.getTransaction().commit();
		return "Deletado Com Sucesso";
		}catch(Exception e){
			return "Erro ao deletar";
		}
		
	}

	@Override
	public Produto pesquisarId(Integer id) {
		Produto produto;
		em.getTransaction().begin();
		produto = em.find(Produto.class,id);
		this.em.getTransaction().commit();
		return produto;
	}
}
