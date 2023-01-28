/**
 * 
 */
package edu.gestionMaterial.dal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author Talamino
 *
 * Clase que implementa la interfaz PortatilDAORepositorio Con la
 * etiqueta component decimos que esta clase se puede añadir al
 * contenedor IoC para hacer inyección de dependencias. Con la etiqueta
 * persistence context estamos iyectando un EntityManager.
 */

@Repository
public class PortatilDAORepositorioImpl implements PortatilDAORepositorio {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<PortatilDAO> select() throws Exception {
		return em.createQuery("SELECT portatilDAO FROM PortatilDAO portatilDAO").getResultList();
	}

	@Override
	public void insert(PortatilDAO portatilDAO) throws Exception {
		em.persist(portatilDAO);
		em.clear();
		em.close();
	}

	@Override
	public void update(String marcaN, String marcaV) throws Exception {
		String jpql = "UPDATE AlumnoDAO alumnoDAO SET alumnoDAO.nombre = >:marcaN WHERE alumnoDAO.nombre = >:marcaV";
		Query query = em.createQuery(jpql);
		query.setParameter("nombreN", marcaN);
		query.setParameter("nombreV", marcaV);
		int numeroModificaciones = query.executeUpdate();
		System.out.println("[INFO] -Numero de modificaciones: " + numeroModificaciones);
	}

	@Override
	public void delete(PortatilDAO portatilDAO) throws Exception {

		if (preguntaSiNo("¿Seguro que quieres eliminar el portatil con id: ", portatilDAO)) {
			em.remove(em.contains(portatilDAO) ? portatilDAO : em.merge(portatilDAO));
			em.clear();
			em.close();
		}

	}

	@Override
	public List<PortatilDAO> where(int id) throws Exception {
		String jpql = "SELECT portatilDAO FROM PortatilDAO portatilDAO WHERE portatilDAO.id_portatil > :ID";
		Query query = em.createQuery(jpql);
		query.setParameter("ID", id);
		return query.getResultList();
	}

	//Metodo para confirmar la accion en base de datos
	public static Boolean preguntaSiNo(String pregunta, PortatilDAO portatilDAO) {
		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		boolean check = false;
		boolean repetir = true;
		int cont = 0;

		do {

			if (cont > 0)
				System.out.print("\n\t\tError repita su respuesta otra vez");

			System.out.print("\t\t" + pregunta + portatilDAO.id_portatil + "?"
					+ "\n Si es así escriba su id, de lo contrario escriba 0: ");

			int opc = sn.nextInt();
			if (opc == portatilDAO.id_portatil) {
				check = true;
				repetir = false;
			}

			if (opc == 0) {
				check = false;
				repetir = false;
			}

			cont++;

		} while (repetir);

		return check;
	}

}
