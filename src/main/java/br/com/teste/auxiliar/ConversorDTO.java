package br.com.teste.auxiliar;

import java.util.List;

import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;

public class ConversorDTO {
	
	//Ajudante
	private List<AjudanteDTO> listDTO = null;
	
	public AjudanteDTO converteAjudante(Ajudante ajudante) {
		
		return new AjudanteDTO(ajudante.getIdUsuario(),ajudante.getNome(), ajudante.getEmail(),ajudante.getPassword(),
				ajudante.getEndereco(),
				ajudante.getSalarioBase(),
				ajudante.getSalarioComissao());
	}
	
	public List<AjudanteDTO> coverteListaAjudante(List<Ajudante> lista) {
		
		for (Ajudante ajudante : lista) {			
			System.out.println(ajudante.toString());
			listDTO.add(this.converteAjudante(ajudante));
		}	
		
		return listDTO;
	}
	
	//Ajudante
	
}
