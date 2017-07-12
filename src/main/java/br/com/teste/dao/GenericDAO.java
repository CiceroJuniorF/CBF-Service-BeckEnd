package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T>  {	
	public void adiciona(T t) throws SQLException;
	public void remove(Integer id) throws SQLException;
	public void atualiza(T t) throws SQLException;
	public List<T> listaTodos() throws SQLException;
	public T buscaPorId(Integer id) throws SQLException;
}
