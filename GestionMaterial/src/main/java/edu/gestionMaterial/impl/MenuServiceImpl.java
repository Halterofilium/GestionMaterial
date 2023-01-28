/**
 * 
 */
package edu.gestionMaterial.impl;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.dal.PortatilDAO;
import edu.gestionMaterial.dtos.AlumnoDTO;
import edu.gestionMaterial.dtos.PortatilDTO;
import edu.gestionMaterial.dtos.ToDAOServicio;
import edu.gestionMaterial.dtos.ToDAOServicioImpl;
import edu.gestionMaterial.dtos.ToDTOServicio;
import edu.gestionMaterial.dtos.ToDTOServicioImpl;

/**
 * @author Talamino Implementa la interfaz MenuService
 */

@Service
public class MenuServiceImpl implements MenuService {

	ToDAOServicio toDAO = new ToDAOServicioImpl();
	ToDTOServicio toDTO = new ToDTOServicioImpl();

	// Menu
	public int mostrarMenu() {

		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		// Opciones del menu
		System.out.println("\n\t\t   MENU");
		System.out.println("\n\t\t1) Matricula de alumno");
		System.out.println("\t\t2) Baja de un alumno");
		System.out.println("\t\t3) Alta de portatil");
		System.out.println("\t\t4) Consulta portatil asignado a un alumno");
		System.out.println("\t\t5) Consulta alumno asignado a un portatil");
		System.out.println("\t\t6) Ver todos los alumnos con su asignación de portatil");
		System.out.println("\n\t\t0) Salir");

		System.out.print("\n\t\tEscribe una de las opciones: ");

		// Se devuelve la opcion pulsada
		return sn.nextInt();
	}

	// Consultas
	
	@Override
	public void MatrículaAlumno(ConsultasServicio consulta) {

		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		// Se recogen los datos
		System.out.print("\n\t\tIngrese el nombre: ");
		String nombre = sn.next();

		System.out.print("\n\t\tIngrese el telefono: ");
		String tlf = sn.next();

		//Se recogen los portatiles de la abase de datos
		List<PortatilDAO> listaPortatiles = consulta.seleccionarTodosLosPortatiles();

		// Se muestran los portatiles
		for (PortatilDAO portatilDAO : listaPortatiles) {
			System.out.println("ID: " + portatilDAO.getId_portatil() + "Marca: " + portatilDAO.getMarca() + "Modelo: "
					+ portatilDAO.getModelo());
		}

		// Bucle que controla que el portatil selecionado exista
		int portatilSelecionado = 0;
		do {
			// Se le pide por consola que indique el portatil a seleccionar
			System.out.print("\n\t\tIngrese el portati [1-" + listaPortatiles.size() + "]");
			portatilSelecionado = sn.nextInt();

		} while (portatilSelecionado < 1 || portatilSelecionado > listaPortatiles.size());

		// Se declara e inicializa el DTO
		AlumnoDTO alumnoDTO = new AlumnoDTO(nombre, tlf, listaPortatiles.get(portatilSelecionado));

		// Se llama al metodo en cuestion para la consulta a la base de datos mediante la clase consulta
		consulta.insertarAlumno(toDAO.AlumnoToDAO(alumnoDTO)); // Se convierte de DTO a DAO

	}

	@Override
	public void BajaAlumno(ConsultasServicio consulta) {

		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		//Se recogen los alunos de la abase de datos
		List<AlumnoDAO> listaAlumnosDAO = consulta.seleccionarTodosLosAlumnos();

		//Se convierte en una lista de DTOs
		List<AlumnoDTO> listaAlumnosDTO = toDTO.ListAlumnoToDTO(listaAlumnosDAO);
		
		// Se muestran los alumnos
		for (AlumnoDTO alumnoDTO : listaAlumnosDTO) {
			System.out.println("ID: " + alumnoDTO.getId_alumno() + "Nombre: " + alumnoDTO.getNombre() + "Telefono: "
					+ alumnoDTO.getTlf());
		}

		// Bucle que controla que el alumno selecionado exista
		int alumnoSelecionado = 0;
		do {
			// Se le pide por consola que indique el alumno a seleccionar
			System.out.print("\n\t\tIngrese el alumno [1-" + listaAlumnosDTO.size() + "]");
			alumnoSelecionado = sn.nextInt();

		} while (alumnoSelecionado < 1 || alumnoSelecionado > listaAlumnosDTO.size());
		
		consulta.borrarAlumno(listaAlumnosDAO.get(alumnoSelecionado-1));

	}

	@Override
	public void AltaPortatil(ConsultasServicio consulta) {

		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		// Se recogen los datos
		System.out.print("\n\t\tIngrese la marca: ");
		String marca = sn.next();

		System.out.print("\n\t\tIngrese el modelo: ");
		String modelo = sn.next();

		//Se recogen los alunos de la abase de datos
		List<AlumnoDAO> listaAlumnos = consulta.seleccionarTodosLosAlumnos();

		// Se muestran los alumnos
		for (AlumnoDAO alumnoDAO : listaAlumnos) {
			System.out.println("ID: " + alumnoDAO.getId_alumno() + "Nombre: " + alumnoDAO.getNombre() + "Telefono: "
					+ alumnoDAO.getTlf());
		}

		// Bucle que controla que el alumno selecionado exista
		int alumnoSelecionado = 0;
		do {
			// Se le pide por consola que indique el alumno a seleccionar
			System.out.print("\n\t\tIngrese el alumno [1-" + listaAlumnos.size() + "]");
			alumnoSelecionado = sn.nextInt();

		} while (alumnoSelecionado < 1 || alumnoSelecionado > listaAlumnos.size());

		// Se declara e inicializa el DTO
		PortatilDTO portatilDTO = new PortatilDTO(marca, modelo, listaAlumnos.get(alumnoSelecionado));

		// Se llama al metodo en cuestion para la consulta a la base de datos mediante la clase consulta
		consulta.insertarPortatil(toDAO.PortatilToDAO(portatilDTO)); // Se convierte de DTO a DAO

	}

	@Override
	public void ConsultaPortatilDeAlumno(ConsultasServicio consulta) {
		
		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);
		
		// Se recogen los alunos de la abase de datos
		List<AlumnoDAO> listaAlumnosDAO = consulta.seleccionarTodosLosAlumnos();

		//Se convierte en una lista de DTOs
		List<AlumnoDTO> listaAlumnosDTO = toDTO.ListAlumnoToDTO(listaAlumnosDAO);
				

		// Se muestran los alumnos
		for (AlumnoDTO alumnoDTO : listaAlumnosDTO) {
			System.out.println("ID: " + alumnoDTO.getId_alumno() + "Nombre: " + alumnoDTO.getNombre());
		}

		// Bucle que controla que el alumno selecionado exista
		int alumnoSelecionado = 0;
		do {
			// Se le pide por consola que indique el alumno a seleccionar
			System.out.print("\n\t\tIngrese el alumno [1-" + listaAlumnosDTO.size() + "]");
			alumnoSelecionado = sn.nextInt();

		} while (alumnoSelecionado < 1 || alumnoSelecionado > listaAlumnosDTO.size());
		
		//Guardamos el alumno seleccionado
		AlumnoDTO alumnoDTO = listaAlumnosDTO.get(alumnoSelecionado-1);
		
		//Mostramos el alumno con su portatil
		System.out.println(alumnoDTO.toString());
		
	} 

	@Override
	public void ConsultaElAlumnoAsigandoAlPortatil(ConsultasServicio consulta) {
		
		// Declaramos el escaner que imitara el funcionamiento de un input
		Scanner sn = new Scanner(System.in);

		// Se recogen los portatiles de la abase de datos
		List<PortatilDAO> listaPortatilesDAO = consulta.seleccionarTodosLosPortatiles();

		//Se convierte en una lista de DTOs
		List<PortatilDTO> listaPortatilesDTO = toDTO.ListPortatilToDTO(listaPortatilesDAO);
		
		// Se muestran los portatiles
		for (PortatilDTO portatilDTO : listaPortatilesDTO) {
			System.out.println("ID: " + portatilDTO.getId_portatil() + "Modelo: " + portatilDTO.getModelo());
		}

		// Bucle que controla que el portatil selecionado exista
		int portatilSelecionado = 0;
		do {
			// Se le pide por consola que indique el portatil a seleccionar
			System.out.print("\n\t\tIngrese el portatil [1-" + listaPortatilesDTO.size() + "]");
			portatilSelecionado = sn.nextInt();

		} while (portatilSelecionado < 1 || portatilSelecionado > listaPortatilesDTO.size());

		// Guardamos el alumno seleccionado
		PortatilDTO portatilDTO = listaPortatilesDTO.get(portatilSelecionado-1);

		// Mostramos el alumno con su portatil
		System.out.println(portatilDTO.toString());
		
	}

	@Override
	public void TodosLosAlumnosConSusRepectivosPortatiles(ConsultasServicio consulta) {

		//Se recogen los alunos de la abase de datos
		List<AlumnoDAO> listaAlumnosDAO = consulta.seleccionarTodosLosAlumnos();
		
		//Se convierte en una lista de DTOs
		List<AlumnoDTO> listaAlumnosDTO = toDTO.ListAlumnoToDTO(listaAlumnosDAO);
		
		// Se muestran todos los alumnos con sus respectivos portatiles
		for (AlumnoDTO alumnoDTO : listaAlumnosDTO) 
		{
			System.out.println("Nombre: " + alumnoDTO.getNombre() + "Portail: "+ alumnoDTO.getPortatilDAO());
		}
							
	}

}
