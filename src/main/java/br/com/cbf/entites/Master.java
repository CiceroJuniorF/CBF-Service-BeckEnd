package br.com.cbf.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

@Entity
@Table(name="master")
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
@XmlRootElement
public class Master extends Usuario{
	private static Acesso nivelAcesso = Acesso.MASTER;
	
	@Deprecated
	public Master() {}
	
	public Master(String nome, String email, String password, Endereco endereco) {
		super(nome, email, password, endereco, nivelAcesso);
	}

	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}
	
	

	
	
	
	

}
