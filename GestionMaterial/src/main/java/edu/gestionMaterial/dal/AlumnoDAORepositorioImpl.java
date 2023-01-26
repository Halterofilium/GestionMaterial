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
 *         Clase que implementa la interfaz AlumnoDAORepositorio Con la etiqueta
 *         component decimos que esta clase se puede añadir al contenedor IoC
 *         para hacer inyección de dependencias. Con la etiqueta persistence
 *         context estamos iyectando un EntityManager.
 */

@Repository
public class AlumnoDAORepositorioImpl implements AlumnoDAORepositorio {

	@PersistenceContext
	private EntityManager em;

	public List<AlumnoDAO> select() throws Exception {
		return em.createQuery("SELECT alumnoDAO FROM AlumnoDAO alumnoDAO").getResultList();
	}

	public void insert(AlumnoDAO alumnoDAO) throws Exception {
		em.persist(alumnoDAO);
		em.clear();
		em.close();
	}

	public void update(AlumnoDAO alumnoDAO) throws Exception {
		em.merge(alumnoDAO);
		em.flush();
	}

	public void delete(AlumnoDAO alumnoDAO) throws Exception {
		em.remove(em.contains(alumnoDAO) ? alumnoDAO : em.merge(alumnoDAO));
		em.clear();
		em.close();
	}

	public List<AlumnoDAO> where(int id) throws Exception {
		String jpql = "SELECT alumnoDAO FROM AlumnoDAO alumnoDAO WHERE alumnoDAO.id_alumno > :ID";
		Query query = em.createQuery(jpql);
		query.setParameter("ID", id);
		return query.getResultList(); 
	}

}
