/**
 * 
 */
package edu.gestionMaterial.impl;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;
import edu.gestionMaterial.dtos.AlumnoDTO;
import edu.gestionMaterial.dtos.ToDAOServicio;
import edu.gestionMaterial.dtos.ToDAOServicioImpl;
import edu.gestionMaterial.dtos.ToDTOServicio;
import edu.gestionMaterial.dtos.ToDTOServicioImpl;

/**
 * @author Talamino
 * Implementa la interfaz MenuService
 */

@Service
public class MenuServiceImpl implements MenuService{

	ToDAOServicio toDAO = new ToDAOServicioImpl();
	ToDTOServicio toDTO = new ToDTOServicioImpl();
	
	//Menu
	public int mostrarMenu() {
		
		//Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);
		
		//Opciones del menu
		System.out.println("\n\t\t   MENU");
		System.out.println("\n\t\t1) Matricula de alumno");
		System.out.println("\t\t2) Baja de un alumno");
		System.out.println("\t\t3) Alta de portatil");
		System.out.println("\t\t4) Consulta portatil asignado a un alumno");
		System.out.println("\t\t5) Consulta alumno asignado a un portatil");
		System.out.println("\t\t6) Ver todos los alumnos con su asignación de portatil");
		System.out.println("\n\t\t0) Salir");

		System.out.print("\n\t\tEscribe una de las opciones: ");

		//Se devuelve la opcion pulsada
		return sn.nextInt();
	}


	//Consultas
	public void MatrículaAlumno(ConsultasServicio consulta) {
		
		//Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);
	
		//Se recogen los datos
		System.out.print("\n\t\tIngrese el nombre: ");
		String nombre = sn.next();
		
		System.out.print("\n\t\tIngrese el telefono: ");
		String tlf = sn.next();
		
		
		//Se declara e inicializa el DTO
		AlumnoDTO alumnoDTO = new AlumnoDTO(nombre, tlf);
		
		//Se llama al metodo en cuestion para la consulta a la base de datos mediante la clase consulta
		consulta.insertarAlumno(toDAO.AlumnoToDAO(alumnoDTO)); //Se convierte de DTO a DAO 
		
	}

}
