package alex.uniquindio.edu.co.service;

import alex.uniquindio.edu.co.entity.Opcion;

public interface OpcionService {

	/**
	 * Permite recorrer todos los datos almacenados en usuario
	 * @return
	 */
	public Iterable<Opcion> getAllUsers();

	/**
	 * Permite crear un usuario
	 * param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Opcion createOpcion(Opcion asig) throws Exception;

	/**
	 * Permite obtener un usuario por el id
	 * @param id del usuario
	 * @return
	 * @throws Exception
	 */
	public Opcion getOpcionById(Long id) throws Exception;

	/**
	 * permite actualizar un usuario
	 * @param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	public Opcion updateOpcion(Opcion asig) throws Exception;
 

	/**
	 * Permite eliminar una usuario por su id
	 * @param id del usuario
	 * @throws Exception
	 */
	public void deleteOpcion(Long id) throws Exception;
}
