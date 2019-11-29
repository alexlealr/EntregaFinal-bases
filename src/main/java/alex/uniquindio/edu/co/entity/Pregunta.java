package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PREGUNTA database table.
 * 
 */
@Entity
@Table(name="PREGUNTA")
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PREGUNTA_PREGUNTAID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREGUNTA_PREGUNTAID_GENERATOR")
	@Column(name="PREGUNTA_ID", unique=true, nullable=false, precision=19)
	private long preguntaId;

	@Column(length=255)
	private String pregunta;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="pregunta")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PREGUNTA_PREGUNTA_ID")
	private Pregunta preguntaBean;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="preguntaBean")
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to PreguntaEncuesta
	@OneToMany(mappedBy="pregunta")
	private List<PreguntaEncuesta> preguntaEncuestas;

	public Pregunta() {
	}

	public long getPreguntaId() {
		return this.preguntaId;
	}

	public void setPreguntaId(long preguntaId) {
		this.preguntaId = preguntaId;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setPregunta(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setPregunta(null);

		return opcion;
	}

	public Pregunta getPreguntaBean() {
		return this.preguntaBean;
	}

	public void setPreguntaBean(Pregunta preguntaBean) {
		this.preguntaBean = preguntaBean;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setPreguntaBean(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setPreguntaBean(null);

		return pregunta;
	}

	public List<PreguntaEncuesta> getPreguntaEncuestas() {
		return this.preguntaEncuestas;
	}

	public void setPreguntaEncuestas(List<PreguntaEncuesta> preguntaEncuestas) {
		this.preguntaEncuestas = preguntaEncuestas;
	}

	public PreguntaEncuesta addPreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
		getPreguntaEncuestas().add(preguntaEncuesta);
		preguntaEncuesta.setPregunta(this);

		return preguntaEncuesta;
	}

	public PreguntaEncuesta removePreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
		getPreguntaEncuestas().remove(preguntaEncuesta);
		preguntaEncuesta.setPregunta(null);

		return preguntaEncuesta;
	}

}