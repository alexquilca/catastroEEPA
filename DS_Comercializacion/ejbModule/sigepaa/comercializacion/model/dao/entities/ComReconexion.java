package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the com_reconexion database table.
 * 
 */
@Entity
@Table(name="com_reconexion")
@NamedQuery(name="ComReconexion.findAll", query="SELECT c FROM ComReconexion c")
public class ComReconexion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_RECONEXION_ID_GENERATOR", sequenceName="SEQ_COM_RECONEXION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_RECONEXION_ID_GENERATOR")
	private Integer id;

	private String descripcion;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fecha_ reporte\"")
	private Date fecha_reporte;

	private String funcionario;

	@Column(name="num_orden_trabajo")
	private String numOrdenTrabajo;

	public ComReconexion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFecha_reporte() {
		return this.fecha_reporte;
	}

	public void setFecha_reporte(Date fecha_reporte) {
		this.fecha_reporte = fecha_reporte;
	}

	public String getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getNumOrdenTrabajo() {
		return this.numOrdenTrabajo;
	}

	public void setNumOrdenTrabajo(String numOrdenTrabajo) {
		this.numOrdenTrabajo = numOrdenTrabajo;
	}

}