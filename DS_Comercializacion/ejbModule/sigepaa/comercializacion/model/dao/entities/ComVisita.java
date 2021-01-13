package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the com_visita database table.
 * 
 */
@Entity
@Table(name="com_visita")
@NamedQuery(name="ComVisita.findAll", query="SELECT c FROM ComVisita c")
public class ComVisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_VISITA_ID_GENERATOR", sequenceName="SEQ_COM_VISITA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_VISITA_ID_GENERATOR")
	private Integer id;

	private Integer estado;

	private String fotografia;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_de_llegada")
	private Date horaDeLlegada;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_de_salida")
	private Date horaDeSalida;

	@Column(name="id_funcionario")
	private Integer idFuncionario;

	private Integer latitud;

	private Integer longitud;

	private String observacion;

	private Integer tipo;

	//bi-directional many-to-one association to ComInspeccione
	@OneToMany(mappedBy="comVisita")
	private List<ComInspeccione> comInspecciones;

	//bi-directional many-to-one association to ComLectura
	@OneToMany(mappedBy="comVisita")
	private List<ComLectura> comLecturas;

	//bi-directional many-to-one association to ComMedidor
	@ManyToOne
	@JoinColumn(name="id_medidor")
	private ComMedidor comMedidor;

	//bi-directional many-to-one association to ComTipoVisita
	@ManyToOne
	@JoinColumn(name="id_tipo_visita")
	private ComTipoVisita comTipoVisita;

	public ComVisita() {
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

	public String getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public Date getHoraDeLlegada() {
		return this.horaDeLlegada;
	}

	public void setHoraDeLlegada(Date horaDeLlegada) {
		this.horaDeLlegada = horaDeLlegada;
	}

	public Date getHoraDeSalida() {
		return this.horaDeSalida;
	}

	public void setHoraDeSalida(Date horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}

	public Integer getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getLatitud() {
		return this.latitud;
	}

	public void setLatitud(Integer latitud) {
		this.latitud = latitud;
	}

	public Integer getLongitud() {
		return this.longitud;
	}

	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<ComInspeccione> getComInspecciones() {
		return this.comInspecciones;
	}

	public void setComInspecciones(List<ComInspeccione> comInspecciones) {
		this.comInspecciones = comInspecciones;
	}

	public ComInspeccione addComInspeccione(ComInspeccione comInspeccione) {
		getComInspecciones().add(comInspeccione);
		comInspeccione.setComVisita(this);

		return comInspeccione;
	}

	public ComInspeccione removeComInspeccione(ComInspeccione comInspeccione) {
		getComInspecciones().remove(comInspeccione);
		comInspeccione.setComVisita(null);

		return comInspeccione;
	}

	public List<ComLectura> getComLecturas() {
		return this.comLecturas;
	}

	public void setComLecturas(List<ComLectura> comLecturas) {
		this.comLecturas = comLecturas;
	}

	public ComLectura addComLectura(ComLectura comLectura) {
		getComLecturas().add(comLectura);
		comLectura.setComVisita(this);

		return comLectura;
	}

	public ComLectura removeComLectura(ComLectura comLectura) {
		getComLecturas().remove(comLectura);
		comLectura.setComVisita(null);

		return comLectura;
	}

	public ComMedidor getComMedidor() {
		return this.comMedidor;
	}

	public void setComMedidor(ComMedidor comMedidor) {
		this.comMedidor = comMedidor;
	}

	public ComTipoVisita getComTipoVisita() {
		return this.comTipoVisita;
	}

	public void setComTipoVisita(ComTipoVisita comTipoVisita) {
		this.comTipoVisita = comTipoVisita;
	}

}