package br.com.teste.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.dao.GenericDAO;
import br.com.teste.entites.Pagamento;
import br.com.teste.entites.Venda;

public class VendaDAOImpl implements br.com.teste.dao.VendaDAO {

	EntityManager em;
	private GenericDAO<Venda> dao;

	public VendaDAOImpl(EntityManager em) {
		this.em = em;
		this.dao = new GenericDAOImpl<Venda>(this.em, Venda.class);
	}

	@Override
	public void novaVenda(Venda venda) throws SQLException {
		em.merge(venda.getFreguesia());
		em.merge(venda.getVendedor());
		em.merge(venda.getCliente());
		dao.adiciona(venda);
	}

	@Override
	public void atualizarVenda(Venda venda) throws SQLException {
		em.merge(venda.getFreguesia());
		em.merge(venda.getVendedor());
		em.merge(venda.getCliente());
		dao.atualiza(venda);
	}

	@Override
	public void novoPagamento(Pagamento pagamento) throws SQLException {
		em.persist(pagamento);
		em.merge(pagamento.getCompra());
		em.merge(pagamento.getCobrador());

	}

	@Override
	public List<Venda> listarTodasVendas() throws SQLException {

		return null;
	}

	@Override
	public List<Venda> vendasACobrar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> vedasVencidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> vendasQuitadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda vendaEspecifica(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
