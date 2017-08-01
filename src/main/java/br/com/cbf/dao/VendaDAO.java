package br.com.cbf.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cbf.entites.Pagamento;
import br.com.cbf.entites.Venda;

public interface VendaDAO {
	
	void novaVenda(Venda veda) throws SQLException ;
	
	void atualizarVenda(Venda venda) throws SQLException;
	
	void novoPagamento(Pagamento pagamento) throws SQLException;
	
	List<Venda> listarTodasVendas() throws SQLException;
	
	List<Venda> vendasACobrar() throws SQLException;
	
	List<Venda> vedasVencidas() throws SQLException;
	
	List<Venda> vendasQuitadas() throws SQLException;
	
	Venda vendaEspecifica(Integer id) throws SQLException;
	
}
