package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.uniquindio.edu.co.entity.Pregunta;
import alex.uniquindio.edu.co.repository.PreguntaRepository;

@Service
public class PreguntaServiceImpl implements PreguntaService{

	@Autowired
	PreguntaRepository repository;
	
	@Override
	public Iterable<Pregunta> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkCodigoExist(Pregunta asig) throws Exception {
		//Optional<Pregunta> asignaturaFound = repository.findByCodigo(asig.getPreguntaId());
		//if (asignaturaFound.isPresent()) {
			//throw new Exception("Codigo no disponible");
		//}
		return true;	
	}
	@Override
	public Pregunta createPregunta(Pregunta asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Pregunta getPreguntaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Pregunta updatePregunta(Pregunta asig) throws Exception {
		Pregunta toUsuario = getPreguntaById(asig.getPreguntaId());
		mapPregunta(asig, toUsuario);
		return repository.save(toUsuario);
	}
	protected void mapPregunta(Pregunta from,Pregunta to) {
		to.setPreguntaId(from.getPreguntaId());
		to.setPregunta(from.getPregunta());
		
	}

	@Override
	public void deletePregunta(Long id) throws Exception {
	//	Pregunta asig = repository.findByCodigo(id).orElseThrow(() -> new Exception("Pregunta no encontrada -"+this.getClass().getName()));
		//repository.delete(asig);
	}

}
