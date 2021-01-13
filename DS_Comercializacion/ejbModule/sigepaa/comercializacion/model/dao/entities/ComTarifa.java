package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_tarifa database table.
 * 
 */
@Entity
@Table(name="com_tarifa")
@NamedQuery(name="ComTarifa.findAll", query="SELECT c FROM ComTarifa c")
public class ComTarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_TARIFA_ID_GENERATOR", sequenceName="SEQ_COM_TARIFA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_TARIFA_ID_GENERATOR")
	private Integer id;

	private Integer estado;

	private String nombre;

	//bi-directional many-to-one association to ComAcometida
	@OneToMany(mappedBy="comTarifa")
	private List<ComAcometida> comAcometidas;

	public ComTarifa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ComAcometida> getComAcometidas() {
		return this.comAcometidas;
	}

	public void setComAcometidas(List<ComAcometida> comAcometidas) {
		this.comAcometidas = comAcometidas;
	}

	public ComAcometida addComAcometida(ComAcometida comAcometida) {
		getComAcometidas().add(comAcometida);
		comAcometida.setComTarifa(this);

		return comAcometida;
	}

	public ComAcometida removeComAcometida(ComAcometida comAcometida) {
		getComAcometidas().remove(comAcometida);
		comAcometida.setComTarifa(null);

		return comAcometida;
	}

}