package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the com_medidor database table.
 * 
 */
@Entity
@Table(name="com_medidor")
@NamedQuery(name="ComMedidor.findAll", query="SELECT c FROM ComMedidor c")
public class ComMedidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_MEDIDOR_ID_GENERATOR", sequenceName="SEQ_COM_MEDIDOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_MEDIDOR_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_instalacion")
	private Date fechaDeInstalacion;

	private Integer latitud;

	private Integer longitud;

	@Column(name="numero_de_serie")
	private Integer numeroDeSerie;

	private String observaciones;

	//bi-directional many-to-one association to ComInspeccione
	@OneToMany(mappedBy="comMedidor")
	private List<ComInspeccione> comInspecciones;

	//bi-directional many-to-one association to ComLectura
	@OneToMany(mappedBy="comMedidor")
	private List<ComLectura> comLecturas;

	//bi-directional many-to-one association to ComAcometida
	@ManyToOne
	@JoinColumn(name="id_acometida")
	private ComAcometida comAcometida;

	//bi-directional many-to-one association to ComModeloMedidor
	@ManyToOne
	@JoinColumn(name="id_modelo_medidor")
	private ComModeloMedidor comModeloMedidor;

	//bi-directional many-to-one association to ComVisita
	@OneToMany(mappedBy="comMedidor")
	private List<ComVisita> comVisitas;

	public ComMedidor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaDeInstalacion() {
		return this.fechaDeInstalacion;
	}

	public void setFechaDeInstalacion(Date fechaDeInstalacion) {
		this.fechaDeInstalacion = fechaDeInstalacion;
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

	public Integer getNumeroDeSerie() {
		return this.numeroDeSerie;
	}

	public void setNumeroDeSerie(Integer numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<ComInspeccione> getComInspecciones() {
		return this.comInspecciones;
	}

	public void setComInspecciones(List<ComInspeccione> comInspecciones) {
		this.comInspecciones = comInspecciones;
	}

	public ComInspeccione addComInspeccione(ComInspeccione comInspeccione) {
		getComInspecciones().add(comInspeccione);
		comInspeccione.setComMedidor(this);

		return comInspeccione;
	}

	public ComInspeccione removeComInspeccione(ComInspeccione comInspeccione) {
		getComInspecciones().remove(comInspeccione);
		comInspeccione.setComMedidor(null);

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
		comLectura.setComMedidor(this);

		return comLectura;
	}

	public ComLectura removeComLectura(ComLectura comLectura) {
		getComLecturas().remove(comLectura);
		comLectura.setComMedidor(null);

		return comLectura;
	}

	public ComAcometida getComAcometida() {
		return this.comAcometida;
	}

	public void setComAcometida(ComAcometida comAcometida) {
		this.comAcometida = comAcometida;
	}

	public ComModeloMedidor getComModeloMedidor() {
		return this.comModeloMedidor;
	}

	public void setComModeloMedidor(ComModeloMedidor comModeloMedidor) {
		this.comModeloMedidor = comModeloMedidor;
	}

	public List<ComVisita> getComVisitas() {
		return this.comVisitas;
	}

	public void setComVisitas(List<ComVisita> comVisitas) {
		this.comVisitas = comVisitas;
	}

	public ComVisita addComVisita(ComVisita comVisita) {
		getComVisitas().add(comVisita);
		comVisita.setComMedidor(this);

		return comVisita;
	}

	public ComVisita removeComVisita(ComVisita comVisita) {
		getComVisitas().remove(comVisita);
		comVisita.setComMedidor(null);

		return comVisita;
	}

}