package alex.uniquindio.edu.co.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import alex.uniquindio.edu.co.entity.PreguntaEncuesta;

@Repository
public interface PreguntaEncuestaRepository  extends CrudRepository<PreguntaEncuesta, Long>{

}
