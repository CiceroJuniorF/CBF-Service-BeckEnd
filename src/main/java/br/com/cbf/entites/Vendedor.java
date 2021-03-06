package br.com.cbf.entites;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

@Entity
@XmlRootElement
public class Vendedor extends Funcionario{	
	private static Acesso nivelAcesso = Acesso.VENDEDOR;
	
	@Deprecated
	public Vendedor() {}
	
	public Vendedor(String nome, String email, String password, Endereco endereco){		
		super(nome,email,password,endereco,nivelAcesso);
	}
	
	@Deprecated
	public Vendedor(Integer idUsuario, String nome, String email, Double salarioBase, Double salarioComissao,
			Acesso nivelAcesso) {
		this.setIdUsuario(idUsuario);
		this.setNome(nome);
		this.setEmail(email);
		this.setSalarioBase(salarioBase);
		this.getSalarioComissao();
		this.setNivelAcesso(nivelAcesso);
	}

	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}
	
	
	
}
