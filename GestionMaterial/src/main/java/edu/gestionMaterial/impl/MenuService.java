/**
 * 
 */
package edu.gestionMaterial.impl;

import edu.gestionMaterial.dal.AlumnoDAO;

/**
 * @author Talamino
 * MenuService: Interfaz que define las acciones del menú.
 */
public interface MenuService {

	/**
	 * mostrarMenu: método que muestra en consola las acciones posibles y recoge la opción
	 * seleccionada por el usuario.
	 * @return opción elegida por el usuario
	 */
	public int mostrarMenu();
		
	/**
	 * MatrículaAlumno: metodo que registra a un nuevo alumno en la base de datos
	 * @param alumnoDAO
	 * @param consulta
	 */
	public void MatrículaAlumno(ConsultasServicio consulta);
	
	/**
	 * Baja alumno: metodo que elimina de la base de datos a un alumno
	 * @param consulta
	 */
	public void BajaAlumno(ConsultasServicio consulta);
	
	/**
	 * Alta portatil: metodo que registra un nuevo portatil en la base de datos
	 * @param consulta
	 */
	public void AltaPortatil(ConsultasServicio consulta);
	
	
	/**
	 * Consulta portatil de alumno
	 * @param consulta
	 */
	public void ConsultaPortatilDeAlumno(ConsultasServicio consulta);
	
	/**
	 * Consulta el alumno asigando al portatil
	 * @param consulta
	 */
	public void ConsultaElAlumnoAsigandoAlPortatil(ConsultasServicio consulta);
	
	/**
	 * Todos los alumnos con sus repectivos portatiles
	 * @param consulta
	 */
	public void TodosLosAlumnosConSusRepectivosPortatiles(ConsultasServicio consulta);
	
}
