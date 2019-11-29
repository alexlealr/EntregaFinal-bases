package alex.uniquindio.edu.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Encuesta;
import alex.uniquindio.edu.co.entity.Opcion;
import alex.uniquindio.edu.co.repository.EncuestaRepository;
import alex.uniquindio.edu.co.repository.OpcionRepository;

@Service
public class OpcionServiceImpl  implements OpcionService{

	@Autowired
	OpcionRepository repository;
	
	@Override
	public Iterable<Opcion> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkCodigoExist(Opcion asig) throws Exception {
	//	Optional<Encuesta> asignaturaFound = repository.findByCodigo(asig.getEncuestaId());
		//if (asignaturaFound.isPresent()) {
			//throw new Exception("Codigo no disponible");
	//	}
		return true;	
	}
	@Override
	public Opcion createOpcion(Opcion asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Opcion getOpcionById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Opcion updateOpcion(Opcion asig) throws Exception {
		Opcion toUsuario = getOpcionById(asig.getOpcionId());
		mapOpcion(asig, toUsuario);
		return repository.save(toUsuario);
	}
	protected void mapOpcion(Opcion from,Opcion to) {
		to.setOpcionId(from.getOpcionId());
		to.setRespuesta(from.getRespuesta());
		
	}

	@Override
	public void deleteOpcion(Long id) throws Exception {
		//Encuesta asig = repository.findById(id).orElseThrow(() -> new Exception("Asignatura no encontrada -"+this.getClass().getName()));
		//srepository.delete(asig);
	}

}

