package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEMASINT_ENCUESTA database table.
 * 
 */
@Entity
@Table(name="TEMASINT_ENCUESTA")
@NamedQuery(name="TemasintEncuesta.findAll", query="SELECT t FROM TemasintEncuesta t")
public class TemasintEncuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMASINT_ENCUESTA_TEMINTENCUESTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMASINT_ENCUESTA_TEMINTENCUESTID_GENERATOR")
	@Column(name="TEMINT_ENCUEST_ID", unique=true, nullable=false, precision=19)
	private long temintEncuestId;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ENCUESTA_ENCUESTA_ID")
	private Encuesta encuesta;

	//bi-directional many-to-one association to TemaIntere
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEMA_INTERES_TEMA_ID")
	private TemaIntere temaIntere;

	public TemasintEncuesta() {
	}

	public long getTemintEncuestId() {
		return this.temintEncuestId;
	}

	public void setTemintEncuestId(long temintEncuestId) {
		this.temintEncuestId = temintEncuestId;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public TemaIntere getTemaIntere() {
		return this.temaIntere;
	}

	public void setTemaIntere(TemaIntere temaIntere) {
		this.temaIntere = temaIntere;
	}

}