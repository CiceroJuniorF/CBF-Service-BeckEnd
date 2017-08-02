package br.com.cbf.service.impl;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import br.com.cbf.auxiliar.DataAuxiliar;
import br.com.cbf.dao.MasterDAO;
import br.com.cbf.dao.impl.MasterDAOImpl;
import br.com.cbf.dto.MasterDTO;
import br.com.cbf.entites.Master;
import br.com.cbf.factory.EMFactory;
import br.com.cbf.service.MasterService;

public class MasterServiceImpl implements MasterService {
	
	private EntityManager em = new EMFactory().getEntityManager();
	
	
	// --------------------------------------------MASTER---------------------------------------------------------------//
	private GenericServiceImpl<Master> genericserviceMaster = new GenericServiceImpl<Master>(Master.class,
			this.em);
	private MasterDAO daoMaster = new MasterDAOImpl(this.em);
	// -----------------------------------------------------------------------------------------------------------------//


	

	
	

	
	
	
	// --------------------------------------------MASTER---------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	// -----------------------------------------------------------------------------------------------------------------//
	@Override
	public Response cadastrarOuAtualizarMaster(Master master) {
		try {

			if (master.getIdUsuario() == null) {
				master.setDataCadastro(DataAuxiliar.dataAtual());
				em.getTransaction().begin();
				daoMaster.salvar(master);
				em.getTransaction().commit();

				URI uri = URI.create("/master/listarDetalhado/" + master.getIdUsuario());
				return Response.created(uri).build();

			} else {
				master.setDataCadastro(DataAuxiliar.dataAtual());
				genericserviceMaster.atualiza(master);
				return Response.status(201).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}


	@Override
	public Response deletarMaster(Integer id) {
		try {
			genericserviceMaster.remove(id);
			return Response.status(202).build();
		} catch (Exception e) {
			return Response.status(304).build();
		}
	}

	@Override
	public List<Master> listarTodosMasterDetalhado() {		
		return genericserviceMaster.listaTodosDetalhado();
	}

	@Override
	public List<MasterDTO>listarTodosMasterSimples(){
		try {
			em.getTransaction().begin();
			List<MasterDTO> lista = daoMaster.listarSimples();
			em.getTransaction().commit();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Override
	public Response buscaMasterPorIdDetalhado(Integer id) {
		try {
			return Response.status(200).entity(genericserviceMaster.buscaPorId(id)).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	@Override
	public Response buscaMasterPorIdSimples(Integer id) {
		try {
			em.getTransaction().begin();
			MasterDTO Vendedor = daoMaster.buscaSimples(id);
			em.getTransaction().commit();

			return Response.status(200).entity(Vendedor).build();
		} catch (Exception e) {
			return Response.status(204).build();
		}
	}

	// -----------------------------------------------------------------------------------------------------------------//

	
	
}
