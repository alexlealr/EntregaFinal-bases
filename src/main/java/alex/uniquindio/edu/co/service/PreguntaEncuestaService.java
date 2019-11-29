package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Opcion;
import alex.uniquindio.edu.co.entity.PreguntaEncuesta;

public interface PreguntaEncuestaService {

	
	/**
	 * Permite recorrer todos los datos almacenados en usuario
	 * @return
	 */
	public Iterable<PreguntaEncuesta> getAllUsers();

	/**
	 * Permite crear un usuario
	 * param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public PreguntaEncuesta createPreguntaEncuesta(PreguntaEncuesta asig) throws Exception;

	/**
	 * Permite obtener un usuario por el id
	 * @param id del usuario
	 * @return
	 * @throws Exception
	 */
	public PreguntaEncuesta getPreguntaEncuestaById(Long id) throws Exception;

	/**
	 * permite actualizar un usuario
	 * @param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public PreguntaEncuesta updatePreguntaEncuesta(PreguntaEncuesta asig) throws Exception;
 

	/**
	 * Permite eliminar una usuario por su id
	 * @param id del usuario
	 * @throws Exception
	 */
	public void deletePreguntaEncuesta(Long id) throws Exception;
}

