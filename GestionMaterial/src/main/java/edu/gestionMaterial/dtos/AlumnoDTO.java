/**
 * 
 */
package edu.gestionMaterial.dtos;

import java.util.Calendar;


import edu.gestionMaterial.dal.PortatilDAO;

/**
 * @author Talamino
 * Clase que contiene en forma de DTO la entidad dlk_tch_Alumno
 */
public class AlumnoDTO {

	// Propiedades
	String md_uuid;
	Calendar md_fch;
	int id_alumno;
	String nombre;
	String tlf;
	PortatilDAO portatilDAO;

	
	//Constructores
	
	/**
	 * Constructor Normal
	 * @param md_uuid
	 * @param md_fch
	 * @param id_alumno
	 * @param nombre
	 * @param tlf
	 * @param portatilDAO
	 */
	public AlumnoDTO(String nombre, String tlf) {
		super();
		this.md_uuid = RandomValue();
		this.md_fch = Calendar.getInstance();;
		this.nombre = nombre;
		this.tlf = tlf;
		this.portatilDAO = new PortatilDAO();
	}
	
	/**
	 * Constructor Vacío
	 */
	public AlumnoDTO() {
		super();
	}


	//GETTERS AND SETTERS
	public String getMd_uuid() {
		return md_uuid;
	}
	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}
	public Calendar getMd_fch() {
		return md_fch;
	}
	public void setMd_fch(Calendar md_fch) {
		this.md_fch = md_fch;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public PortatilDAO getPortatilDAO() {
		return portatilDAO;
	}
	public void setPortatilDAO(PortatilDAO portatilDAO) {
		this.portatilDAO = portatilDAO;
	}

	
	//ToString metodo que hace legible a la clase
	@Override
	public String toString() {
		return "AlumnoDTO [md_uuid=" + md_uuid + ", md_fch=" + md_fch + ", id_alumno=" + id_alumno + ", nombre="
				+ nombre + ", tlf=" + tlf + ", portatilDAO=" + portatilDAO + "]";
	}

	
	//Método que genera un valor aleatorio para el campo MdUuid       
    String RandomValue()
    {
    	int random = (int)Math.floor(Math.random()*10+1);
        return ("AS" + random);
    }
    
}
