package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_grupo_vulnerable database table.
 * 
 */
@Entity
@Table(name="com_grupo_vulnerable")
@NamedQuery(name="ComGrupoVulnerable.findAll", query="SELECT c FROM ComGrupoVulnerable c")
public class ComGrupoVulnerable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_GRUPO_VULNERABLE_ID_GENERATOR", sequenceName="SEQ_COM_GRUPO_VULNERABLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_GRUPO_VULNERABLE_ID_GENERATOR")
	private Integer id;

	private String beneficio;

	private Integer estado;

	private String nombre;

	//bi-directional many-to-one association to ComCliente
	@OneToMany(mappedBy="comGrupoVulnerable")
	private List<ComCliente> comClientes;

	public ComGrupoVulnerable() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeneficio() {
		return this.beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
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

	public List<ComCliente> getComClientes() {
		return this.comClientes;
	}

	public void setComClientes(List<ComCliente> comClientes) {
		this.comClientes = comClientes;
	}

	public ComCliente addComCliente(ComCliente comCliente) {
		getComClientes().add(comCliente);
		comCliente.setComGrupoVulnerable(this);

		return comCliente;
	}

	public ComCliente removeComCliente(ComCliente comCliente) {
		getComClientes().remove(comCliente);
		comCliente.setComGrupoVulnerable(null);

		return comCliente;
	}

}