package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the com_cliente_predio database table.
 * 
 */
@Entity
@Table(name="com_cliente_predio")
@NamedQuery(name="ComClientePredio.findAll", query="SELECT c FROM ComClientePredio c")
public class ComClientePredio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_CLIENTE_PREDIO_ID_GENERATOR", sequenceName="SEQ_COM_CLIENTE_PREDIO",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_CLIENTE_PREDIO_ID_GENERATOR")
	private Integer id;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String tipo;

	//bi-directional many-to-one association to ComCliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ComCliente comCliente;

	//bi-directional many-to-one association to ComPredio
	@ManyToOne
	@JoinColumn(name="id_predio")
	private ComPredio comPredio;

	public ComClientePredio() {
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

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ComCliente getComCliente() {
		return this.comCliente;
	}

	public void setComCliente(ComCliente comCliente) {
		this.comCliente = comCliente;
	}

	public ComPredio getComPredio() {
		return this.comPredio;
	}

	public void setComPredio(ComPredio comPredio) {
		this.comPredio = comPredio;
	}

}