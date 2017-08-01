package br.com.cbf.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@MappedSuperclass
@XmlRootElement
public class PessoaFisica {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sobrenome")
	private String sobrenome;

	@Column(name = "apelido")
	private String apelido;

	@OneToOne(fetch =FetchType.EAGER, optional=false)
	@JoinColumn(name="endereco")
	private Endereco endereco;

	@Column(name = "data_de_atualizacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAtualizacao;

	@Column(name = "data_de_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	@Column(name = "telefone")
	private String telefone;


	@Embedded
	private RG rg;

	@Column(name = "cpf", nullable = false, unique=true)
	private String cpf;

	@Embedded
	private Profissao profissao;

	@Column(name = "pais_nascimento")
	private String paisNascimento;

	@Column(name = "cidade_nascimento")
	private String cidade_nascimento;

	@Column(name = "estado_nascimento")
	private String estadoNascimento;

	// Construtores
	@Deprecated
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, String sobrenome, String apelido, Endereco endereco, Calendar dataAtualizacao,
			Calendar dataCadastro, String telefone, RG rg, String cpf, Profissao profissao, String paisNascimento,
			String cidade_nascimento, String estadoNascimento) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.endereco = endereco;
		this.dataAtualizacao = dataAtualizacao;
		this.dataCadastro = dataCadastro;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.profissao = profissao;
		this.paisNascimento = paisNascimento;
		this.cidade_nascimento = cidade_nascimento;
		this.estadoNascimento = estadoNascimento;
	}

	public PessoaFisica(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	// GGAS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Calendar getDataCadastro() {

		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public String getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public String getCidade_nascimento() {
		return cidade_nascimento;
	}

	public void setCidade_nascimento(String cidade_nascimento) {
		this.cidade_nascimento = cidade_nascimento;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

}
