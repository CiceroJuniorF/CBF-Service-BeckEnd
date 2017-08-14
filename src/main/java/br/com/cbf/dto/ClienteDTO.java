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
	
	private Calendar dataNascimento;

	private Endereco endereco;
	
	private String telefone;
	
	private RG rg;
	
	private String cpf;
	    
    private String sintuacao;

    
    
    
    
	public ClienteDTO(Integer id, String nome, String sobrenome,Calendar dataNascimento,
			String telefone, RG rg, String cpf, String sintuacao, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.rg = rg;
		this.cpf = cpf;
		this.sintuacao = sintuacao;
		this.endereco = endereco;
		
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
