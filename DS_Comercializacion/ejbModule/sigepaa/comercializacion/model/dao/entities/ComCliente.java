package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the com_cliente database table.
 * 
 */
@Entity
@Table(name="com_cliente")
@NamedQuery(name="ComCliente.findAll", query="SELECT c FROM ComCliente c")
public class ComCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_CLIENTE_ID_GENERATOR", sequenceName="SEQ_COM_CLIENTE", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_CLIENTE_ID_GENERATOR")
	private Integer id;

	private String apellido;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_defuncion")
	private Date fechaDeDefuncion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_nacimiento")
	private Date fechaDeNacimiento;

	private String identificacion;

	private String nombre;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	//bi-directional many-to-one association to ComGrupoVulnerable
	@ManyToOne
	@JoinColumn(name="id_grupo_vulnerable")
	private ComGrupoVulnerable comGrupoVulnerable;

	//bi-directional many-to-one association to ComClientePredio
	@OneToMany(mappedBy="comCliente")
	private List<ComClientePredio> comClientePredios;

	//bi-directional many-to-one association to ComTelefonoUsuario
	@OneToMany(mappedBy="comCliente", cascade = CascadeType.ALL)  //---//
	private List<ComTelefonoUsuario> comTelefonoUsuarios;

	public ComCliente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaDeDefuncion() {
		return this.fechaDeDefuncion;
	}

	public void setFechaDeDefuncion(Date fechaDeDefuncion) {
		this.fechaDeDefuncion = fechaDeDefuncion;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public ComGrupoVulnerable getComGrupoVulnerable() {
		return this.comGrupoVulnerable;
	}

	public void setComGrupoVulnerable(ComGrupoVulnerable comGrupoVulnerable) {
		this.comGrupoVulnerable = comGrupoVulnerable;
	}

	public List<ComClientePredio> getComClientePredios() {
		return this.comClientePredios;
	}

	public void setComClientePredios(List<ComClientePredio> comClientePredios) {
		this.comClientePredios = comClientePredios;
	}

	public ComClientePredio addComClientePredio(ComClientePredio comClientePredio) {
		getComClientePredios().add(comClientePredio);
		comClientePredio.setComCliente(this);

		return comClientePredio;
	}

	public ComClientePredio removeComClientePredio(ComClientePredio comClientePredio) {
		getComClientePredios().remove(comClientePredio);
		comClientePredio.setComCliente(null);

		return comClientePredio;
	}

	public List<ComTelefonoUsuario> getComTelefonoUsuarios() {
		return this.comTelefonoUsuarios;
	}

	public void setComTelefonoUsuarios(List<ComTelefonoUsuario> comTelefonoUsuarios) {
		this.comTelefonoUsuarios = comTelefonoUsuarios;
	}

	public ComTelefonoUsuario addComTelefonoUsuario(ComTelefonoUsuario comTelefonoUsuario) {
		getComTelefonoUsuarios().add(comTelefonoUsuario);
		comTelefonoUsuario.setComCliente(this);

		return comTelefonoUsuario;
	}

	public ComTelefonoUsuario removeComTelefonoUsuario(ComTelefonoUsuario comTelefonoUsuario) {
		getComTelefonoUsuarios().remove(comTelefonoUsuario);
		comTelefonoUsuario.setComCliente(null);

		return comTelefonoUsuario;
	}

}