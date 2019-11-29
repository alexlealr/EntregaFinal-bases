/**
 * 
 */
package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Encuesta;


/**
 * @author PERSONAL
 *
 */
@Repository
public interface EncuestaRepository extends CrudRepository<Encuesta, Long>{
	
	//public Optional<Encuesta> findByCodigo(Long id);

}