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
 *         DAO para la entidad dlk_tch_Alumno
 */

@Entity
@Table(name = "dlk_tch_Alumno", schema = "dlk_gestionMaterial")
public class AlumnoDAO {

	// Propiedades
	@Column(name = "md_uuid", nullable = false)
	String md_uuid;

	@Column(name = "md_fch", nullable = false)
	@Temporal(TemporalType.DATE)
	Calendar md_fch;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno", nullable = false)
	int id_alumno;

	@Column(name = "nombre", nullable = false)
	String nombre;

	@Column(name = "tlf", nullable = false)
	String tlf;

	@OneToOne
	PortatilDAO portatilDAO;

	// GETTERS AND SETTERS
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

}
