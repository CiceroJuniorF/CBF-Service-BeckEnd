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
@Table(name="vendedor_entity")
@NamedQuery(name="Vendedor.findAll", query="SELECT f FROM Vendedor f")
public class Vendedor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vendedor")
	private Integer idVendedor;
	
	@OneToOne
	private Freguesia freguesia;
}
