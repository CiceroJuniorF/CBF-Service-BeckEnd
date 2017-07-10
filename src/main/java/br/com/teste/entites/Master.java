package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.teste.enums.Acesso;

@Entity
@Table(name="Master")
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
public class Master{
	private static Acesso nivelAcesso = Acesso.MASTER;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_master")	
	private Integer idMaster; 
	
	@OneToOne
	private Usuario usuario;
	
	@Deprecated
	public Master() {}
	
	public Master(Integer id, String nome, String email, String password, Endereco endereco){
		this.idMaster = id;
		this.usuario = new Usuario(nome,email,password,endereco,nivelAcesso);
	}

	public Integer getIdMaster() {
		return idMaster;
	}

	public void setIdMaster(Integer idMaster) {
		this.idMaster = idMaster;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
