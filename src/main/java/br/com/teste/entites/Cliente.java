package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cliente_entity")
@NamedQuery(name="Cliente.findAll", query="SELECT f FROM Cliente f")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@ManyToOne
	@JoinColumn(name="fk_freguesia")
	private Freguesia freguesia;
	
}
