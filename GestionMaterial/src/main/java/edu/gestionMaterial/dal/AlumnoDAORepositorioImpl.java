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

	public void update(String nombreN, String nombreV) throws Exception {
		String jpql = "UPDATE AlumnoDAO alumnoDAO SET alumnoDAO.nombre = >:nombreN WHERE alumnoDAO.nombre = >:nombreV";
		Query query = em.createQuery(jpql);
		query.setParameter("nombreN", nombreN);
		query.setParameter("nombreV", nombreV);
		int numeroModificaciones = query.executeUpdate();
		System.out.println("[INFO] -Numero de modificaciones: " + numeroModificaciones);
	}

	public void delete(AlumnoDAO alumnoDAO) throws Exception {
		
		if(preguntaSiNo("¿Seguro que quieres eliminar el alumno con id: ", alumnoDAO))
		{
			em.remove(em.contains(alumnoDAO) ? alumnoDAO : em.merge(alumnoDAO));
			em.clear();
			em.close();
		}
	
	}

	public List<AlumnoDAO> where(int id) throws Exception {
		String jpql = "SELECT alumnoDAO FROM AlumnoDAO alumnoDAO WHERE alumnoDAO.id_alumno > :ID";
		Query query = em.createQuery(jpql);
		query.setParameter("ID", id);
		return query.getResultList(); 
	}


	
	public static Boolean preguntaSiNo(String pregunta, AlumnoDAO alumnoDAO) 
	{ 
		//Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);
		
		boolean check = false;
		boolean repetir = true;
		int cont = 0;
		
		do{ 
			
			if(cont>0)
				System.out.print("\n\t\tError repita su respuesta otra vez");
			
			System.out.print("\t\t" + pregunta + alumnoDAO.id_alumno + "?" + "\n Si es así escriba su id, de lo contrario escriba 0: ");		  
		         
			int opc = sn.nextInt(); 
			if(opc == alumnoDAO.id_alumno)  
			{ 
				check = true;
				repetir = false; 
			} 
		        
			if(opc == 0)
			{ 
				check = false;
				repetir = false; 
			} 		        	 
		        
			cont++;
			
		    }while(repetir); 
		     
		return check; 
	}
	
}



