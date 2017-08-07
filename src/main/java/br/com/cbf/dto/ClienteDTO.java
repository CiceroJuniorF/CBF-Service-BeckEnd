package br.com.cbf.dto;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.cbf.entites.Endereco;
import br.com.cbf.entites.RG;

@XmlRootElement
public class ClienteDTO {
	
	
	private Integer id; 	

	private String nome;
	
	private String sobrenome;

	private String apelido;	
	
	private String sexo;
	
	private Calendar dataNascimento;

	private Endereco endereco;
	
	private String telefone;
	
	private RG rg;
	
	private String cpf;

	private String cidade_nascimento;

	private String estadoNascimento;
	
	private int resultado;
	
    private String resultadoTXT;
    
    private String sintuacao;

    
    
    
    
	public ClienteDTO(Integer id, String nome, String sobrenome, String apelido, String sexo,Calendar dataNascimento,
			String telefone, RG rg, String cpf, String cidade_nascimento,String estadoNascimento, String sintuacao, Endereco endereco, String resultadoTXT) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.cidade_nascimento = cidade_nascimento;
		this.estadoNascimento = estadoNascimento;
		this.sintuacao = sintuacao;
		this.endereco = endereco;
		this.resultadoTXT = resultadoTXT;
	}	
	
	public ClienteDTO(String resultadoTXT) {
		this.resultadoTXT = resultadoTXT;
	}
	

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getSexo() {
		return sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public RG getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

	public String getCidade_nascimento() {
		return cidade_nascimento;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public int getResultado() {
		return resultado;
	}

	public String getResultadoTXT() {
		return resultadoTXT;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public String getSintuacao() {
		return sintuacao;
	}


	public void setSintuacao(String sintuacao) {
		this.sintuacao = sintuacao;
	}  
    
	
	
    
    
   

}
