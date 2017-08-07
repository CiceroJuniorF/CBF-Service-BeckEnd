package br.com.cbf.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cliente_entity")
@NamedQuery(name = "Cliente.findAll", query = "SELECT f FROM Cliente f")
@XmlRootElement
public class Cliente extends PessoaFisica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@ManyToOne
	@JoinColumn(name = "freguesia", nullable = false)
	private Freguesia freguesia;

	@OneToOne(mappedBy = "cliente")
	@JoinColumn(name = "registro", nullable = false)
	private DetalhesDoCliente registro;

	@Column(name = "sintuacao_cliente")
	private String sintuacao;

	@Deprecated
	public Cliente() {
	}

	public Cliente(Freguesia freguesia, String nome, String sobrenome, String apelido, String sexo,
			Calendar dataNascimento, Endereco endereco, Calendar dataAtualizacao, Calendar dataCadastro,
			String telefone, RG rg, String cpf, Profissao profissao, String paisNascimento, String cidade_nascimento,
			String estadoNascimento,String sintuacao) {
		super(nome, sobrenome, apelido, sexo, dataNascimento, endereco, dataAtualizacao, dataCadastro, telefone, rg,
				cpf, profissao, paisNascimento, cidade_nascimento, estadoNascimento);
		this.sintuacao = sintuacao;

		this.freguesia = freguesia;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Freguesia getFreguesia() {
		return freguesia;
	}
	

	public DetalhesDoCliente getRegistro() {
		return registro;
	}

	public void setRegistro(DetalhesDoCliente registro) {
		this.registro = registro;
	}

	public String getSintuacao() {
		return sintuacao;
	}

	public void setSintuacao(String sintuacao) {
		this.sintuacao = sintuacao;
	}

	public void setFreguesia(Freguesia freguesia) {
		this.freguesia = freguesia;
	}

}
