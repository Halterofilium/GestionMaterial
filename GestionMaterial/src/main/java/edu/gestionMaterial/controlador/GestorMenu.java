/**
 * 
 */
package edu.gestionMaterial.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.gestionMaterial.impl.ConsultasServicio;

/**
 * @author Talamino
 * GestorMenu: Controlador de interacción con la aplicación.
 */

@Controller
public class GestorMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Contexto
		ApplicationContext context = new ClassPathXmlApplicationContext("contexto.xml");
		ConsultasServicio consulta = (ConsultasServicio) context.getBean(ConsultasServicio.class);

	}

}
