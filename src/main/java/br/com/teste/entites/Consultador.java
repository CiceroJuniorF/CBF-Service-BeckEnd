package br.com.teste.entites;

import br.com.teste.enums.Acesso;

public class Consultador extends Usuario {
	
	
private static Acesso nivelAcesso = Acesso.CONSULTA;
	
	
	@Deprecated
	public Consultador() {}
	
	public Consultador(String nome, String email, String password, Endereco endereco){
		
		super(nome,email,password,endereco,nivelAcesso);
	}
}
