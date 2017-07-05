package br.com.teste.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="freguesia_entity")
@NamedQuery(name="Freguesia.findAll", query="SELECT f FROM Freguesia f")
public class Freguesia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFreguesia;
	
	private String nomeIndetifica;
	private Vendedor vendedor;
	private Ajudante ajudante;
	private List<Clientes> clientes;
	
	
	
	
	

}
