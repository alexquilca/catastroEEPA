package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the com_telefono_usuario database table.
 * 
 */
@Entity
@Table(name="com_telefono_usuario")
@NamedQuery(name="ComTelefonoUsuario.findAll", query="SELECT c FROM ComTelefonoUsuario c")
public class ComTelefonoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_TELEFONO_USUARIO_ID_GENERATOR", sequenceName="SEQ_COM_TELEFONO_USUARIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_TELEFONO_USUARIO_ID_GENERATOR")
	private Integer id;

	private String numero;

	private String operadora;

	private Integer principal;

	private String tipo;

	//bi-directional many-to-one association to ComCliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ComCliente comCliente;

	public ComTelefonoUsuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Integer getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Integer principal) {
		this.principal = principal;
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

}