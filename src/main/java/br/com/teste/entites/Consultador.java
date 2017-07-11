package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;


@Entity
@Table(name = "consultador_entity")
@NamedQuery(name = "Consultador.findAll", query = "SELECT c FROM Consultador c")
@XmlRootElement
public class Consultador extends Usuario{
	
	private static Acesso nivelAcesso = Acesso.CONSULTA;


	@Deprecated
	public Consultador() {
	}

	public Consultador(String nome, String email, String password, Endereco endereco) {
		super(nome, email, password, endereco, nivelAcesso);
	}
}
