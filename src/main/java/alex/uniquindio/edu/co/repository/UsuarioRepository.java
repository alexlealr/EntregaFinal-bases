package alex.uniquindio.edu.co.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alex.uniquindio.edu.co.entity.Usuario;

/**
 * Interfaz que propporciona operaciones basicas de un crud para la
 * entidad de usuario
 * @author alexander leal
 *
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByIdentificacion(String identificacion);


}
