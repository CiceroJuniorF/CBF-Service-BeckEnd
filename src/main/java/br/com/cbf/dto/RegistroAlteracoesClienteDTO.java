package br.com.cbf.dto;

import java.util.Calendar;

import br.com.cbf.entites.RegistroAlteracoesCliente;

public class RegistroAlteracoesClienteDTO implements GenericDTO<RegistroAlteracoesCliente>{
	

	private Integer idAlteracaoCliente;	

	private Calendar dataAtualizacao;	
	
	private String descricaoDoMotivoDeAlteracao;

	
	
	public RegistroAlteracoesClienteDTO(RegistroAlteracoesCliente registroAlteracoesCliente) {
		
	}
	
	public RegistroAlteracoesClienteDTO(Integer idAlteracaoCliente, Calendar dataAtualizacao,
			String descricaoDoMotivoDeAlteracao) {
		this.idAlteracaoCliente = idAlteracaoCliente;
		this.dataAtualizacao = dataAtualizacao;
		this.descricaoDoMotivoDeAlteracao = descricaoDoMotivoDeAlteracao;
	}
	
	
	public Integer getIdAlteracaoCliente() {
		return idAlteracaoCliente;
	}

	public void setIdAlteracaoCliente(Integer idAlteracaoCliente) {
		this.idAlteracaoCliente = idAlteracaoCliente;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getDescricaoDoMotivoDeAlteracao() {
		return descricaoDoMotivoDeAlteracao;
	}

	public void setDescricaoDoMotivoDeAlteracao(String descricaoDoMotivoDeAlteracao) {
		this.descricaoDoMotivoDeAlteracao = descricaoDoMotivoDeAlteracao;
	}

	@Override
	public void converteDTO(RegistroAlteracoesCliente alteracao) {
		this.idAlteracaoCliente = alteracao.getIdAlteracaoCliente();
		this.dataAtualizacao = alteracao.getDataAtualizacao();
		this.descricaoDoMotivoDeAlteracao = alteracao.getDescricaoDoMotivoDeAlteracao();
		
	}
	
	
	
	
}
