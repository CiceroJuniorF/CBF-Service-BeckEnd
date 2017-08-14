package br.com.cbf.entites;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "detalhes_cliente_entity")
@NamedQuery(name = "DetalhesDoCliente.findAll", query = "SELECT r FROM DetalhesDoCliente r")
@XmlRootElement
public class DetalhesDoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_cliente")
	private Integer idRegistroCliente;
	
	@Column(name = "data_de_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	

	@OneToOne
	@JoinColumn(name = "cadastrador", nullable = false)
	private Funcionario cadastrador;
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@Column(name="registro_alteracao")
	private List<RegistroAlteracoesCliente> alteracao;
	

	@Deprecated
	public DetalhesDoCliente() {}
	
	public DetalhesDoCliente(Integer idRegistroCliente, Calendar dataCadastro, Cliente cliente, Funcionario cadastrador,
			Calendar dataDeCadastro) {
		this.idRegistroCliente = idRegistroCliente;
		this.dataCadastro = dataCadastro;
		this.cadastrador = cadastrador;
		this.dataCadastro = dataDeCadastro;
	}

	public Integer getIdRegistroCliente() {
		return idRegistroCliente;
	}

	public void setIdRegistroCliente(Integer idRegistroCliente) {
		this.idRegistroCliente = idRegistroCliente;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Funcionario getCadastrador() {
		return cadastrador;
	}

	public void setCadastrador(Funcionario cadastrador) {
		this.cadastrador = cadastrador;
	}

	public List<RegistroAlteracoesCliente> getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(List<RegistroAlteracoesCliente> alteracao) {
		this.alteracao = alteracao;
	}
	
	
	
	
	
	
	
	
}
