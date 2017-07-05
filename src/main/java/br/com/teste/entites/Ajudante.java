package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ajudante_entity")
@NamedQuery(name="Ajudante.findAll", query="SELECT f FROM Ajudante f")
public class Ajudante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anjudante")
	private Integer idAjudante;
	
	@OneToOne
	private Freguesia freguesia;
}
