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
	
	@Column(name = "salario_base")
	private double salarioBase;
	
	@Column(name="salario_comissao")
	private double salarioComissao;
	
	@OneToOne
	private Usuario usuario;
	
	
	@Deprecated
	public Funcionario(){}
	
	public Funcionario(String nome, String email, String password, Endereco endereco, Acesso nivelAcesso){
		this.usuario = new Usuario(nome,email,password,endereco,nivelAcesso);
	}

	//GGAS
	public Integer getIdFuncionairo() {
		return idFuncionairo;
	}

	public void setIdFuncionairo(Integer idFuncionairo) {
		this.idFuncionairo = idFuncionairo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getSalarioComissao() {
		return salarioComissao;
	}

	public void setSalarioComissao(double salarioComissao) {
		this.salarioComissao = salarioComissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
