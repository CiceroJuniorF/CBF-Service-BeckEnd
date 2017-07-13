package br.com.teste.entites;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class Profissao {

	private String nomeProfissao;
	private Double salario;
	
	@Deprecated
	public Profissao() {}
	
	
	
	public Profissao(String nomeProfissao, Double salario) {
		this.nomeProfissao = nomeProfissao;
		this.salario = salario;
	}



	public String getNomeProfissao() {
		return nomeProfissao;
	}
	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
