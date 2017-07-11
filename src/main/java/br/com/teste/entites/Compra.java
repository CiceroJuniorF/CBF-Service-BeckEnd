package br.com.teste.entites;

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
@NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
@XmlRootElement
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")	
	private Integer idCompra; 
	
	
	@OneToOne
	private Freguesia freguesia;

	@OneToOne
	private Vendedor vendedor;

	@OneToOne
	private Cliente cliente;

	private Double valorDaCompra;
	private DateTime dataDaCompra;

	@OneToMany(mappedBy = "compra", targetEntity = Pagamento.class, fetch = FetchType.LAZY)
	private List<Pagamento> pagamentos;

	private Double valorRestante;

	@Deprecated
	public Compra() {
	}

	public Compra(Freguesia freguesia, Vendedor vendedor, Cliente cliente, Double valorDaCompra,
			DateTime dataDaCompra) {
		this.freguesia = freguesia;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.valorDaCompra = valorDaCompra;
		this.dataDaCompra = dataDaCompra;
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

	public Double getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(Double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
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

	public void novoPagamentos(Pagamento pagamento) {
		this.getPagamentos().add(pagamento);
	}
	

	public Double getValorRestante() {
		return this.valorRestante;
	}

	public void setValorRestante(Double valorRestante) {
		this.valorRestante = valorRestante;
	}
	
	

}
