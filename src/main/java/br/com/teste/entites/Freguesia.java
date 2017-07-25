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


@Entity
@Table(name="freguesia_entity")
@NamedQuery(name="Freguesia.findAll", query="SELECT f FROM Freguesia f")
@XmlRootElement
public class Freguesia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_freguesia")
	private Integer idFreguesia;
	
	@Column(name="nome_identifica",nullable=false,unique=true)	
	private String nomeIndetifica;
	
	
	@OneToOne(fetch = FetchType.EAGER, optional=false)
	@Column(unique=true)
	private Vendedor vendedor;
	
	@OneToMany(targetEntity = Ajudante.class ,fetch = FetchType.EAGER)
	@Column(unique=true)
	private List<Ajudante> ajudante;
	
	@OneToMany(mappedBy = "freguesia", targetEntity = Cliente.class)
	@Column(unique=true)
	private List<Cliente> clientes;
	
	@Column(name="alvo_mensal")
	private Double alvoMensal;
	

	
	public Double getAlvoMensal() {
		return alvoMensal;
	}
	public void setAlvoMensal(Double alvoMensal) {
		this.alvoMensal = alvoMensal;
	}
	public void setIdFreguesia(Integer idFreguesia) {
		this.idFreguesia = idFreguesia;
	}
	public int getIdFreguesia() {
		return idFreguesia;
	}	
	public String getNomeIndetifica() {
		return nomeIndetifica;
	}
	public void setNomeIndetifica(String nomeIndetifica) {
		this.nomeIndetifica = nomeIndetifica;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public List<Ajudante> getAjudante() {
		return ajudante;
	}
	public void setAjudante(List<Ajudante> ajudante) {
		this.ajudante = ajudante;
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
