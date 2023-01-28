/**
 * 
 */
package edu.gestionMaterial.dtos;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Interfaz que contiene los metodos que pasan de DTO a DAO
 */
public interface ToDAOServicio {

	/*
	 * Paso de DTO a DAO (AlumnoDTO -> AlumnoDAO)
	 * @param alumnoDTO
	 * @return AlumnoDAO
	 */
	public AlumnoDAO AlumnoToDAO(AlumnoDTO alumnoDTO);
		
	/*
	 * Paso de DTO a DAO (AlumnoDTO -> AlumnoDAO)
	 * @param portatilDTO
	 * @return PortatilDAO
	 */
	public PortatilDAO PortatilToDAO(PortatilDTO portatilDTO);

	
}
