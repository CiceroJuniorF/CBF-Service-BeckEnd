package br.com.cbf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cbf.dao.GenericDAO;
import br.com.cbf.dao.VendedorDAO;
import br.com.cbf.dto.VendedorDTO;
import br.com.cbf.entites.Venda;
import br.com.cbf.entites.Vendedor;

public class VendedorDAOImpl implements VendedorDAO {

	EntityManager em;
	private GenericDAO<Vendedor> dao;

	public VendedorDAOImpl(EntityManager em) {
		this.em = em;
		this.dao = new GenericDAOImpl<Vendedor>(this.em, Vendedor.class);
	}

	@Override
	public List<VendedorDTO> listarSimples() {
		@SuppressWarnings("unchecked")
		List<VendedorDTO> listaDeVendedorsDTO = (List<VendedorDTO>) em.createQuery(
				"SELECT new br.com.teste.dto.VendedorDTO(idUsuario,nome,email,salarioBase,salarioComissao,nivelAcesso) FROM Vendedor")
				.getResultList();

		return listaDeVendedorsDTO;
	}

	@Override
	public VendedorDTO buscaSimples(Integer id) {

		VendedorDTO VendedorDTO = (VendedorDTO) em.createQuery(
				"SELECT new br.com.teste.dto.VendedorDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Vendedor a where a.idUsuario = :pId")
				.setParameter("pId", id).getSingleResult();

		return VendedorDTO;
	}

	@Override
	public void salvar(Vendedor entity) throws SQLException {
		em.persist(entity.getEndereco());
		this.dao.adiciona(entity);
	}

	@Override
	public void atualiza(Vendedor entity) throws SQLException {
		em.merge(entity.getEndereco());
		this.dao.atualiza(entity);
		
	}

	@Override
	public void realizarVenda(Venda venda) {
		
		
	}

}