package br.com.teste.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	private EntityManagerFactory emf;

	private EntityManager fabrica() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("testedb-persistence");
		}
		return emf.createEntityManager();
	}
	
	@SuppressWarnings("unused")
	private void fecha(EntityManager em) {
		em.close();
	}

	public EntityManager getEntityManager() {
		return fabrica();
	}
}
