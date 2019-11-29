package alex.uniquindio.edu.co.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRUPOSENC database table.
 * 
 */
@Entity
@Table(name="GRUPOSENC")
@NamedQuery(name="Gruposenc.findAll", query="SELECT g FROM Gruposenc g")
public class Gruposenc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRUPOSENC_GRUPOID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPOSENC_GRUPOID_GENERATOR")
	@Column(name="GRUPO_ID", unique=true, nullable=false, precision=19)
	private long grupoId;

	@Column(length=255)
	private String tema;

	//bi-directional many-to-one association to Encuesta
	@OneToMany(mappedBy="gruposenc")
	private List<Encuesta> encuestas;

	public Gruposenc() {
	}

	public long getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(long grupoId) {
		this.grupoId = grupoId;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<Encuesta> getEncuestas() {
		return this.encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	public Encuesta addEncuesta(Encuesta encuesta) {
		getEncuestas().add(encuesta);
		encuesta.setGruposenc(this);

		return encuesta;
	}

	public Encuesta removeEncuesta(Encuesta encuesta) {
		getEncuestas().remove(encuesta);
		encuesta.setGruposenc(null);

		return encuesta;
	}

}