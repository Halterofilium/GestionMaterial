/**
 * 
 */
package edu.gestionMaterial.dal;

import java.util.List;

/**
 * @author Talamino
 *
 * Interfaz que actúa sobre AlumnoDAO
 * Tan solo se define la signatura de los métodos que actuarán sobre
 * AlumnoDAORepositorio, la implementación se define en AlumnoDAORepositorioImpl
 */
public interface AlumnoDAORepositorio {

	/**
	 * Método que trae todos los registros de la tabla dlk_tch_Alumno
	 * @return List<AlumnoDAO>
	 * @throws Exception 
	 */
	public List<AlumnoDAO> select() throws Exception;
	
	/**
	 * Método que inserta un nuevo repostage en base de datos.
	 * @param alumnoDAO
	 * @throws Exception 
	 */
	public void insert(AlumnoDAO alumnoDAO) throws Exception;
	
	/**
	 * Método que actualiza un repostage en base de datos.
	 * @param alumnoDAO
	 * @throws Exception 
	 */
	public void update(AlumnoDAO alumnoDAO) throws Exception;
	
	/**
	 * Método que elimina un repostage en base de datos.
	 * @param alumnoDAO
	 * @throws Exception 
	 */
	public void delete(AlumnoDAO alumnoDAO) throws Exception;
	
	/**
	 * Método que devuelve un registro especifico de BBDD.
	 * @param id
	 * @return List<AlumnoDAO>
	 * @throws Exception 
	 */
	public List<AlumnoDAO> where(int id) throws Exception;
	
}
