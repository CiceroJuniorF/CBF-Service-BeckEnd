package br.com.teste.auxiliar;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.dto.AjudanteDTO;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Ajudante;
import br.com.teste.entites.Vendedor;

public class ConversorDTO {

	// Ajudante
	public AjudanteDTO converteAjudante(Ajudante ajudante) {

		return new AjudanteDTO(ajudante.getIdUsuario(), ajudante.getNome(), ajudante.getEmail(),
				ajudante.getSalarioBase(), ajudante.getSalarioComissao(), ajudante.getNivelAcesso());
	}

	public List<AjudanteDTO> coverteListaAjudante(List<Ajudante> lista) {
		List<AjudanteDTO> listDTO = new ArrayList<>();
		for (Ajudante ajudante : lista) {
			listDTO.add(this.converteAjudante(ajudante));
		}

		return listDTO;
	}

	// Ajudante

	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

	// Vendedor
	public VendedorDTO converteVendedor(Vendedor Vendedor) {

		return new VendedorDTO(Vendedor.getIdUsuario(), Vendedor.getNome(), Vendedor.getEmail(),
				Vendedor.getSalarioBase(), Vendedor.getSalarioComissao(), Vendedor.getNivelAcesso());
	}

	public List<VendedorDTO> coverteListaVendedor(List<Vendedor> lista) {
		List<VendedorDTO> listDTO = new ArrayList<>();
		for (Vendedor Vendedor : lista) {
			listDTO.add(this.converteVendedor(Vendedor));
		}

		return listDTO;
	}

	// Vendedor

	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//

}
