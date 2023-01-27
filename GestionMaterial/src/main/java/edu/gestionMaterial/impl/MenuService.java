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
	 * MatrículaAlumno: registra a un nuevo alumno.
	 * @param alumnoDAO
	 * @param consulta
	 */
	public void MatrículaAlumno(ConsultasServicio consulta);
	
}
