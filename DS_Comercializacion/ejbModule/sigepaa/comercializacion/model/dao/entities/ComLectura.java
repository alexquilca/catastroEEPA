package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_lectura database table.
 * 
 */
@Entity
@Table(name="com_lectura")
@NamedQuery(name="ComLectura.findAll", query="SELECT c FROM ComLectura c")
public class ComLectura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_LECTURA_ID_GENERATOR", sequenceName="SEQ_COM_LECTURA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_LECTURA_ID_GENERATOR")
	private Integer id;

	private Integer anio;

	private Integer consumo;

	@Column(name="lectura_actual")
	private Integer lecturaActual;

	@Column(name="lectura_anterior")
	private Integer lecturaAnterior;

	private Integer mes;

	//bi-directional many-to-one association to ComMedidor
	@ManyToOne
	@JoinColumn(name="id_medidor")
	private ComMedidor comMedidor;

	//bi-directional many-to-one association to ComVisita
	@ManyToOne
	@JoinColumn(name="id_registro_visitas")
	private ComVisita comVisita;

	public ComLectura() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getConsumo() {
		return this.consumo;
	}

	public void setConsumo(Integer consumo) {
		this.consumo = consumo;
	}

	public Integer getLecturaActual() {
		return this.lecturaActual;
	}

	public void setLecturaActual(Integer lecturaActual) {
		this.lecturaActual = lecturaActual;
	}

	public Integer getLecturaAnterior() {
		return this.lecturaAnterior;
	}

	public void setLecturaAnterior(Integer lecturaAnterior) {
		this.lecturaAnterior = lecturaAnterior;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
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