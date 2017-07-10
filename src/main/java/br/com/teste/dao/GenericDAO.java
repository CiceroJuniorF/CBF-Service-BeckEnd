package br.com.teste.dao;

import java.util.List;

public interface GenericDAO<T>  {	
	public void adiciona(T t);
	public void remove(T t);
	public void atualiza(T t);
	public List<T> listaTodos();
	public T buscaPorId(Integer id);
}
