/**
 * 
 */
package edu.gestionMaterial.dal;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Talamino
 * 
 *         DAO para la entidad dlk_tch_Portatil
 */

@Entity
@Table(name = "dlk_tch_Portatil", schema = "dlk_gestionMaterial")
public class PortatilDAO {

	// Propiedades
	@Column(name = "md_uuid", nullable = false)
	String md_uuid;

	@Column(name = "md_fch", nullable = false)
	@Temporal(TemporalType.DATE)
	Calendar md_fch;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_portatil", nullable = false)
	int id_portatil;
	
	@Column(name = "marca", nullable = false)
	String marca;
	
	@Column(name = "modelo", nullable = false)
	String modelo;
	
	@OneToOne(mappedBy ="portatilDAO")
    AlumnoDAO alumnoDAO;
	
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


}
