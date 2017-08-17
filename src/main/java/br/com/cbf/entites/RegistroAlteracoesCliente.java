package br.com.cbf.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "alteracao_cliente_entity")
@NamedQuery(name = "AlteracaoDoCliente.findAll", query = "SELECT r FROM RegistroAlteracoesCliente r")
@XmlRootElement
public class RegistroAlteracoesCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alteracao_cliente")
	private Integer idAlteracaoCliente;
	
	@Column(name = "data_de_atualizacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAtualizacao;
	
	@Column(name = "descricao")
	private String descricaoDoMotivoDeAlteracao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private DetalhesDoCliente detalhesCliente;
	
	@Deprecated
	public RegistroAlteracoesCliente() {}
	
	public RegistroAlteracoesCliente(Integer idAlteracaoCliente, Calendar dataAtualizacao,
			String descricaoDoMotivoDeAlteracao, DetalhesDoCliente detalhesCliente) {
		this.idAlteracaoCliente = idAlteracaoCliente;
		this.dataAtualizacao = dataAtualizacao;
		this.descricaoDoMotivoDeAlteracao = descricaoDoMotivoDeAlteracao;
		this.detalhesCliente = detalhesCliente;
	}







	public Integer getIdAlteracaoCliente() {
		return idAlteracaoCliente;
	}

	public void setIdAlteracaoCliente(Integer idAlteracaoCliente) {
		this.idAlteracaoCliente = idAlteracaoCliente;
	}

	public String getDescricaoDoMotivoDeAlteracao() {
		return descricaoDoMotivoDeAlteracao;
	}

	public void setDescricaoDoMotivoDeAlteracao(String descricaoDoMotivoDeAlteracao) {
		this.descricaoDoMotivoDeAlteracao = descricaoDoMotivoDeAlteracao;
	}


	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public DetalhesDoCliente getDetalhesCliente() {
		return detalhesCliente;
	}

	public void setDetalhesCliente(DetalhesDoCliente detalhesCliente) {
		this.detalhesCliente = detalhesCliente;
	}
	
	
	
	
	
	
}
