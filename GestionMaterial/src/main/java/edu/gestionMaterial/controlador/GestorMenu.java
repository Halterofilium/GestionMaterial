/**
 * 
 */
package edu.gestionMaterial.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.gestionMaterial.dal.AlumnoDAO;
import edu.gestionMaterial.impl.ConsultasServicio;
import edu.gestionMaterial.impl.MenuService;
import edu.gestionMaterial.impl.MenuServiceImpl;

/**
 * @author Talamino GestorMenu: Controlador de interacción con la aplicación.
 */

@Controller
public class GestorMenu {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// Contexto
		ApplicationContext context = new ClassPathXmlApplicationContext("contexto.xml");
		ConsultasServicio consulta = (ConsultasServicio) context.getBean(ConsultasServicio.class);

		
		//Instancia del menu, con el cual se interactua con las funcionalidades del programa
		MenuService menu = new MenuServiceImpl(); 
		
		//Logica del menu
		int opcion = 3; 

		while (opcion != 0) {

			opcion = menu.mostrarMenu();

			switch (opcion) {
			case 1:
				menu.MatrículaAlumno(consulta);
				break;
			case 2:
				menu.BajaAlumno(consulta);
				break;
			case 3:
				menu.AltaPortatil(consulta);
				break;
			case 4:
				menu.ConsultaPortatilDeAlumno(consulta);
				break;
			case 5:
				menu.ConsultaElAlumnoAsigandoAlPortatil(consulta);
				break;
			case 6:
				menu.TodosLosAlumnosConSusRepectivosPortatiles(consulta);
				break;
			case 0:
				System.out.println("\n\t\tGracias por usar nuestra app");
				break;
			default:
				System.out.println("\n\t\tSolo números entre 0 y 7");
				break;
			}

		}

	}

}
