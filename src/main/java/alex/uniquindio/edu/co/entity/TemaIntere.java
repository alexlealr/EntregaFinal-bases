package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEMA_INTERES database table.
 * 
 */
@Entity
@Table(name="TEMA_INTERES")
@NamedQuery(name="TemaIntere.findAll", query="SELECT t FROM TemaIntere t")
public class TemaIntere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMA_INTERES_TEMAID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMA_INTERES_TEMAID_GENERATOR")
	@Column(name="TEMA_ID", unique=true, nullable=false, precision=19)
	private long temaId;

	@Column(length=255)
	private String descripcion;

	@Column(length=255)
	private String tema;

	//bi-directional many-to-one association to TemasintEncuesta
	@OneToMany(mappedBy="temaIntere")
	private List<TemasintEncuesta> temasintEncuestas;

	//bi-directional many-to-one association to TemaIntere
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEMA_INTERES_TEMA_ID")
	private TemaIntere temaIntere;

	//bi-directional many-to-one association to TemaIntere
	@OneToMany(mappedBy="temaIntere")
	private List<TemaIntere> temaInteres;

	//bi-directional many-to-one association to UsuarioTemIntere
	@OneToMany(mappedBy="temaIntere")
	private List<UsuarioTemIntere> usuarioTemInteres;

	public TemaIntere() {
	}

	public long getTemaId() {
		return this.temaId;
	}

	public void setTemaId(long temaId) {
		this.temaId = temaId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<TemasintEncuesta> getTemasintEncuestas() {
		return this.temasintEncuestas;
	}

	public void setTemasintEncuestas(List<TemasintEncuesta> temasintEncuestas) {
		this.temasintEncuestas = temasintEncuestas;
	}

	public TemasintEncuesta addTemasintEncuesta(TemasintEncuesta temasintEncuesta) {
		getTemasintEncuestas().add(temasintEncuesta);
		temasintEncuesta.setTemaIntere(this);

		return temasintEncuesta;
	}

	public TemasintEncuesta removeTemasintEncuesta(TemasintEncuesta temasintEncuesta) {
		getTemasintEncuestas().remove(temasintEncuesta);
		temasintEncuesta.setTemaIntere(null);

		return temasintEncuesta;
	}

	public TemaIntere getTemaIntere() {
		return this.temaIntere;
	}

	public void setTemaIntere(TemaIntere temaIntere) {
		this.temaIntere = temaIntere;
	}

	public List<TemaIntere> getTemaInteres() {
		return this.temaInteres;
	}

	public void setTemaInteres(List<TemaIntere> temaInteres) {
		this.temaInteres = temaInteres;
	}

	public TemaIntere addTemaIntere(TemaIntere temaIntere) {
		getTemaInteres().add(temaIntere);
		temaIntere.setTemaIntere(this);

		return temaIntere;
	}

	public TemaIntere removeTemaIntere(TemaIntere temaIntere) {
		getTemaInteres().remove(temaIntere);
		temaIntere.setTemaIntere(null);

		return temaIntere;
	}

	public List<UsuarioTemIntere> getUsuarioTemInteres() {
		return this.usuarioTemInteres;
	}

	public void setUsuarioTemInteres(List<UsuarioTemIntere> usuarioTemInteres) {
		this.usuarioTemInteres = usuarioTemInteres;
	}

	public UsuarioTemIntere addUsuarioTemIntere(UsuarioTemIntere usuarioTemIntere) {
		getUsuarioTemInteres().add(usuarioTemIntere);
		usuarioTemIntere.setTemaIntere(this);

		return usuarioTemIntere;
	}

	public UsuarioTemIntere removeUsuarioTemIntere(UsuarioTemIntere usuarioTemIntere) {
		getUsuarioTemInteres().remove(usuarioTemIntere);
		usuarioTemIntere.setTemaIntere(null);

		return usuarioTemIntere;
	}

}