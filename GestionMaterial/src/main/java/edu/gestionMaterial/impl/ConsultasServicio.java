/**
 * 
 */
package edu.gestionMaterial.impl;

import java.util.List;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Consultas: Interfaz que define los métodos específicos de consulta sobre base de datos.
 */
public interface ConsultasServicio {

	//Alumno

	/**
	 * seleccionarTodosLosAlumnos: Hace un select completo de la tabla dlk_tch_Alumno
	 * @return una lista de tipo AlumnoDAO
	 */
	public List<AlumnoDAO> seleccionarTodosLosAlumnos();
	
	/**
	 * repostajeGasolinera: Inserta en base de datos un nuevo alumno
	 * @param alumnoDAO
	 */
	public void insertarAlumno(AlumnoDAO alumnoDAO);
	
	/**
	 * repostajeGasolinera: Actualiza en base de datos a un alumno
	 * @param alumnoDAO
	 */
	public void actualizarAlumno(AlumnoDAO alumnoDAO);
	
	/**
	 * repostajeGasolinera: Elimina en base de datos a un alumno
	 * @param alumnoDAO
	 */
	public void borrarAlumno(AlumnoDAO alumnoDAO);
	
	/**
	 * seleccionarTodosLosAlumnos: Hace un select de la tabla dlk_tch_Alumno pero filtrando con un where por id
	 * @param id
	 * @return una lista de tipo AlumnoDAO
	 */
	public List<AlumnoDAO> seleccionarAlumnoEspecifico(int id);
	
	
	//Portatil
	
	/**
	 * seleccionarTodosLosAlumnos: Hace un select completo de la tabla dlk_tch_Portatil
	 * @return una lista de tipo PortatilDAO
	 */
	public List<PortatilDAO> seleccionarTodosLosPortatiles();
	
	/**
	 * repostajeGasolinera: Inserta en base de datos un nuevo portatil
	 * @param portatilDAO
	 */
	public void insertarPortatil(PortatilDAO portatilDAO);
	
	/**
	 * repostajeGasolinera: Actualiza en base de datos a un portatil
	 * @param portatilDAO
	 */
	public void actualizarPortatil(PortatilDAO portatilDAO);
	
	/**
	 * repostajeGasolinera: Elimina en base de datos a un portatil
	 * @param portatilDAO
	 */
	public void borrarPortatil(PortatilDAO portatilDAO);
	
	/**
	 * seleccionarTodosLosAlumnos: Hace un select de la tabla dlk_tch_Portatil pero filtrando con un where por id
	 * @param id
	 * @return una lista de tipo PortatilDAO
	 */
	public List<PortatilDAO> seleccionarPortatilEspecifico(int id);
	
}
