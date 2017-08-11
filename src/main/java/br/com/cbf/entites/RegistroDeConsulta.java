package br.com.cbf.entites;

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
@Table(name = "registro_consulta")
@NamedQuery(name = "ResgistroDeConsulta.findAll", query = "SELECT r FROM RegistroDeConsulta r")
@XmlRootElement
public class RegistroDeConsulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_consulta")
	private Integer idRegistroConsulta;	
	
	private String cpf;
	
	@Column(name = "data_nascimento_cliente")
	private Calendar dataNascimento;	
	
	@ManyToOne
	@JoinColumn(name="consultador", nullable = false)
	private Funcionario consultador;
	
	@Column(name = "data_de_consulta")
	private Calendar dataDeConsulta;

	
	@Deprecated
	public RegistroDeConsulta() {}
	
	public RegistroDeConsulta(String cpf, Calendar dataNascimento, Funcionario consultador,
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataDeConsulta(Calendar dataDeConsulta) {
		this.dataDeConsulta = dataDeConsulta;
	}

	public Funcionario getConsultador() {
		return consultador;
	}

	public void setConsultador(Funcionario consultador) {
		this.consultador = consultador;
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
