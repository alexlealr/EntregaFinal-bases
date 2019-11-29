package alex.uniquindio.edu.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.uniquindio.edu.co.entity.Opcion;
import alex.uniquindio.edu.co.entity.Pregunta;
import alex.uniquindio.edu.co.entity.PreguntaEncuesta;
import alex.uniquindio.edu.co.repository.OpcionRepository;
import alex.uniquindio.edu.co.repository.PreguntaEncuestaRepository;

@Service
public class PreguntaEncuestaServiceImpl implements PreguntaEncuestaService{

	
	@Autowired
	PreguntaEncuestaRepository repository;
	
	@Override
	public Iterable<PreguntaEncuesta> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkCodigoExist(PreguntaEncuesta asig) throws Exception {
	//	Optional<Encuesta> asignaturaFound = repository.findByCodigo(asig.getEncuestaId());
		//if (asignaturaFound.isPresent()) {
			//throw new Exception("Codigo no disponible");
	//	}
		return true;	
	}
	@Override
	public PreguntaEncuesta createPreguntaEncuesta(PreguntaEncuesta asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public PreguntaEncuesta getPreguntaEncuestaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("La pregunta encuesta para editar no existe."));
	}

	@Override
	public PreguntaEncuesta updatePreguntaEncuesta(PreguntaEncuesta asig) throws Exception {
		PreguntaEncuesta toUsuario = getPreguntaEncuestaById(asig.getPreguntaEncId());
		mapPreguntaEncuesta(asig, toUsuario);
		return repository.save(toUsuario);
	}
	protected void mapPreguntaEncuesta(PreguntaEncuesta from,PreguntaEncuesta to) {
		to.setPreguntaEncId(from.getPreguntaEncId());
		to.setPregunta(from.getPregunta());
		
	}

	@Override
	public void deletePreguntaEncuesta(Long id) throws Exception {
		//Encuesta asig = repository.findById(id).orElseThrow(() -> new Exception("Asignatura no encontrada -"+this.getClass().getName()));
		//srepository.delete(asig);
	
}
}
