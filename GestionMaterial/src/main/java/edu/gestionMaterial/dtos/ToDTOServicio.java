/**
 * 
 */
package edu.gestionMaterial.dtos;

import java.util.List;

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
	 * Paso de DAO a DTO (PortatilDAO _> PortatilDTO)
	 * @param portatilDAO
	 * @return PortatilDTO
	 */
	public PortatilDTO PortatilVehiculoToDTO(PortatilDAO portatilDAO);
	
	
	/**
	 * Paso de una lista DAO a DTO (List AlumnoDAO -> List AlumnoDTO)
	 *
	 * @param listAlumnoDAO
	 * @return List<AlumnoDTO>
	 */
	public List<AlumnoDTO> ListAlumnoToDTO(List<AlumnoDAO> listAlumnoDAO);
	
	
	/**
	 * Paso de una lista DAO a DTO (List PortatilDAO -> List PortatilDTO)
	 * @param listPortatilDAO
	 * @return List<PortatilDTO>
	 */
	public List<PortatilDTO> ListPortatilToDTO(List<PortatilDAO> listPortatilDAO);
	
}
