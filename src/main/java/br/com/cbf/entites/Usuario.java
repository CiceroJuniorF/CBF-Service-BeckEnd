package br.com.cbf.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

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
	
	@Column(name = "data_de_atualizacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAtualizacao;
	
	@Column(name = "data_de_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	
	
	

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

}
