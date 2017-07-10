package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.teste.enums.Acesso;


@Entity
@Table(name = "consultador_entity")
@NamedQuery(name = "Consultador.findAll", query = "SELECT c FROM Consultador c")

public class Consultador {
	
	private static Acesso nivelAcesso = Acesso.CONSULTA;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consultador")
	private Integer idConsultador;
	
	@OneToOne
	private Usuario usuario;
	

	@Deprecated
	public Consultador() {
	}

	public Consultador(String nome, String email, String password, Endereco endereco) {
		this.usuario = new Usuario(nome, email, password, endereco, nivelAcesso);
	}
}
