package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;

@MappedSuperclass
@XmlRootElement
public class Usuario extends PessoaFisica {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(nullable=false) 
	private String email;
	@Column(nullable=false) 
	private String password;
	@Column(name = "nivel_acesso",nullable=false)
	private Acesso nivelAcesso;
	
	

	@Deprecated
	public Usuario() {
	}
	
	public Usuario(String nome, String email, String password, Endereco endereco,Acesso nivelAcesso){		
		super(nome,endereco);
		this.email = email;
		this.nivelAcesso = nivelAcesso;
		this.password = password;
		this.nivelAcesso = nivelAcesso;
	}
	

	// GGAS

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Acesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
