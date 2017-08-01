package br.com.cbf.entites;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

import br.com.cbf.enums.StatusVenda;


@Entity
@Table(name = "venda_detalhes_entity")
@NamedQuery(name = "VendaDetalhes.findAll", query = "SELECT v FROM Venda v")
@XmlRootElement
public class VendaDetalhes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venda_detalhes")	
	private Integer idVendaDetalhes; 
	
	@OneToOne
	private Venda venda;	
	
	private int parcelas;
	
	private DateTime dataDaCompra;
	
	private List<Calendar> dataVencimento;
	
	@OneToMany(targetEntity = Pagamento.class, fetch = FetchType.EAGER)
	private List<Pagamento> pagamentos;
	
	private Double valorDaCompra;
	
	private Double valorRestante;
	
	private StatusVenda status;
	
	
	
	@Deprecated
	public VendaDetalhes() {}

	public VendaDetalhes(int parcelas, DateTime dataDaCompra, List<Calendar> dataVencimento, List<Pagamento> pagamentos,
			Double valorDaCompra, Double valorRestante, StatusVenda status) {
		this.parcelas = parcelas;
		this.dataDaCompra = dataDaCompra;
		this.dataVencimento = dataVencimento;
		this.pagamentos = pagamentos;
		this.valorDaCompra = valorDaCompra;
		this.valorRestante = valorRestante;
		this.status = status;
	}

	public Integer getIdVendaDetalhes() {
		return idVendaDetalhes;
	}

	public void setIdVendaDetalhes(Integer idVendaDetalhes) {
		this.idVendaDetalhes = idVendaDetalhes;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public DateTime getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(DateTime dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

	public List<Calendar> getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(List<Calendar> dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Double getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(Double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	public Double getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(Double valorRestante) {
		this.valorRestante = valorRestante;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}
	
	
	
	
	
}
