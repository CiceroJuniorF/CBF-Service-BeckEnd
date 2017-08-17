package br.com.cbf.entites;

import java.io.Serializable;
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

@SuppressWarnings("serial")
@Entity
@Table(name = "cliente_entity")
@NamedQuery(name = "Cliente.findAll", query = "SELECT f FROM Cliente f")
@XmlRootElement
public class Cliente extends PessoaFisica  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@ManyToOne
	@JoinColumn(name = "freguesia")
	private Freguesia freguesia;

	@OneToOne
	@JoinColumn(name = "registro", nullable = false)
	private DetalhesDoCliente registro;

	@Column(name = "sintuacao_cliente", nullable = false)
	private String sintuacao;

	@Deprecated
	public Cliente() {
	}
	
	//Construtor para persistencia direta
	public Cliente(Freguesia freguesia, String nome, String sobrenome, String apelido, String sexo,
			Calendar dataNascimento, Endereco endereco, Calendar dataAtualizacao, Calendar dataCadastro,
			String telefone, RG rg, String cpf, Profissao profissao, String paisNascimento, String cidade_nascimento,
			String estadoNascimento,String sintuacao) {
		super(nome, sobrenome, apelido, sexo, dataNascimento, endereco, dataAtualizacao, dataCadastro, telefone, rg,
				cpf, profissao, paisNascimento, cidade_nascimento, estadoNascimento);
		this.sintuacao = sintuacao;

		this.freguesia = freguesia;
	}
	
	//Construtor para quando for feita uma busca por cpf
	public Cliente(String nome, String sobrenome, String apelido, String sexo,Calendar dataNascimento,
	String telefone, RG rg, String cpf, String cidade_nascimento,String estadoNascimento, String sintuacao, Endereco endereco) {
		super(nome, sobrenome, apelido, sexo, dataNascimento, endereco, null, null, telefone, rg,
				cpf, null, null, cidade_nascimento, estadoNascimento);
		this.sintuacao = sintuacao;
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

	public String getSintuacao() {
		return sintuacao;
	}

	public void setSintuacao(String sintuacao) {
		this.sintuacao = sintuacao;
	}

	public void setFreguesia(Freguesia freguesia) {
		this.freguesia = freguesia;
	}

	public DetalhesDoCliente getRegistro() {
		return registro;
	}

	public void setRegistro(DetalhesDoCliente registro) {
		this.registro = registro;
	}
	
	
	

}
