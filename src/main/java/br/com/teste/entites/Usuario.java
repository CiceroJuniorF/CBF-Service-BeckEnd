package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;


@MappedSuperclass
@XmlRootElement	
public class Usuario {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer idFuncionario;
	private String nome;
	private String email;
	private String password;
	
	@ManyToOne
	private Endereco endereco;
	private Acesso nivelAcesso;
	
	
	
	@Deprecated
	public Usuario() {}
	
	public Usuario(String nome, String email, String password, Endereco endereco, Acesso nivelAcesso) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.endereco = endereco;
		this.nivelAcesso = nivelAcesso;
	}
	public Usuario(String nome, String email, String password, Acesso nivelAcesso) {
		this.nome = nome;
		this.email = email;
		this.password = password;		
		this.nivelAcesso = nivelAcesso;
	}
	
	
	//GGAS
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(Acesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	
	
	
	
	
	
}
