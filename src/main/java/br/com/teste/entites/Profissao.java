package br.com.teste.entites;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class Profissao {

	private String nomeProfissao;
	
	
	@Deprecated
	public Profissao() {}
	
	
	
	public Profissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
		
	}



	public String getNomeProfissao() {
		return nomeProfissao;
	}
	public void setNomeProfissao(String nomeProfissao) {
		this.nomeProfissao = nomeProfissao;
	}

	
	
}
