package br.com.cbf.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.enums.Acesso;

@Entity
@Table(name = "funcionario_entity")
@NamedQueries({
	@NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"), 	
	@NamedQuery(name ="Funcionario.findDTO", query = "SELECT new br.com.cbf.dto.FuncionarioDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Funcionario a"),
	@NamedQuery(name ="Funcionario.findDTOID", query = "SELECT new br.com.cbf.dto.FuncionarioDTO(a.idUsuario,a.nome,a.email,a.salarioBase,a.salarioComissao,a.nivelAcesso) FROM Funcionario a where a.idUsuario = :pId")
})
@XmlRootElement
public class Funcionario extends Usuario {

	@Column(name = "salario_base")
	private Double salarioBase;

	@Column(name = "salario_comissao")
	private Double salarioComissao;
	

	@Deprecated 
	public Funcionario() {
	}

	public Funcionario(String nome, String email, String password, Endereco endereco,Acesso nivelAcesso) {
		super(nome, email, password, endereco, nivelAcesso);		
	}
	

	// GGAS
	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Double getSalarioComissao() {
		return salarioComissao;
	}

	public void setSalarioComissao(Double salarioComissao) {
		this.salarioComissao = salarioComissao;
	}

	

}
