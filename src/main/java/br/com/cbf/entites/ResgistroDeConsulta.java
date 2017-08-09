package br.com.cbf.entites;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "registro_consulta")
@NamedQuery(name = "ResgistroDeConsulta.findAll", query = "SELECT r FROM ResgistroDeConsulta r")
@XmlRootElement
public class ResgistroDeConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_consulta")
	private Integer idRegistroConsulta;	
	
	private String cpf;
	
	private Calendar dataNascimento;	
	
	private Usuario consultador;
	
	private Calendar dataDeConsulta;

	
	@Deprecated
	public ResgistroDeConsulta() {}
	
	public ResgistroDeConsulta(String cpf, Calendar dataNascimento, Usuario consultador,
			Calendar dataDeConsulta) {
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.consultador = consultador;
		this.dataDeConsulta = dataDeConsulta;
	}

	public Integer getIdRegistroConsulta() {
		return idRegistroConsulta;
	}
	
	public void setIdRegistroConsulta(Integer idRegistroConsulta) {
		this.idRegistroConsulta = idRegistroConsulta;
	}

	public String getCpf() {
		return cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public Calendar getDataDeConsulta() {
		return dataDeConsulta;
	}

	public Usuario getConsultador() {
		return consultador;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
