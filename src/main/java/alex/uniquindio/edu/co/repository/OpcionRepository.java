package alex.uniquindio.edu.co.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Opcion;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Long>{

}
