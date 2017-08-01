package br.com.cbf.dto;

import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Freguesia;
import br.com.cbf.entites.Pagamento;
import br.com.cbf.entites.Produto;
import br.com.cbf.entites.Vendedor;

public class VendaDTO {	
	
	private Freguesia freguesia;

	private Vendedor vendedor;

	private Cliente cliente;
	
	private int parcelas;	
	
	private List<Calendar> dataVencimento;
	
	private List<Produto> produtos;
	
	private DateTime dataDaCompra;

	private List<Pagamento> pagamentos;
	
	private Double valorDaCompra;
	
	private Double valorRestante;
	
	

	public Freguesia getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(Freguesia freguesia) {
		this.freguesia = freguesia;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public List<Calendar> getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(List<Calendar> dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public DateTime getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(DateTime dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Double getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(Double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	public Double getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(Double valorRestante) {
		this.valorRestante = valorRestante;
	}
	
	
	
	
}
