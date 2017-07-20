package br.com.teste.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import br.com.teste.auxiliar.ConversorDTO;
import br.com.teste.auxiliar.DataAuxiliar;
import br.com.teste.dao.VendedorDAO;
import br.com.teste.dao.impl.VendedorDAOImpl;
import br.com.teste.dto.VendedorDTO;
import br.com.teste.entites.Vendedor;
import br.com.teste.service.VendedorService;

public class VendedorServiceImpl implements VendedorService {
	private VendedorDAO dao = new VendedorDAOImpl();
	@Override
	public Response cadastrarOuAtualizarFuncionario(Vendedor funcionario) {
		if(funcionario.getIdUsuario() == null) {
		try {
			funcionario.setDataCadastro(DataAuxiliar.dataAtual());
			dao.adiciona(funcionario);
			URI uri = URI.create("/vendedor/listar/" + funcionario.getIdUsuario());
			return Response.created(uri).build();

		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		}else {
			try {
				funcionario.setDataCadastro(DataAuxiliar.dataAtual());
				dao.atualiza(funcionario);				
				return Response.status(200).build();
			} catch (SQLException e) {
				e.printStackTrace();
				return Response.status(500).build();
			}
		}
	}

	@Override
	public List<Vendedor> listarTodosFuncionariosDetalhado() {
		try {
			return dao.listaTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<VendedorDTO> listarTodosFuncionariosSimples() {
		try {
			return new ConversorDTO().coverteListaVendedor(dao.listaTodos());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vendedor buscaPorIdDetalhado(Integer id) {
		try {
			return dao.buscaPorId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VendedorDTO buscaPorIdSimples(Integer id) {
		try {

			return new ConversorDTO().converteVendedor(dao.buscaPorId(id));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Response deletar(Integer id) {
		try {
			dao.remove(id);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();

		}

	}
	
	
	
	
	


}
