package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_acometida database table.
 * 
 */
@Entity
@Table(name="com_acometida")
@NamedQuery(name="ComAcometida.findAll", query="SELECT c FROM ComAcometida c")
public class ComAcometida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_ACOMETIDA_ID_GENERATOR", sequenceName="SEQ_COM_ACOMETIDA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_ACOMETIDA_ID_GENERATOR")
	private Integer id;

	private String barrio;

	private Integer cuenta;

	private String parroquia;

	private Integer sector;

	//bi-directional many-to-one association to ComPredio
	@ManyToOne
	@JoinColumn(name="id_predio")
	private ComPredio comPredio;

	//bi-directional many-to-one association to ComTarifa
	@ManyToOne
	@JoinColumn(name="id_tarifa")
	private ComTarifa comTarifa;

	//bi-directional many-to-one association to ComMedidor
	@OneToMany(mappedBy="comAcometida")
	private List<ComMedidor> comMedidors;

	public ComAcometida() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Integer getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public Integer getSector() {
		return this.sector;
	}

	public void setSector(Integer sector) {
		this.sector = sector;
	}

	public ComPredio getComPredio() {
		return this.comPredio;
	}

	public void setComPredio(ComPredio comPredio) {
		this.comPredio = comPredio;
	}

	public ComTarifa getComTarifa() {
		return this.comTarifa;
	}

	public void setComTarifa(ComTarifa comTarifa) {
		this.comTarifa = comTarifa;
	}

	public List<ComMedidor> getComMedidors() {
		return this.comMedidors;
	}

	public void setComMedidors(List<ComMedidor> comMedidors) {
		this.comMedidors = comMedidors;
	}

	public ComMedidor addComMedidor(ComMedidor comMedidor) {
		getComMedidors().add(comMedidor);
		comMedidor.setComAcometida(this);

		return comMedidor;
	}

	public ComMedidor removeComMedidor(ComMedidor comMedidor) {
		getComMedidors().remove(comMedidor);
		comMedidor.setComAcometida(null);

		return comMedidor;
	}

}