package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@Entity
@Table(name = "pagamento_entity")
@NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
@XmlRootElement
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pagamento")
	private Integer idPagamento;

	private DateTime dataPagamento;
	private Double valorPago;

	@ManyToOne
	private Vendedor cobrador;

	@ManyToOne
	private VendaDetalhes venda;

	@Deprecated
	public Pagamento() {
	}

	public Pagamento(DateTime dataPagamento, Double valorPago, Vendedor cobrador, VendaDetalhes venda) {
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.cobrador = cobrador;
		this.venda = venda;
	}

	public Vendedor getCobrador() {
		return cobrador;
	}

	public void setCobrador(Vendedor cobrador) {
		this.cobrador = cobrador;
	}

	public DateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(DateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public VendaDetalhes getVenda() {
		return venda;
	}

	public void setVenda(VendaDetalhes venda) {
		this.venda = venda;
	}

}
