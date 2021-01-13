package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the com_atencion_al_cliente database table.
 * 
 */
@Entity
@Table(name="com_atencion_al_cliente")
@NamedQuery(name="ComAtencionAlCliente.findAll", query="SELECT c FROM ComAtencionAlCliente c")
public class ComAtencionAlCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_ATENCION_AL_CLIENTE_ID_GENERATOR", sequenceName="SEQ_COM_ATENCION_AL_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_ATENCION_AL_CLIENTE_ID_GENERATOR")
	private Integer id;

	private String calificacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String funcionario;

	@Column(name="tipo_orden_trabajo")
	private String tipoOrdenTrabajo;

	public ComAtencionAlCliente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getTipoOrdenTrabajo() {
		return this.tipoOrdenTrabajo;
	}

	public void setTipoOrdenTrabajo(String tipoOrdenTrabajo) {
		this.tipoOrdenTrabajo = tipoOrdenTrabajo;
	}

}