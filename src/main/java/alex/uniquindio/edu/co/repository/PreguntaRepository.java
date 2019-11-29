package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Pregunta;
@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Long>{
	
	
//	public Optional<Pregunta> findByCodigo(Long codigo);

}
