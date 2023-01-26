/**
 * 
 */
package edu.gestionMaterial.dtos;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Implementación de la interfaz ToDTOServicio
 */
public class ToDTOServicioImpl implements ToDTOServicio{


	public AlumnoDTO AlumnoGasolineraToDTO(AlumnoDAO alumnoDAO) {
		
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		
		alumnoDTO.setMd_uuid(alumnoDAO.getMd_uuid());
		alumnoDTO.setMd_fch(alumnoDAO.getMd_fch());
		alumnoDTO.setNombre(alumnoDAO.getNombre());
		alumnoDTO.setTlf(alumnoDAO.getTlf());
		alumnoDTO.setPortatilDAO(alumnoDAO.getPortatilDAO());
		
		return alumnoDTO;
	}

	
	public PortatilDTO PortatilVehiculoToDTO(PortatilDAO portatilDAO) {
		
		PortatilDTO portatilDTO = new PortatilDTO();
		
		portatilDTO.setMd_uuid(portatilDAO.getMd_uuid());
		portatilDTO.setMd_fch(portatilDAO.getMd_fch());
		portatilDTO.setMarca(portatilDAO.getMarca());
		portatilDTO.setModelo(portatilDAO.getModelo());
		portatilDTO.setAlumnoDAO(portatilDAO.getAlumnoDAO());
		
		return portatilDTO;
	}

}
