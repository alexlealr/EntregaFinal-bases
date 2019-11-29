package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIO_TEM_INTERES database table.
 * 
 */
@Entity
@Table(name="USUARIO_TEM_INTERES")
@NamedQuery(name="UsuarioTemIntere.findAll", query="SELECT u FROM UsuarioTemIntere u")
public class UsuarioTemIntere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_TEM_INTERES_USERTEMINTEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_TEM_INTERES_USERTEMINTEID_GENERATOR")
	@Column(name="USER_TEM_INTE_ID", unique=true, nullable=false, precision=19)
	private long userTemInteId;

	//bi-directional many-to-one association to TemaIntere
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEMA_INTERES_TEMA_ID")
	private TemaIntere temaIntere;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIO_USUARIO_ID")
	private Usuario usuario;

	public UsuarioTemIntere() {
	}

	public long getUserTemInteId() {
		return this.userTemInteId;
	}

	public void setUserTemInteId(long userTemInteId) {
		this.userTemInteId = userTemInteId;
	}

	public TemaIntere getTemaIntere() {
		return this.temaIntere;
	}

	public void setTemaIntere(TemaIntere temaIntere) {
		this.temaIntere = temaIntere;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}