package br.com.cbf.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name = "venda_entity")
@NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")
@XmlRootElement
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda")	
	private Integer idVenda; 
	
	
	@OneToOne(mappedBy = "venda", fetch =FetchType.EAGER, optional=false)
	private VendaDetalhes detalhes;
	
	@OneToOne(fetch =FetchType.EAGER, optional=false)
	@JoinColumn(name="freguesia")
	private Freguesia freguesia;

	@OneToOne(fetch =FetchType.EAGER, optional=false)
	@JoinColumn(name="vendedor")
	private Funcionario vendedor;

	@OneToOne(fetch =FetchType.EAGER, optional=false)
	@JoinColumn(name="cliente")
	private Cliente cliente;	
	
	
	@OneToMany(targetEntity = Produto.class, fetch = FetchType.EAGER)
	private List<Produto> produtos;

	
	
	@Deprecated
	public Venda() {
	}

	public Venda(Freguesia freguesia, Vendedor vendedor, Cliente cliente, VendaDetalhes detalhes) {
		this.freguesia = freguesia;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.detalhes = detalhes;
	}
	
	

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}


	public Freguesia getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(Freguesia freguesia) {
		this.freguesia = freguesia;
	}

	public Funcionario getVendedor() {
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
	

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		this.produtos.add(produto);
	}

	



	
	
	
	

}
