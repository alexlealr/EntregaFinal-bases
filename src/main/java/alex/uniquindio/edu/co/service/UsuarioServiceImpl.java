package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.uniquindio.edu.co.entity.Usuario;
import alex.uniquindio.edu.co.repository.UsuarioRepository;

/**
 * Clase que implementa los metodos del crud de usuario
 * @author alexander leal
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{


	/*
	 * Repositorio de usuario
	 */
	@Autowired
	UsuarioRepository repository;
	
	/**
	 * Permite recorrer todos los datos almacenados en usuario
	 * @return
	 */
	@Override
	public Iterable<Usuario> getAllUsers() {
		return repository.findAll();
	}
	
	/**
	 * Permite verificar si el codigo del usuario existe en la base de datos
	 * @param asig objeto usuarios
	 * @return
	 * @throws Exception
	 */
	private boolean checkCodigoExist(Usuario asig) throws Exception {
		Optional<Usuario> asignaturaFound = repository.findByIdentificacion(asig.getIdentificacion());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	/**
	 * Permite crear un usuario
	 * param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	@Override
	public Usuario createUsuario(Usuario asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	/**
	 * Permite obtener un usuario por el id
	 * @param id del usuario
	 * @return
	 * @throws Exception
	 */
	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	/**
	 * permite actualizar un usuario
	 * @param asig objeto usuario
	 * @return
	 * @throws Exception
	 */
	@Override
	public Usuario updateUsuario(Usuario fromUser) throws Exception {
		Usuario toUsuario = getUsuarioById(fromUser.getUsuarioId());
		mapUsuario(fromUser, toUsuario);
		return repository.save(toUsuario);
	}
	
	protected void mapUsuario(Usuario from,Usuario to) {
		to.setIdentificacion(from.getIdentificacion());
		
	}

	/**
	 * Permite eliminar una usuario por su id
	 * @param id del usuario
	 * @throws Exception
	 */
	@Override
	public void deleteUsuario(Long id) throws Exception {
		Usuario asig = repository.findById(id).orElseThrow(() -> new Exception("Asignatura no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}

}
