package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.dto.VendedorDTO;
import br.com.cbf.entites.Venda;
import br.com.cbf.entites.Vendedor;

public interface VendedorDAO{

	void salvar(Vendedor vendedor)throws SQLException;
	
	List<VendedorDTO> listarSimples()throws SQLException;

	VendedorDTO buscaSimples(Integer id)throws SQLException;
	
	void atualiza (Vendedor vendedor) throws SQLException;
	
	void realizarVenda(Venda venda);
}
