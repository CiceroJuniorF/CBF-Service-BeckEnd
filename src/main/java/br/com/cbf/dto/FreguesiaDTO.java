package br.com.cbf.dto;

import br.com.cbf.entites.Freguesia;

public class FreguesiaDTO implements GenericDTO<Freguesia> {

	
	FreguesiaDTO(Freguesia freguesia){
		converteDTO(freguesia);
	}
	
	
	@Override
	public void converteDTO(Freguesia t) {
		// TODO Auto-generated method stub
		
	}

}
