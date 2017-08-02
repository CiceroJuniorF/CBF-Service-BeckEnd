package br.com.cbf.dto;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

@XmlRootElement
public class FuncionarioDTO {
	
	private Integer idUsuario;
	private String nome; 
	private String email; 
	private Double salarioBase;
	private Double salarioComissao;
	private Acesso nivelAcesso;
	


	@Deprecated
	public FuncionarioDTO() {}
	
	public FuncionarioDTO(Integer idUsuario,String nome, String email, Double salarioBase,
		Double salarioComissao,Acesso acesso) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.salarioBase = salarioBase;
		this.salarioComissao = salarioComissao;
		this.nivelAcesso = acesso;
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
	
	
	
	
	
	
}
