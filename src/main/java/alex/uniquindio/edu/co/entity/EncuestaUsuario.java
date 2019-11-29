package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ENCUESTA_USUARIO database table.
 * 
 */
@Entity
@Table(name="ENCUESTA_USUARIO")
@NamedQuery(name="EncuestaUsuario.findAll", query="SELECT e FROM EncuestaUsuario e")
public class EncuestaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENCUESTA_USUARIO_ENCUESTUSERID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENCUESTA_USUARIO_ENCUESTUSERID_GENERATOR")
	@Column(name="ENCUEST_USER_ID", unique=true, nullable=false, precision=19)
	private long encuestUserId;

	@Column(length=255)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	@Column(length=255)
	private String respuestaqueva;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ENCUESTA_ENCUESTA_ID")
	private Encuesta encuesta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_USUARIO_ID")
	private Usuario usuario;

	public EncuestaUsuario() {
	}

	public long getEncuestUserId() {
		return this.encuestUserId;
	}

	public void setEncuestUserId(long encuestUserId) {
		this.encuestUserId = encuestUserId;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getRespuestaqueva() {
		return this.respuestaqueva;
	}

	public void setRespuestaqueva(String respuestaqueva) {
		this.respuestaqueva = respuestaqueva;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}