package br.com.teste.dto;

import br.com.teste.enums.Acesso;

public class MasterDTO {
	private Integer idUsuario;
	private String nome;
	private String email;
	private Acesso nivelAcesso;
	
	
	public MasterDTO(Integer id, String nome, String email,Acesso nivelAcesso) {
		this.idUsuario=id;
		this.nome = nome;
		this.email = email;		
		this.nivelAcesso = nivelAcesso;
	}
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Acesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}


}
