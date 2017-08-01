package br.com.cbf.dto;

import br.com.cbf.enums.Acesso;

public class ConsultadorDTO {
	private Integer idUsuario;
	private String nome; 
	private String email; 
	private Acesso nivelAcesso;
	


	@Deprecated
	public ConsultadorDTO() {}
	
	public ConsultadorDTO(Integer idUsuario,String nome, String email, Acesso acesso) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
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
	
}
