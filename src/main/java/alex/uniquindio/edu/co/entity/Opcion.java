package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OPCION database table.
 * 
 */
@Entity
@Table(name="OPCION")
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPCION_OPCIONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPCION_OPCIONID_GENERATOR")
	@Column(name="OPCION_ID", unique=true, nullable=false, precision=19)
	private long opcionId;

	@Column(length=255)
	private String respuesta;

	@Column(length=255)
	private String tiporespuesta;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PREGUNTA_PREGUNTA_ID")
	private Pregunta pregunta;

	//bi-directional many-to-one association to RespuestaUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESPUESTA_USUARIO_RESPUESTA_ID")
	private RespuestaUsuario respuestaUsuario;

	//bi-directional many-to-one association to PreguntaEncuesta
	@OneToMany(mappedBy="opcion")
	private List<PreguntaEncuesta> preguntaEncuestas;

	public Opcion() {
	}

	public long getOpcionId() {
		return this.opcionId;
	}

	public void setOpcionId(long opcionId) {
		this.opcionId = opcionId;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getTiporespuesta() {
		return this.tiporespuesta;
	}

	public void setTiporespuesta(String tiporespuesta) {
		this.tiporespuesta = tiporespuesta;
	}

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public RespuestaUsuario getRespuestaUsuario() {
		return this.respuestaUsuario;
	}

	public void setRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
		this.respuestaUsuario = respuestaUsuario;
	}

	public List<PreguntaEncuesta> getPreguntaEncuestas() {
		return this.preguntaEncuestas;
	}

	public void setPreguntaEncuestas(List<PreguntaEncuesta> preguntaEncuestas) {
		this.preguntaEncuestas = preguntaEncuestas;
	}

	public PreguntaEncuesta addPreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
		getPreguntaEncuestas().add(preguntaEncuesta);
		preguntaEncuesta.setOpcion(this);

		return preguntaEncuesta;
	}

	public PreguntaEncuesta removePreguntaEncuesta(PreguntaEncuesta preguntaEncuesta) {
		getPreguntaEncuestas().remove(preguntaEncuesta);
		preguntaEncuesta.setOpcion(null);

		return preguntaEncuesta;
	}

}