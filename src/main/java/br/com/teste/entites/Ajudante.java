package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;

@Entity
@Table(name = "ajudante_entity")
@NamedQueries({
	@NamedQuery(name = "Ajudante.findAll", query = "SELECT a FROM Ajudante a"), 	
	@NamedQuery(name ="Ajudante.dtosfa", query = "SELECT new br.com.teste.dto.AjudanteDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Ajudante a")
})
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
