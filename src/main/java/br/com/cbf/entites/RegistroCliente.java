package br.com.cbf.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registro_cliente_entity")
@NamedQuery(name = "RegistroCliente.findAll", query = "SELECT r FROM RegistroCliente r")
public class RegistroCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_cliente")
	private Integer idRegistroCliente;
	

	
	@OneToOne
	@JoinColumn(name = "cadastrador", nullable = false)
	private Funcionario cadastrador;
	
}
