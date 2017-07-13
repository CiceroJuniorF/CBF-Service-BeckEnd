package br.com.teste.entites;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;


@Embeddable
@XmlRootElement
public class RG {

	private String orgaoEmissor;
	private String numeroRg;
	private String estadoEmissor;
	
	
	public RG() {}
	
	public RG(String orgaoEmissor, String numeroRg, String estadoEmissor) {		
		this.orgaoEmissor = orgaoEmissor;
		this.numeroRg = numeroRg;
		this.estadoEmissor = estadoEmissor;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getNumeroRg() {
		return numeroRg;
	}

	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}

	public String getEstadoEmissor() {
		return estadoEmissor;
	}

	public void setEstadoEmissor(String estadoEmissor) {
		this.estadoEmissor = estadoEmissor;
	}
	
	
	
	
	
	
	
	
}
