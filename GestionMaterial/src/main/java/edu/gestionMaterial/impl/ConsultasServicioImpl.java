/**
 * 
 */
package edu.gestionMaterial.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.AlumnoDAORepositorio;
import edu.gestionMaterial.dal.PortatilDAO;
import edu.gestionMaterial.dal.PortatilDAORepositorio;

/**
 * @author Talamino
 *  Clase que agrupa las transacaciones contra base de datos
 */

@Service
public class ConsultasServicioImpl implements ConsultasServicio{

	//Alumno
	
	@Autowired
	private AlumnoDAORepositorio adr;
	
	public List<AlumnoDAO> seleccionarTodosLosAlumnos() {
		try {
			return adr.select();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertarAlumno(AlumnoDAO alumnoDAO) {
		try {
			adr.insert(alumnoDAO);
			System.out.println("Registro insertado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void actualizarAlumno(AlumnoDAO alumnoDAO) {
		try {
			adr.update(alumnoDAO);
			System.out.println("Registro actualizado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void borrarAlumno(AlumnoDAO alumnoDAO) {
		try {
			adr.delete(alumnoDAO);
			System.out.println("Registro eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public List<AlumnoDAO> seleccionarAlumnoEspecifico(int id) {
		try {
			return adr.where(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	//Portatil
	
	@Autowired
	private PortatilDAORepositorio pdr;
	
	public List<PortatilDAO> seleccionarTodosLosPortatiles() {
		try {
			return pdr.select();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insertarPortatil(PortatilDAO portatilDAO) {
		try {
			pdr.insert(portatilDAO);
			System.out.println("Registro insertado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	public void actualizarPortatil(PortatilDAO portatilDAO) {
		try {
			pdr.update(portatilDAO);
			System.out.println("Registro actualizado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void borrarPortatil(PortatilDAO portatilDAO) {
		try {
			pdr.delete(portatilDAO);
			System.out.println("Registro eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PortatilDAO> seleccionarPortatilEspecifico(int id) {
		try {
			return pdr.where(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
