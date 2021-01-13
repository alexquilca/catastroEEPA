package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_tipo_visita database table.
 * 
 */
@Entity
@Table(name="com_tipo_visita")
@NamedQuery(name="ComTipoVisita.findAll", query="SELECT c FROM ComTipoVisita c")
public class ComTipoVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_TIPO_VISITA_ID_GENERATOR", sequenceName="SEQ_COM_TIPO_VISITA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_TIPO_VISITA_ID_GENERATOR")
	private Integer id;

	private Integer estado;

	private String nombre;

	//bi-directional many-to-one association to ComVisita
	@OneToMany(mappedBy="comTipoVisita")
	private List<ComVisita> comVisitas;

	public ComTipoVisita() {
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

	public List<ComVisita> getComVisitas() {
		return this.comVisitas;
	}

	public void setComVisitas(List<ComVisita> comVisitas) {
		this.comVisitas = comVisitas;
	}

	public ComVisita addComVisita(ComVisita comVisita) {
		getComVisitas().add(comVisita);
		comVisita.setComTipoVisita(this);

		return comVisita;
	}

	public ComVisita removeComVisita(ComVisita comVisita) {
		getComVisitas().remove(comVisita);
		comVisita.setComTipoVisita(null);

		return comVisita;
	}

}