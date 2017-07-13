package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

@MappedSuperclass
@XmlRootElement
public class PessoaFisica {
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "apelido")
	private String apelido;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name = "data_de_atualizacao")
	private DateTime dataAtualizacao;
	
	@Column(name = "data_de_cadastro")
	private DateTime dataCadastro;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "rg")
	@Embedded
	private RG rg;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Embedded
	private Profissao profissao;

	@Column(name = "pais_nascimento")
	private String paisNascimento;

	@Column(name = "cidade_nascimento")
	private String cidade_nascimento;

	@Column(name = "estado_nascimento")
	private String estadoNascimento;

	
	//Construtores
	@Deprecated
	public PessoaFisica() {}

	public PessoaFisica(String nome, String sobrenome, String apelido, Endereco endereco, DateTime dataAtualizacao,
			DateTime dataCadastro, String telefone, RG rg, String cpf, Profissao profissao, String paisNascimento,
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
	
	public PessoaFisica(String nome,Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	
	
	//GGAS
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

	public DateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(DateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public DateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
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
