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

import br.com.cbf.enums.EncargosDespesas;

@Entity
@Table(name = "despesa_freguesia")
@NamedQuery(name = "DespesaFreguesia.findAll", query = "SELECT f FROM DespesaFreguesia f")
@XmlRootElement
public class DespesaFreguesia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_despesa_freguesia")
	private Integer idDespesaFreguesia;

	@ManyToOne
	@JoinColumn(name = "freguesia")
	private Freguesia fregusia;

	@Column(name = "valor_despesa")
	private Double valorDespesa;

	@Column(name = "tipo_despesa")
	private EncargosDespesas tipoDespesa;

	@Column(name = "data_de_despesa")
	@Temporal(TemporalType.DATE)
	private Calendar dataDaDespesa;
	
	
	@Deprecated
	public DespesaFreguesia() {}
	public DespesaFreguesia(Integer idDespesaFreguesia, Freguesia fregusia, Double valorDespesa,
			EncargosDespesas tipoDespesa, Calendar dataDaDespesa) {
	
		this.idDespesaFreguesia = idDespesaFreguesia;
		this.fregusia = fregusia;
		this.valorDespesa = valorDespesa;
		this.tipoDespesa = tipoDespesa;
		this.dataDaDespesa = dataDaDespesa;
	}

	public Integer getIdDespesaFreguesia() {
		return idDespesaFreguesia;
	}

	public Freguesia getFregusia() {
		return fregusia;
	}

	public Double getValorDespesa() {
		return valorDespesa;
	}

	public EncargosDespesas getTipoDespesa() {
		return tipoDespesa;
	}

	public Calendar getDataDaDespesa() {
		return dataDaDespesa;
	}

}
