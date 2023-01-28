/**
 * 
 */
package edu.gestionMaterial.dtos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Implementación de la interfaz ToDTOServicio
 */
public class ToDTOServicioImpl implements ToDTOServicio{

	@Override
	public AlumnoDTO AlumnoGasolineraToDTO(AlumnoDAO alumnoDAO) {
		
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		
		alumnoDTO.setMd_uuid(alumnoDAO.getMd_uuid());
		alumnoDTO.setMd_fch(alumnoDAO.getMd_fch());
		alumnoDTO.setNombre(alumnoDAO.getNombre());
		alumnoDTO.setTlf(alumnoDAO.getTlf());
		alumnoDTO.setPortatilDAO(alumnoDAO.getPortatilDAO());
		
		return alumnoDTO;
	}

	@Override
	public PortatilDTO PortatilVehiculoToDTO(PortatilDAO portatilDAO) {
		
		PortatilDTO portatilDTO = new PortatilDTO();
		
		portatilDTO.setMd_uuid(portatilDAO.getMd_uuid());
		portatilDTO.setMd_fch(portatilDAO.getMd_fch());
		portatilDTO.setMarca(portatilDAO.getMarca());
		portatilDTO.setModelo(portatilDAO.getModelo());
		portatilDTO.setAlumnoDAO(portatilDAO.getAlumnoDAO());
		
		return portatilDTO;
	}


	@Override
	public List<AlumnoDTO> ListAlumnoToDTO(List<AlumnoDAO> listAlumnoDAO) {

		List<AlumnoDTO> listAlumnoDTO = new ArrayList<AlumnoDTO>();

		// El método map toma cada objeto AlumnoDAO en la lista original y lo convierte en
		// un objeto AlumnoDTO mediante el uso de una expresión lambda. En la lambda se crea
		// un nuevo objeto de tipo AlumnoDTO con el nombre, el telefono y la referencia del portatil
		// de la clase AlumnoDAO y se devuelve. El resultado es una nueva a lista de objetos AlumnoDTO. 
		listAlumnoDTO = listAlumnoDAO.stream()
				.map(alumnoDAO -> new AlumnoDTO(alumnoDAO.getNombre(), alumnoDAO.getTlf(), alumnoDAO.getPortatilDAO()))
				.collect(Collectors.toList());

		return listAlumnoDTO;
	}

	@Override
	public List<PortatilDTO> ListPortatilToDTO(List<PortatilDTO> listPortatilDAO) {
		
		List<PortatilDTO> listPortatilDTO = new ArrayList<PortatilDTO>();

		// El método map toma cada objeto PortatilDAO en la lista original y lo convierte en
		// un objeto PortatilDTO mediante el uso de una expresión lambda. En la lambda se crea
		// un nuevo objeto de tipo PortatilDTO con el nombre, el telefono y la referencia del portatil
		// de la clase PortatilDAO y se devuelve. El resultado es una nueva a lista de objetos PortatilDTO. 
		listPortatilDTO = listPortatilDAO.stream()
				.map(portatilDAO -> new PortatilDTO(portatilDAO.getMarca(), portatilDAO.getModelo(), portatilDAO.getAlumnoDAO()))
				.collect(Collectors.toList());
		
		return listPortatilDTO;
	}

}
