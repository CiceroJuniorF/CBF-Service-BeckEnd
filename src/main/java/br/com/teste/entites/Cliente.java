package br.com.teste.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cliente_entity")
@NamedQuery(name = "Cliente.findAll", query = "SELECT f FROM Cliente f")
@XmlRootElement
public class Cliente extends PessoaFisica {

	@Deprecated
	public Cliente() {
	}

	public Cliente(Integer idCliente, Freguesia freguesia, String nome, String sobrenome, String apelido,
			Endereco endereco, Calendar dataAtualizacao, Calendar dataCadastro, String telefone, RG rg, String cpf,
			Profissao profissao, String paisNascimento, String cidade_nascimento, String estadoNascimento) {
		
		super(nome, sobrenome, apelido, endereco, dataAtualizacao, dataCadastro, telefone, rg, cpf, profissao,
				paisNascimento, cidade_nascimento, estadoNascimento);
		this.idCliente = idCliente;
		this.freguesia = freguesia;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@ManyToOne
	@JoinColumn(name = "fk_freguesia", nullable = false)
	private Freguesia freguesia;

}
