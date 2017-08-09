/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iwebservice.buscaCpf;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Endereco;
import br.com.cbf.enums.CodigosErros;
import br.com.cbf.exception.ClienteException;

public class BuscaCPF {
	
	
	/* CHAVES DE ACESSO // site: www.iWebService.com.br
	 * AAAAA-BBBBB-CCCCC-DDDDD-EEEEE -- Integração 
	 * FE38G-A2BKT-321PV-D42G1 -- Basico
	 * FE38G-A2BKT-321PV-D42G2 -- Especial
	 * FE38G-A2BKT-321PV-D42G3 -- Master
	 * FE38G-A2BKT-321PV-D42G4 -- Plus
	 * 
	 */	
	private String chave = "AAAAA-BBBBB-CCCCC-DDDDD-EEEEE";

	private Cliente clienteDTO;

	public BuscaCPF() {


	}

	public Cliente buscaPorCPF(String cpf, String dataNascimento) throws ClienteException {
		CpfWebService cpfWebService = new CpfWebService(cpf, dataNascimento, this.chave);
		
			if (cpfWebService.getResultado() == 0 || cpfWebService.getResultado() == 2) {

				throw new ClienteException(cpfWebService.getResultadoTXT(),CodigosErros.ERROCPF);
				
			} else if (cpfWebService.getResultado() == 3) {

				throw new ClienteException(cpfWebService.getResultadoTXT(),CodigosErros.DATAINVALIDA);
				
			} else if (cpfWebService.getResultado() == 4) {
				
				throw new ClienteException(cpfWebService.getResultadoTXT(),CodigosErros.DATANAOPERTENCE);
				

			} else if (cpfWebService.getResultado() == 1) {
				Endereco endereco = new Endereco(null,cpfWebService.getCep(),cpfWebService.getLogradouro(), cpfWebService.getComplemento(), cpfWebService.getBairro(),
						cpfWebService.getCidade(), cpfWebService.getUF(),cpfWebService.getNumero());				
				this.clienteDTO = new Cliente(cpfWebService.getTitular(), null, null, cpfWebService.getSexo(), DataAuxiliar.coverteString(cpfWebService.getDataNascimento()),
						null, null, cpfWebService.getCpf(), null, null,cpfWebService.getSituacao(),endereco);
				

				
			} else {
				throw new ClienteException(cpfWebService.getResultadoTXT(),CodigosErros.ERROR);
			}
		

	
		return clienteDTO;
	}
}