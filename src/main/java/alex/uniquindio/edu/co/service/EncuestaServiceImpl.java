package alex.uniquindio.edu.co.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alex.uniquindio.edu.co.entity.Encuesta;
import alex.uniquindio.edu.co.repository.EncuestaRepository;

@Service
public class EncuestaServiceImpl implements EncuestaService{

	@Autowired
	EncuestaRepository repository;
	
	@Override
	public Iterable<Encuesta> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkCodigoExist(Encuesta asig) throws Exception {
	//	Optional<Encuesta> asignaturaFound = repository.findByCodigo(asig.getEncuestaId());
		//if (asignaturaFound.isPresent()) {
			//throw new Exception("Codigo no disponible");
	//	}
		return true;	
	}
	@Override
	public Encuesta createEncuesta(Encuesta asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}

	@Override
	public Encuesta getEncuestaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El usuario para editar no existe."));
	}

	@Override
	public Encuesta updateEncuesta(Encuesta asig) throws Exception {
		Encuesta toUsuario = getEncuestaById(asig.getEncuestaId());
		mapEncuesta(asig, toUsuario);
		return repository.save(toUsuario);
	}
	protected void mapEncuesta(Encuesta from,Encuesta to) {
		to.setEncuestaId(from.getEncuestaId());
		to.setNombre(from.getNombre());
		to.setTipo(from.getTipo());
		to.setObjetivo(from.getObjetivo());
		to.setCantperson(from.getCantperson());
		to.setDescripcion(from.getDescripcion());
		to.setFechaFin(from.getFechaFin());
		to.setFechaInicio(from.getFechaInicio());
		to.setGenero(from.getGenero());
	}

	@Override
	public void deleteEncuesta(Long id) throws Exception {
		Encuesta asig = repository.findById(id).orElseThrow(() -> new Exception("Encuesta no encontrada -"+this.getClass().getName()));
		repository.delete(asig);
	}

}
