/**
 * 
 */
package edu.gestionMaterial.dtos;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Interfaz que contiene los metodos que pasan de DAO a DTO
 */
public interface ToDTOServicio {

	/*
	 * Paso de DAO a DTO (AlumnoDAO -> AlumnoDTO)
	 * @param alumnoDAO
	 * @return AlumnoDTO
	 */
	public AlumnoDTO AlumnoGasolineraToDTO(AlumnoDAO alumnoDAO);
	
	/*
	 * Paso de DAO a DTO (portatilDAO -> PortatilDTO)
	 * @param portatilDAO
	 * @return PortatilDTO
	 */
	public PortatilDTO PortatilVehiculoToDTO(PortatilDAO portatilDAO);
	
}
