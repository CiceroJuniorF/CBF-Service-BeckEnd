package br.com.teste.service.impl;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.ConversorDTO;
import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Vendedor;
import br.com.teste.service.VendedorService;

public class VendedorServiceImpl implements VendedorService {

	private GenericServiceImpl<Vendedor> genericservice = new GenericServiceImpl<Vendedor>(Vendedor.class);
	// private VendedorDAO dao = new VendedorDAOImpl();

	@Override
	public Response cadastrarOuAtualizarFuncionario(Vendedor funcionario) {
		try {
			if (funcionario.getIdUsuario() == null) {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.adiciona(funcionario);
				URI uri = URI.create("/vendedor/listar/" + funcionario.getIdUsuario());
				return Response.created(uri).build();

			} else {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				genericservice.atualiza(funcionario);
				return Response.status(200).build();
			}
		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@Override
	public List<Vendedor> listarTodosFuncionariosDetalhado() {

		return genericservice.listaTodosDetalhado();

	}

	@Override
	public List<VendedorDTO> listarTodosFuncionariosSimples() {

		return new ConversorDTO().coverteListaVendedor(genericservice.listaTodosDetalhado());

	}

	@Override
	public Vendedor buscaPorIdDetalhado(Integer id) {
		return genericservice.buscaPorId(id);
	}

	@Override
	public VendedorDTO buscaPorIdSimples(Integer id) {

		return new ConversorDTO().converteVendedor(genericservice.buscaPorId(id));

	}

	@Override
	public Response deletar(Integer id) {
		try {
			genericservice.remove(id);
			return Response.status(200).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}

	}

}
