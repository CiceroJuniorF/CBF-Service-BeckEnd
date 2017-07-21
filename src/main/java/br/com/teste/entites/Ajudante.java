package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;

@Entity
@Table(name = "ajudante_entity")
@NamedQuery(name = "Ajudante.findAll", query = "SELECT a FROM Ajudante a")
@XmlRootElement
public class Ajudante extends Funcionario {
	private static Acesso nivelAcesso = Acesso.AJUDANTE;

	@Deprecated
	public Ajudante() {
	}

	public Ajudante(String nome, String email, String password, Endereco endereco) {
		super(nome, email, password, endereco, nivelAcesso);
	}

	@Deprecated
	public Ajudante(Integer idUsuario, String nome, String email, Double salarioBase, Double salarioComissao,
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
