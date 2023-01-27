/**
 * 
 */
package edu.gestionMaterial.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

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

		MenuService menu = new MenuServiceImpl(); 
		int opcion = 3; 

		while (opcion != 0) {

			opcion = menu.mostrarMenu();

			switch (opcion) {
			case 1:
				menu.MatrículaAlumno(consulta);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 0:
				
				break;
			default:
				System.out.println("\n\t\tSolo números entre 0 y 7");
				break;
			}

		}

	}

}
