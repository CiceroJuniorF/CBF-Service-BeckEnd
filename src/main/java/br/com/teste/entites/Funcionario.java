package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.teste.enums.Acesso;

@MappedSuperclass
@XmlRootElement
public class Funcionario extends Usuario {

	@Column(name = "salario_base")
	private Double salarioBase;

	@Column(name = "salario_comissao")
	private Double salarioComissao;

	@Deprecated 
	public Funcionario() {
	}

	public Funcionario(String nome, String email, String password, Endereco endereco,Acesso nivelAcesso) {
		super(nome, email, password, endereco, nivelAcesso);
		
	}


	// GGAS

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Double getSalarioComissao() {
		return salarioComissao;
	}

	public void setSalarioComissao(Double salarioComissao) {
		this.salarioComissao = salarioComissao;
	}

}
