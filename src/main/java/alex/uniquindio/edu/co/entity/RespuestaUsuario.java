package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the RESPUESTA_USUARIO database table.
 * 
 */
@Entity
@Table(name="RESPUESTA_USUARIO")
@NamedQuery(name="RespuestaUsuario.findAll", query="SELECT r FROM RespuestaUsuario r")
public class RespuestaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPUESTA_USUARIO_RESPUESTAID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPUESTA_USUARIO_RESPUESTAID_GENERATOR")
	@Column(name="RESPUESTA_ID", unique=true, nullable=false, precision=19)
	private long respuestaId;

	@Column(length=255)
	private String genero;

	@Column(nullable=false, precision=19)
	private BigDecimal idu;

	@Column(length=255)
	private String nombreencuesta;

	@Column(length=255)
	private String nombreusuario;


	@Column(length=255)
	private String pregunta;

	@Column(length=255)
	private String respuesta;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="respuestaUsuario")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_USUARIO_ID")
	private Usuario usuario;

	public RespuestaUsuario() {
	}

	public long getRespuestaId() {
		return this.respuestaId;
	}

	public void setRespuestaId(long respuestaId) {
		this.respuestaId = respuestaId;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public BigDecimal getIdu() {
		return this.idu;
	}

	public void setIdu(BigDecimal idu) {
		this.idu = idu;
	}

	public String getNombreencuesta() {
		return this.nombreencuesta;
	}

	public void setNombreencuesta(String nombreencuesta) {
		this.nombreencuesta = nombreencuesta;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}


	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setRespuestaUsuario(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setRespuestaUsuario(null);

		return opcion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}