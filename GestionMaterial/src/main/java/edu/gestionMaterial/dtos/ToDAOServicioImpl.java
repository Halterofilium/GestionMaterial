/**
 * 
 */
package edu.gestionMaterial.dtos;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Implementación de la interfaz ToDAOServicio
 */
public class ToDAOServicioImpl implements ToDAOServicio{

	public AlumnoDAO AlumnoToDAO(AlumnoDTO alumnoDTO) {
	
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		alumnoDAO.setMd_uuid(alumnoDTO.getMd_uuid());
		alumnoDAO.setMd_fch(alumnoDTO.getMd_fch());
		alumnoDAO.setNombre(alumnoDTO.getNombre());
		alumnoDAO.setTlf(alumnoDTO.getTlf());
		alumnoDAO.setPortatilDAO(alumnoDTO.getPortatilDAO());
		
		return alumnoDAO;
	}

	public PortatilDAO PortatilToDAO(PortatilDTO portatilDTO) {
		
		PortatilDAO portatilDAO = new PortatilDAO();
		
		portatilDAO.setMd_uuid(portatilDTO.getMd_uuid());
		portatilDAO.setMd_fch(portatilDTO.getMd_fch());
		portatilDAO.setMarca(portatilDTO.getMarca());
		portatilDAO.setModelo(portatilDTO.getModelo());
		portatilDAO.setAlumnoDAO(portatilDTO.getAlumnoDAO());
		
		return portatilDAO;
	}

}
