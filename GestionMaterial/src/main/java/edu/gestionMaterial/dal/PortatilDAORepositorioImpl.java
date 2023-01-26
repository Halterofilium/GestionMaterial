/**
 * 
 */
package edu.gestionMaterial.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author Talamino
 *
 * Clase que implementa la interfaz PortatilDAORepositorio
 * Con la etiqueta component decimos que esta clase se puede añadir al contenedor
 * IoC para hacer inyección de dependencias.
 * Con la etiqueta persistence context estamos iyectando un EntityManager.
 */

@Repository
public class PortatilDAORepositorioImpl implements PortatilDAORepositorio{

	@PersistenceContext
	private EntityManager em;

	
	public List<PortatilDAO> select() throws Exception {
		return em.createQuery("SELECT portatilDAO FROM PortatilDAO portatilDAO").getResultList();
	}

	public void insert(PortatilDAO portatilDAO) throws Exception {
		em.persist(portatilDAO);
		em.clear();
		em.close();
	}

	public void update(PortatilDAO portatilDAO) throws Exception {
		em.merge(portatilDAO);
		em.flush();
	}

	public void delete(PortatilDAO portatilDAO) throws Exception {
		em.remove(em.contains(portatilDAO) ? portatilDAO : em.merge(portatilDAO));
		em.clear();
		em.close();
	}

	public List<PortatilDAO> where(int id) throws Exception {
		String jpql = "SELECT portatilDAO FROM PortatilDAO portatilDAO WHERE portatilDAO.id_portatil > :ID";
		Query query = em.createQuery(jpql);
		query.setParameter("ID", id);
		return query.getResultList();
	}

}
