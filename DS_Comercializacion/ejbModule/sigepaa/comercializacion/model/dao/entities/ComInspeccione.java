package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_inspecciones database table.
 * 
 */
@Entity
@Table(name="com_inspecciones")
@NamedQuery(name="ComInspeccione.findAll", query="SELECT c FROM ComInspeccione c")
public class ComInspeccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_INSPECCIONES_ID_GENERATOR", sequenceName="SEQ_COM_INSPECCIONES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_INSPECCIONES_ID_GENERATOR")
	private Integer id;

	private String conclusion;

	private String estado;

	private String tipo;

	//bi-directional many-to-one association to ComMedidor
	@ManyToOne
	@JoinColumn(name="id_medidor")
	private ComMedidor comMedidor;

	//bi-directional many-to-one association to ComVisita
	@ManyToOne
	@JoinColumn(name="id_registro_visitas")
	private ComVisita comVisita;

	public ComInspeccione() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConclusion() {
		return this.conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ComMedidor getComMedidor() {
		return this.comMedidor;
	}

	public void setComMedidor(ComMedidor comMedidor) {
		this.comMedidor = comMedidor;
	}

	public ComVisita getComVisita() {
		return this.comVisita;
	}

	public void setComVisita(ComVisita comVisita) {
		this.comVisita = comVisita;
	}

}