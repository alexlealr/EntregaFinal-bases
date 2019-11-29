package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Encuesta;

public interface EncuestaService {

	/**
	 * Permite recorrer todos los datos almacenados en usuario
	 * @return
	 */
	public Iterable<Encuesta> getAllUsers();

	/**
	 * Permite crear un usuario
	 * param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Encuesta createEncuesta(Encuesta asig) throws Exception;

	/**
	 * Permite obtener un usuario por el id
	 * @param id del usuario
	 * @return
	 * @throws Exception
	 */
	public Encuesta getEncuestaById(Long id) throws Exception;

	/**
	 * permite actualizar un usuario
	 * @param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Encuesta updateEncuesta(Encuesta asig) throws Exception;
 

	/**
	 * Permite eliminar una usuario por su id
	 * @param id del usuario
	 * @throws Exception
	 */
	public void deleteEncuesta(Long id) throws Exception;

	
}
