/**
 * 
 */
package alex.uniquindio.edu.co.service;


import alex.uniquindio.edu.co.entity.Pregunta;
/**
 * @author PERSONAL
 *
 */

public interface PreguntaService{

	public Iterable<Pregunta> getAllUsers();
	
	public Pregunta createPregunta(Pregunta asig) throws Exception;
	
	public Pregunta getPreguntaById(Long id) throws Exception;

	public Pregunta updatePregunta(Pregunta asig) throws Exception;
		
	public void deletePregunta(Long id) throws Exception;
	
}

