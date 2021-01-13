package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_servicios_basicos database table.
 * 
 */
@Entity
@Table(name="com_servicios_basicos")
@NamedQuery(name="ComServiciosBasico.findAll", query="SELECT c FROM ComServiciosBasico c")
public class ComServiciosBasico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_SERVICIOS_BASICOS_ID_GENERATOR", sequenceName="SEQ_COM_SERVICIOS_BASICOS", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_SERVICIOS_BASICOS_ID_GENERATOR")
	private Integer id;

	private Integer estado;

	private String nombre;

	//bi-directional many-to-one association to ComPredioServiciosBasico
	@OneToMany(mappedBy="comServiciosBasico")
	private List<ComPredioServiciosBasico> comPredioServiciosBasicos;

	public ComServiciosBasico() {
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

	public List<ComPredioServiciosBasico> getComPredioServiciosBasicos() {
		return this.comPredioServiciosBasicos;
	}

	public void setComPredioServiciosBasicos(List<ComPredioServiciosBasico> comPredioServiciosBasicos) {
		this.comPredioServiciosBasicos = comPredioServiciosBasicos;
	}

	public ComPredioServiciosBasico addComPredioServiciosBasico(ComPredioServiciosBasico comPredioServiciosBasico) {
		getComPredioServiciosBasicos().add(comPredioServiciosBasico);
		comPredioServiciosBasico.setComServiciosBasico(this);

		return comPredioServiciosBasico;
	}

	public ComPredioServiciosBasico removeComPredioServiciosBasico(ComPredioServiciosBasico comPredioServiciosBasico) {
		getComPredioServiciosBasicos().remove(comPredioServiciosBasico);
		comPredioServiciosBasico.setComServiciosBasico(null);

		return comPredioServiciosBasico;
	}

}