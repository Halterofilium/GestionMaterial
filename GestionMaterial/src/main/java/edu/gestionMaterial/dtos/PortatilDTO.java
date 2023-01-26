/**
 * 
 */
package edu.gestionMaterial.dtos;

import java.util.Calendar;


import edu.gestionMaterial.dal.AlumnoDAO;

/**
 * @author Talamino
 * Clase que contiene en forma de DTO la entidad dlk_tch_Portatil
 */
public class PortatilDTO {

	// Propiedades
	String md_uuid;
	Calendar md_fch;
	int id_portatil;
	String marca;
	String modelo;
    AlumnoDAO alumnoDAO;
	
 
    //Constructores
    
    /**
     * Constructor Normal
	 * @param md_uuid
	 * @param md_fch
	 * @param id_portatil
	 * @param marca
	 * @param modelo
	 * @param alumnoDAO
	 */
	public PortatilDTO(String marca, String modelo, AlumnoDAO alumnoDAO) {
		super();
		this.md_uuid = RandomValue();
		this.md_fch = Calendar.getInstance();
		this.marca = marca;
		this.modelo = modelo;
		this.alumnoDAO = alumnoDAO;
	}
	
	/**
	 * Constructor Vacío
	 */
	public PortatilDTO() {
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
	public int getId_portatil() {
		return id_portatil;
	}
	public void setId_portatil(int id_portatil) {
		this.id_portatil = id_portatil;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public AlumnoDAO getAlumnoDAO() {
		return alumnoDAO;
	}
	public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
		this.alumnoDAO = alumnoDAO;
	}


	//ToString metodo que hace legible a la clase
    @Override
	public String toString() {
		return "PortatilDTO [md_uuid=" + md_uuid + ", md_fch=" + md_fch + ", id_portatil=" + id_portatil + ", marca="
				+ marca + ", modelo=" + modelo + ", alumnoDAO=" + alumnoDAO + "]";
	}
    
    
    //Método que genera un valor aleatorio para el campo MdUuid       
    String RandomValue()
    {
    	int random = (int)Math.floor(Math.random()*10+1);
        return ("AS" + random);
    }

}
