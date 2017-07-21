import java.util.List;

import javax.persistence.EntityManager;

import br.com.teste.entites.Ajudante;
import br.com.teste.factory.EMFactory;

public class Teste {
	public static void main(String[] args) {		
	
	EntityManager em = new EMFactory().getEntityManager();


		
		List<Ajudante> recebe = em.createNativeQuery("SELECT idUsuario,nome,email,salarioBase,salarioComissao FROM Ajudante").getResultList();
		System.out.println(recebe);
		
	
	}
}
