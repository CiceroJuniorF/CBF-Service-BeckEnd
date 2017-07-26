package br.com.teste.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;


@Embeddable
@XmlRootElement
public class RG {	

	@Column(name="orgao_emissor", nullable=false)
	private String orgaoEmissor;
	@Column(name="numero_rg", unique=true, nullable=false)
	private String numeroRg;
	@Column(name="estado_emissor", nullable=false)
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
