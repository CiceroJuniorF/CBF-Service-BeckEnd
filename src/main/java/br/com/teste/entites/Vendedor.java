package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.teste.enums.Acesso;
@Entity
@Table(name="vendedor_entity")
@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")
public class Vendedor extends Funcionario {	
	private static Acesso nivelAcesso = Acesso.VENDEDOR;
	
	
	@Deprecated
	public Vendedor() {}
	
	public Vendedor(String nome, String email, String password, Endereco endereco){
		
		super(nome,email,password,endereco,nivelAcesso);
	}
	
}
