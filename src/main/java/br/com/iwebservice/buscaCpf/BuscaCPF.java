/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iwebservice.buscaCpf;

import br.com.cbf.dto.ClienteDTO;
import br.com.cbf.entites.Endereco;

public class BuscaCPF {
	private String chave = "AAAAA-BBBBB-CCCCC-DDDDD-EEEEE";// Informe aqui a sua CHAVE de Acesso Gratuita criada em nosso
														// site: www.iWebService.com.br
	private ClienteDTO clienteDTO;

	public BuscaCPF() {


	}

	public ClienteDTO buscaPorCPF(String cpf, String dataNascimento) throws Exception {
		CpfWebService cpfWebService = new CpfWebService(cpf, dataNascimento, this.chave);
		
			if (cpfWebService.getResultado() == 0 || cpfWebService.getResultado() == 2) {

				throw new Exception(cpfWebService.getResultadoTXT());
				
			} else if (cpfWebService.getResultado() == 3) {

				throw new Exception(cpfWebService.getResultadoTXT());
				
			} else if (cpfWebService.getResultado() == 4) {
				
				throw new Exception(cpfWebService.getResultadoTXT());
				

			} else if (cpfWebService.getResultado() == 1) {
				Endereco endereco = new Endereco(null,cpfWebService.getCep(),cpfWebService.getLogradouro(), cpfWebService.getComplemento(), cpfWebService.getBairro(),
						cpfWebService.getCidade(), cpfWebService.getUF(),cpfWebService.getNumero());				
				this.clienteDTO = new ClienteDTO(null, cpfWebService.getTitular(), null, null, cpfWebService.getSexo(), null,
						null, null, cpfWebService.getCpf(), null, null,cpfWebService.getSituacao(),endereco,cpfWebService.getResultadoTXT());
				

				
			} else {
				throw new Exception(cpfWebService.getResultadoTXT());
			}
		

	
		return clienteDTO;
	}
}