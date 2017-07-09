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
@Table(name="funcionario_entity")
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public abstract class Funcionario{
	//Atributos	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer idFuncionairo;
	
	@OneToOne
	private Freguesia freguesia;
	
	@Column(name = "salario")
	private double salario;
	
	
	@OneToOne
	private Usuario usuario;
	
	
	@Deprecated
	public Funcionario(){}
	
	public Funcionario(String nome, String email, String password, Endereco endereco, Acesso nivelAcesso){
		this.usuario = new Usuario(nome,email,password,endereco,nivelAcesso);
	}
	
	
	//GGAS
	public Freguesia getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(Freguesia freguesia) {
		this.freguesia = freguesia;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	
	
	
	
	
	
}
