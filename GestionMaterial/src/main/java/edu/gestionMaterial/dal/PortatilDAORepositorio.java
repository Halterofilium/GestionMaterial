/**
 * 
 */
package edu.gestionMaterial.dal;

import java.util.List;

/**
 * @author Talamino
 *
 * Interfaz que actúa sobre PortatilDAO
 * Tan solo se define la signatura de los métodos que actuarán sobre
 * PortatilDAORepositorio, la implementación se define en PortatilDAORepositorioImpl
 */
public interface PortatilDAORepositorio {

	/**
	 * Método que trae todos los registros de la tabla dlk_tch_Portatil
	 * @return List<PortatilDAO>
	 * @throws Exception 
	 */
	public List<PortatilDAO> select() throws Exception;
	
	/**
	 * Método que inserta un nuevo repostage en base de datos.
	 * @param portatilDAO
	 * @throws Exception 
	 */
	public void insert(PortatilDAO portatilDAO) throws Exception;
	
	/**
	 * Método que actualiza un repostage en base de datos.
	 * @param portatilDAO
	 * @throws Exception 
	 */
	public void update(PortatilDAO portatilDAO) throws Exception;
	
	/**
	 * Método que elimina un repostage en base de datos.
	 * @param portatilDAO
	 * @throws Exception 
	 */
	public void delete(PortatilDAO portatilDAO) throws Exception;
	
	/**
	 * Método que devuelve un registro especifico de BBDD.
	 * @param id
	 * @return List<PortatilDAO>
	 * @throws Exception 
	 */
	public List<PortatilDAO> where(int id) throws Exception;
	
}
