package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.teste.enums.Acesso;

@Entity
@Table(name="Master")
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
public class Master extends Usuario {
	private static Acesso nivelAcesso = Acesso.MASTER;
	
	@Deprecated
	public Master() {}
	
	public Master(String nome, String email, String password, Endereco endereco){
		
		super(nome,email,password,endereco,nivelAcesso);
	}

}
