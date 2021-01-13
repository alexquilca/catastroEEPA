package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the com_corte database table.
 * 
 */
@Entity
@Table(name="com_corte")
@NamedQuery(name="ComCorte.findAll", query="SELECT c FROM ComCorte c")
public class ComCorte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_CORTE_ID_GENERATOR", sequenceName="SEQ_COM_CORTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_CORTE_ID_GENERATOR")
	private Integer id;

	private String descripcion;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_corte")
	private Date fechaCorte;

	private String funcionario;

	@Column(name="\"num_orden _trabajo\"")
	private Integer numOrden_Trabajo;

	public ComCorte() {
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

	public Date getFechaCorte() {
		return this.fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getNumOrden_Trabajo() {
		return this.numOrden_Trabajo;
	}

	public void setNumOrden_Trabajo(Integer numOrden_Trabajo) {
		this.numOrden_Trabajo = numOrden_Trabajo;
	}

}