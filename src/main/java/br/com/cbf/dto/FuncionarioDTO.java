package br.com.cbf.dto;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.entites.Endereco;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.Profissao;
import br.com.cbf.entites.RG;
import br.com.cbf.enums.Acesso;

@XmlRootElement
public class FuncionarioDTO implements GenericDTO<Funcionario> {
	
	private Integer idUsuario;
	
	private String nome; 
	
	private String email; 
	
	private Double salarioBase;
	
	private Double salarioComissao;
	
	private Acesso nivelAcesso;

	private String sobrenome;
	
	private String apelido;
	
	private String sexo;

	private Calendar dataNascimento;

	private Endereco endereco;

	private String telefone;
	
	private RG rg;

	private String cpf;

	private Profissao profissao;

	private String paisNascimento;

	private String cidade_nascimento;

	private String estadoNascimento;
	
	


	
	public FuncionarioDTO(Funcionario funcionario){
		converteDTO(funcionario);
	}
	
	
	//Construtor GERAL
	public FuncionarioDTO(Integer idUsuario, String nome, String email, Double salarioBase, Double salarioComissao,
			Acesso nivelAcesso, String sobrenome, String apelido, String sexo, Calendar dataNascimento,
			Endereco endereco, String telefone, RG rg, String cpf, Profissao profissao, String paisNascimento,
			String cidade_nascimento, String estadoNascimento) {
		
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.salarioComissao = salarioComissao;
		this.nivelAcesso = nivelAcesso;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.profissao = profissao;
		this.paisNascimento = paisNascimento;
		this.cidade_nascimento = cidade_nascimento;
		this.estadoNascimento = estadoNascimento;
	}



	//Construtor para um relatório basico
	public FuncionarioDTO(Integer idUsuario,String nome, String email, Double salarioBase,
		Double salarioComissao,Acesso acesso) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.salarioComissao = salarioComissao;
		this.nivelAcesso = acesso;
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



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Calendar getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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



	public void setNivelAcesso(Acesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer id) {
		this.idUsuario = id;
	}

	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Double getSalarioComissao() {
		return salarioComissao;
	}
	public void setSalarioComissao(Double salarioComissao) {
		this.salarioComissao = salarioComissao;
	}

	@Override
	public void converteDTO(Funcionario funcionario) {
		this.idUsuario = funcionario.getIdUsuario();
		this.nome = funcionario.getNome();
		this.email = funcionario.getEmail();
		this.salarioBase = funcionario.getSalarioBase();
		this.salarioComissao = funcionario.getSalarioComissao();
		this.nivelAcesso = funcionario.getNivelAcesso();
		this.sobrenome = funcionario.getSobrenome();
		this.apelido = funcionario.getApelido();
		this.sexo = funcionario.getSexo();
		this.dataNascimento = funcionario.getDataNascimento();
		this.endereco = funcionario.getEndereco();
		this.telefone = funcionario.getTelefone();
		this.rg = funcionario.getRg();
		this.cpf = funcionario.getCpf();
		this.profissao = funcionario.getProfissao();
		this.paisNascimento = funcionario.getPaisNascimento();
		this.cidade_nascimento = funcionario.getCidade_nascimento();
		this.estadoNascimento = funcionario.getEstadoNascimento();
		
	}
	
	
	
	
	
	
}
