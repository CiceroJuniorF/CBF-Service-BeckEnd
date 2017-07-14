package br.com.teste.auxiliar;

import java.util.List;

import br.com.teste.dto.AjudanteDTO;
import br.com.teste.entites.Ajudante;

public class ConversorDTO {
	
	//Ajudante
	List<AjudanteDTO> listDTO;
	public AjudanteDTO coverteAjudante(Ajudante ajudante) {
		
		return new AjudanteDTO(ajudante.getNome(), ajudante.getEmail(),ajudante.getPassword(),
				ajudante.getEndereco(),
				ajudante.getSalarioBase(),
				ajudante.getSalarioComissao());
	}
	
	public List<AjudanteDTO> coverteListaAjudante(List<Ajudante> lista) {
		
		for (Ajudante ajudante : lista) {
			AjudanteDTO dto = new AjudanteDTO(ajudante.getNome(), ajudante.getEmail(),ajudante.getPassword(),
					ajudante.getEndereco(),
					ajudante.getSalarioBase(),
					ajudante.getSalarioComissao());
			this.listDTO.add(dto);		
		}	
		
		
		return this.listDTO;
	}
	
	//Ajudante
	
}
