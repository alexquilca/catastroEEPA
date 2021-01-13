package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_predio_servicios_basicos database table.
 * 
 */
@Entity
@Table(name="com_predio_servicios_basicos")
@NamedQuery(name="ComPredioServiciosBasico.findAll", query="SELECT c FROM ComPredioServiciosBasico c")
public class ComPredioServiciosBasico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_PREDIO_SERVICIOS_BASICOS_ID_GENERATOR", sequenceName="SEQ_COM_PREDIO_SERVICIOS_BASIC", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_PREDIO_SERVICIOS_BASICOS_ID_GENERATOR")
	private Integer id;

	//bi-directional many-to-one association to ComPredio
	@ManyToOne
	@JoinColumn(name="id_predio")
	private ComPredio comPredio;

	//bi-directional many-to-one association to ComServiciosBasico
	@ManyToOne
	@JoinColumn(name="id_servicios_basicos")
	private ComServiciosBasico comServiciosBasico;
	
	private Integer estado;

	public ComPredioServiciosBasico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ComPredio getComPredio() {
		return this.comPredio;
	}

	public void setComPredio(ComPredio comPredio) {
		this.comPredio = comPredio;
	}

	public ComServiciosBasico getComServiciosBasico() {
		return this.comServiciosBasico;
	}

	public void setComServiciosBasico(ComServiciosBasico comServiciosBasico) {
		this.comServiciosBasico = comServiciosBasico;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}