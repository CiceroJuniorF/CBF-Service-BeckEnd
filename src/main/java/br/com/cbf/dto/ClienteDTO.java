package br.com.cbf.dto;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.DetalhesDoCliente;
import br.com.cbf.entites.Endereco;
import br.com.cbf.entites.Freguesia;
import br.com.cbf.entites.Profissao;
import br.com.cbf.entites.RG;

@XmlRootElement
public class ClienteDTO implements GenericDTO<Cliente> {
	

	private Integer idCliente;


	private DetalhesDoClienteDTO registro;

	private String sintuacao;


	private String nome;

	
	private String sobrenome;

	
	private String apelido;
	
	
	private String sexo;

	private Calendar dataNascimento;


	private Endereco endereco;


	private String telefone;

	private RG rg;


	private String cpf;


	private Profissao profissao;

	
	private String paisNascimento;


	private String cidade_nascimento;

	
	private String estadoNascimento;


	public ClienteDTO(Cliente cliente) {
		converteDTO(cliente);
	}
	
	public ClienteDTO(Integer idCliente, Freguesia freguesia, DetalhesDoCliente registro, String sintuacao, String nome,
			String sobrenome, String apelido, String sexo, Calendar dataNascimento, Endereco endereco, String telefone,
			RG rg, String cpf, Profissao profissao, String paisNascimento, String cidade_nascimento,
			String estadoNascimento) {
		this.idCliente = idCliente;
		this.registro = new DetalhesDoClienteDTO(registro);
		this.sintuacao = sintuacao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.profissao = profissao;
		this.paisNascimento = paisNascimento;
		this.cidade_nascimento = cidade_nascimento;
		this.estadoNascimento = estadoNascimento;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public DetalhesDoClienteDTO getRegistro() {
		return registro;
	}

	public void setRegistro(DetalhesDoClienteDTO registro) {
		this.registro = registro;
	}

	public String getSintuacao() {
		return sintuacao;
	}


	public void setSintuacao(String sintuacao) {
		this.sintuacao = sintuacao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public RG getRg() {
		return rg;
	}


	public void setRg(RG rg) {
		this.rg = rg;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Profissao getProfissao() {
		return profissao;
	}


	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}


	public String getPaisNascimento() {
		return paisNascimento;
	}


	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}


	public String getCidade_nascimento() {
		return cidade_nascimento;
	}


	public void setCidade_nascimento(String cidade_nascimento) {
		this.cidade_nascimento = cidade_nascimento;
	}


	public String getEstadoNascimento() {
		return estadoNascimento;
	}


	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	@Override
	public void converteDTO(Cliente cliente) {		
		this.idCliente = cliente.getIdCliente();
		this.registro = new DetalhesDoClienteDTO(cliente.getRegistro());
		this.sintuacao = cliente.getSintuacao();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.apelido = cliente.getApelido();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.endereco = cliente.getEndereco();
		this.telefone = cliente.getTelefone();
		this.rg = cliente.getRg();
		this.cpf = cliente.getCpf();
		this.profissao = cliente.getProfissao();
		this.paisNascimento = cliente.getPaisNascimento();
		this.cidade_nascimento = cliente.getCidade_nascimento();
		this.estadoNascimento = cliente.getEstadoNascimento();

		
	}

	
	
    
    
	
	
    
    
   

}
