package br.com.teste.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Vendedor;

public interface VendedorDAO{

	void salvar(Vendedor vendedor)throws SQLException;
	
	List<VendedorDTO> listarSimples()throws SQLException;

	VendedorDTO buscaSimples(Integer id)throws SQLException;
	
	void atualiza (Vendedor vendedor) throws SQLException;
	
}
