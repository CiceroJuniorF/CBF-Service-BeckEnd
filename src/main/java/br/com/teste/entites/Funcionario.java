package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.teste.enums.Acesso;

@Entity
@Table(name="funcionario_entity")
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public abstract class Funcionario extends Usuario {
	//Atributos
	@OneToOne
	private Freguesia freguesia;
	
	@Deprecated
	public Funcionario(){}
	
	public Funcionario(String nome, String email, String password, Endereco endereco, Acesso nivelAcesso){
		super(nome,email,password,endereco,nivelAcesso);
	}
	
	
	public void nada() {
		
	}
	
	
	
	
	//GGAS
	
	
}
