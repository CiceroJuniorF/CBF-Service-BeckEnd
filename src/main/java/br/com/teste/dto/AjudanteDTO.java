package br.com.teste.dto;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.entites.Endereco;
import br.com.teste.enums.Acesso;

@XmlRootElement
public class AjudanteDTO {
	
	private Integer idUsuario;
	private String nome; 
	private String email; 
	private String password; 
	private Endereco endereco;
	private Double salarioBase;
	private Double salarioComissao;
	private static Acesso nivelAcesso = Acesso.AJUDANTE;
	


	@Deprecated
	public AjudanteDTO() {}
	
	public AjudanteDTO(Integer id,String nome, String email, String password, Endereco endereco, Double salarioBase,
			Double salarioComissao) {
		this.idUsuario = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.endereco = endereco;
		this.salarioBase = salarioBase;
		this.salarioComissao = salarioComissao;
	}
	
	
	
	public Integer getId() {
		return idUsuario;
	}

	public void setId(Integer id) {
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
	
	
	
	
	
	
}
