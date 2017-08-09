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
	
	private String nomeConsultador;
	
	private Calendar dataDeConsulta;

	
	@Deprecated
	public ResgistroDeConsulta() {}
	
	public ResgistroDeConsulta(String cpf, Calendar dataNascimento, String nomeConsultador,
			Calendar dataDeConsulta) {
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nomeConsultador = nomeConsultador;
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

	public String getNomeConsultador() {
		return nomeConsultador;
	}

	public Calendar getDataDeConsulta() {
		return dataDeConsulta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
