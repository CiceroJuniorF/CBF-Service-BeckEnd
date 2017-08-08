package br.com.cbf.exception;

import br.com.cbf.enums.CodigosErros;

public class ClienteException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CodigosErros codigoErro;

	public ClienteException(String menssagem, CodigosErros codigoErro) {
		super(menssagem);
		this.codigoErro = codigoErro;
	}




	public CodigosErros getCodigoErro() {
		return codigoErro;
	}
	
	
		
}
