package br.com.cbf.dao;

import java.util.List;

import br.com.cbf.entites.Cliente;
import br.com.cbf.entites.Freguesia;
import br.com.cbf.entites.RegistroMensalFreguesia;


public interface FreguesiaDAO {
	
	public List<Freguesia> listarTodasFreguesias();
	
	public List<Cliente> listarTodosClientesDaFreguesia();
	
	public Freguesia buscaFreguesiaPorId(Integer id);
	
	public void atualizarAlvoMensalFreguesia(Freguesia freguesia);
	
	public void zerarAlvoRegistroMensalFreguesia(Freguesia freguesia);
	
	public List<RegistroMensalFreguesia> listarRegistrosFreguesia();
	
	
	
	
}
