package br.com.teste.entites;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;



@Entity
@Table(name = "compra_entity")
@NamedQuery(name = "Compra.findAll", query = "SELECT v FROM Venda v")
@XmlRootElement
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda")	
	private Integer idVenda; 
	
	
	@OneToOne
	private Freguesia freguesia;

	@OneToOne
	private Vendedor vendedor;

	@OneToOne
	private Cliente cliente;
	
	private int parcelas;	
	
	private List<Calendar> dataVencimento;
	
	@OneToMany(targetEntity = Produto.class, fetch = FetchType.EAGER)
	private List<Produto> produtos;
	
	private DateTime dataDaCompra;

	@OneToMany(mappedBy = "venda", targetEntity = Pagamento.class, fetch = FetchType.EAGER)
	private List<Pagamento> pagamentos;
	
	private Double valorDaCompra;
	
	private Double valorRestante;

	@Deprecated
	public Venda() {
	}

	public Venda(Freguesia freguesia, Vendedor vendedor, Cliente cliente, Double valorDaCompra,
			DateTime dataDaCompra, int parcelas) {
		this.freguesia = freguesia;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.valorDaCompra = valorDaCompra;
		this.dataDaCompra = dataDaCompra;
		this.parcelas = parcelas;
	}
	
	

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public void setDataVencimento(List<Calendar> dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

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

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento.add(dataVencimento);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		this.produtos.add(produto);
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

	public void setPagamentos(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
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
