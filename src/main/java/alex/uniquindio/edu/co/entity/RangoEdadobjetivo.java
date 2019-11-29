package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RANGO_EDADOBJETIVO database table.
 * 
 */
@Entity
@Table(name="RANGO_EDADOBJETIVO")
@NamedQuery(name="RangoEdadobjetivo.findAll", query="SELECT r FROM RangoEdadobjetivo r")
public class RangoEdadobjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RANGO_EDADOBJETIVO_RANGOEDID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RANGO_EDADOBJETIVO_RANGOEDID_GENERATOR")
	@Column(name="RANGOED_ID", unique=true, nullable=false, precision=19, scale=2)
	private long rangoedId;

	@Column(precision=19, scale=2)
	private BigDecimal rangofin;

	@Column(precision=19, scale=2)
	private BigDecimal rangoini;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ENCUESTA_ENCUESTA_ID")
	private Encuesta encuesta;

	public RangoEdadobjetivo() {
	}

	public long getRangoedId() {
		return this.rangoedId;
	}

	public void setRangoedId(long rangoedId) {
		this.rangoedId = rangoedId;
	}

	public BigDecimal getRangofin() {
		return this.rangofin;
	}

	public void setRangofin(BigDecimal rangofin) {
		this.rangofin = rangofin;
	}

	public BigDecimal getRangoini() {
		return this.rangoini;
	}

	public void setRangoini(BigDecimal rangoini) {
		this.rangoini = rangoini;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

}