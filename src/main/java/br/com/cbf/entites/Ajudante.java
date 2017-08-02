package br.com.cbf.entites;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

@Entity
@XmlRootElement
public class Ajudante extends Funcionario {
	private static Acesso nivelAcesso = Acesso.AJUDANTE;

	@Deprecated
	public Ajudante() {
	}

	public Ajudante(String nome, String email, String password, Endereco endereco) {
		super(nome, email, password, endereco, nivelAcesso);
	}


	public Acesso getNivelAcesso() {
		return nivelAcesso;
	}

}
