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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="registro_mensal_freguesia")
@NamedQuery(name="RegistroMensalFreguesia.findAll", query="SELECT f FROM RegistroMensalFreguesia f")
@XmlRootElement
public class RegistroMensalFreguesia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_registro_mensal_freguesia")
	private Integer idRegistroMensalFreguesia;
	
	@ManyToOne
	@JoinColumn(name="freguesia")
	private Freguesia fregusia;	
	
	@Column(name="alvo_total")
	private Double alvoTotal;
	
	@Column(name="alvo_atingido")
	private Double alvoAtingido;
	
	@Column(name = "data_de_fechamento_mensal")
	@Temporal(TemporalType.DATE)
	private Calendar dataDeFechamentoMensal;
	
	@Column(name="despesas_mensais")
	private Double totalDeDespesasFreguesia;
	
	
	
	@Deprecated
	public RegistroMensalFreguesia() {}
	
	public RegistroMensalFreguesia(Freguesia fregusia, Double alvoTotal, Double alvoAtingido,
			Calendar dataDeFechamentoMensal, Double totalDeDespesasFreguesia) {
		this.fregusia = fregusia;
		this.alvoTotal = alvoTotal;
		this.alvoAtingido = alvoAtingido;
		this.dataDeFechamentoMensal = dataDeFechamentoMensal;
		this.totalDeDespesasFreguesia = totalDeDespesasFreguesia;
	}

	public Double getTotalDeDespesasFreguesia() {
		return totalDeDespesasFreguesia;
	}

	public void setTotalDeDespesasFreguesia(Double totalDeDespesasFreguesia) {
		this.totalDeDespesasFreguesia = totalDeDespesasFreguesia;
	}

	public Integer getIdRegistroMensalFreguesia() {
		return idRegistroMensalFreguesia;
	}

	public void setIdRegistroMensalFreguesia(Integer idRegistroMensalFreguesia) {
		this.idRegistroMensalFreguesia = idRegistroMensalFreguesia;
	}

	public Freguesia getFregusia() {
		return fregusia;
	}

	public void setFregusia(Freguesia fregusia) {
		this.fregusia = fregusia;
	}



	public Calendar getDataDeFechamentoMensal() {
		return dataDeFechamentoMensal;
	}

	public void setDataDeFechamentoMensal(Calendar dataDeFechamentoMensal) {
		this.dataDeFechamentoMensal = dataDeFechamentoMensal;
	}

	public Double getAlvoTotal() {
		return alvoTotal;
	}

	public void setAlvoTotal(Double alvoTotal) {
		this.alvoTotal = alvoTotal;
	}

	public Double getAlvoAtingido() {
		return alvoAtingido;
	}

	public void setAlvoAtingido(Double alvoAtingido) {
		this.alvoAtingido = alvoAtingido;
	}
	
	
	
	
	
}
