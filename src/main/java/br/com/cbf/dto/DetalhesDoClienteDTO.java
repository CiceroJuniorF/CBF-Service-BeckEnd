package br.com.cbf.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cbf.entites.DetalhesDoCliente;
import br.com.cbf.entites.Funcionario;
import br.com.cbf.entites.RegistroAlteracoesCliente;

public class DetalhesDoClienteDTO implements GenericDTO<DetalhesDoCliente> {

	private Integer idRegistroCliente;

	private Calendar dataCadastro;

	private FuncionarioDTO cadastrador;

	private List<RegistroAlteracoesClienteDTO> alteracao = new ArrayList<>();

	public DetalhesDoClienteDTO(DetalhesDoCliente detalhesDoCliente) {
		converteDTO(detalhesDoCliente);

	}

	public DetalhesDoClienteDTO(Integer idRegistroCliente, Calendar dataCadastro, Funcionario cadastrador,
			List<RegistroAlteracoesCliente> alteracao) {
		this.idRegistroCliente = idRegistroCliente;
		this.dataCadastro = dataCadastro;
		this.cadastrador = new FuncionarioDTO(cadastrador);
		for (RegistroAlteracoesCliente registroAlteracoesCliente : alteracao) {
			this.alteracao.add(new RegistroAlteracoesClienteDTO(registroAlteracoesCliente));
		}

	}

	public Integer getIdRegistroCliente() {
		return idRegistroCliente;
	}

	public void setIdRegistroCliente(Integer idRegistroCliente) {
		this.idRegistroCliente = idRegistroCliente;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<RegistroAlteracoesClienteDTO> getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(List<RegistroAlteracoesClienteDTO> alteracao) {
		this.alteracao = alteracao;
	}

	public FuncionarioDTO getCadastrador() {
		return cadastrador;
	}

	public void setCadastrador(FuncionarioDTO cadastrador) {
		this.cadastrador = cadastrador;
	}

	@Override
	public void converteDTO(DetalhesDoCliente detalhes) {
		this.idRegistroCliente = detalhes.getIdRegistroCliente();
		this.dataCadastro = detalhes.getDataCadastro();
		this.cadastrador = new FuncionarioDTO(detalhes.getCadastrador());

		if (detalhes.getAlteracao() != null) {
			for (RegistroAlteracoesCliente registroAlteracoesCliente : detalhes.getAlteracao()) {
				this.alteracao.add(new RegistroAlteracoesClienteDTO(registroAlteracoesCliente));
			}
		}

	}

}
