package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_USUARIOID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_USUARIOID_GENERATOR")
	@Column(name="USUARIO_ID", unique=true, nullable=false, precision=19)
	private long usuarioId;

	@Column(length=255)
	private String direccion;

	@Column(precision=19, scale=2)
	private BigDecimal edad;

	@Column(name="ESTADO_CIVIL", length=255)
	private String estadoCivil;

	@Column(length=255)
	private String genero;

	@Column(length=255)
	private String identificacion;

	@Column(length=255)
	private String nacionalidad;

	@Column(length=255)
	private String nombre;

	@Column(length=255)
	private String ocupacion;

	@Column(length=255)
	private String password;

	@Column(length=100)
	private String rol;

	@Column(length=255)
	private String usuario;

	//bi-directional many-to-one association to EncuestaUsuario
	@OneToMany(mappedBy="usuario")
	private List<EncuestaUsuario> encuestaUsuarios;

	//bi-directional many-to-one association to RespuestaUsuario
	@OneToMany(mappedBy="usuario")
	private List<RespuestaUsuario> respuestaUsuarios;

	//bi-directional many-to-one association to UsuarioTemIntere
	@OneToMany(mappedBy="usuario")
	private List<UsuarioTemIntere> usuarioTemInteres;

	public Usuario() {
	}

	public long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getEdad() {
		return this.edad;
	}

	public void setEdad(BigDecimal edad) {
		this.edad = edad;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<EncuestaUsuario> getEncuestaUsuarios() {
		return this.encuestaUsuarios;
	}

	public void setEncuestaUsuarios(List<EncuestaUsuario> encuestaUsuarios) {
		this.encuestaUsuarios = encuestaUsuarios;
	}

	public EncuestaUsuario addEncuestaUsuario(EncuestaUsuario encuestaUsuario) {
		getEncuestaUsuarios().add(encuestaUsuario);
		encuestaUsuario.setUsuario(this);

		return encuestaUsuario;
	}

	public EncuestaUsuario removeEncuestaUsuario(EncuestaUsuario encuestaUsuario) {
		getEncuestaUsuarios().remove(encuestaUsuario);
		encuestaUsuario.setUsuario(null);

		return encuestaUsuario;
	}

	public List<RespuestaUsuario> getRespuestaUsuarios() {
		return this.respuestaUsuarios;
	}

	public void setRespuestaUsuarios(List<RespuestaUsuario> respuestaUsuarios) {
		this.respuestaUsuarios = respuestaUsuarios;
	}

	public RespuestaUsuario addRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
		getRespuestaUsuarios().add(respuestaUsuario);
		respuestaUsuario.setUsuario(this);

		return respuestaUsuario;
	}

	public RespuestaUsuario removeRespuestaUsuario(RespuestaUsuario respuestaUsuario) {
		getRespuestaUsuarios().remove(respuestaUsuario);
		respuestaUsuario.setUsuario(null);

		return respuestaUsuario;
	}

	public List<UsuarioTemIntere> getUsuarioTemInteres() {
		return this.usuarioTemInteres;
	}

	public void setUsuarioTemInteres(List<UsuarioTemIntere> usuarioTemInteres) {
		this.usuarioTemInteres = usuarioTemInteres;
	}

	public UsuarioTemIntere addUsuarioTemIntere(UsuarioTemIntere usuarioTemIntere) {
		getUsuarioTemInteres().add(usuarioTemIntere);
		usuarioTemIntere.setUsuario(this);

		return usuarioTemIntere;
	}

	public UsuarioTemIntere removeUsuarioTemIntere(UsuarioTemIntere usuarioTemIntere) {
		getUsuarioTemInteres().remove(usuarioTemIntere);
		usuarioTemIntere.setUsuario(null);

		return usuarioTemIntere;
	}

}