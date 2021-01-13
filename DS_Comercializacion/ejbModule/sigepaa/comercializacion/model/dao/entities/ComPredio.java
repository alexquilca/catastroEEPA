package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_predio database table.
 * 
 */
@Entity
@Table(name="com_predio")
@NamedQuery(name="ComPredio.findAll", query="SELECT c FROM ComPredio c")
public class ComPredio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_PREDIO_ID_GENERATOR", sequenceName="SEQ_COM_PREDIO", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_PREDIO_ID_GENERATOR")
	private Integer id;

	private String direccion;

	@Column(name="numero_de_casa")
	private String numeroDeCasa;

	private String referencia;

	@Column(name="tipo_de_ubicacion")
	private String tipoDeUbicacion;

	@Column(name="tipo_propiedad")
	private String tipoPropiedad;

	//bi-directional many-to-one association to ComAcometida
	@OneToMany(mappedBy="comPredio")
	private List<ComAcometida> comAcometidas;

	//bi-directional many-to-one association to ComClientePredio
	@OneToMany(mappedBy="comPredio")
	private List<ComClientePredio> comClientePredios;

	//bi-directional many-to-one association to ComPredioServiciosBasico
	@OneToMany(mappedBy="comPredio", cascade = CascadeType.ALL) //---//
	private List<ComPredioServiciosBasico> comPredioServiciosBasicos;

	public ComPredio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroDeCasa() {
		return this.numeroDeCasa;
	}

	public void setNumeroDeCasa(String numeroDeCasa) {
		this.numeroDeCasa = numeroDeCasa;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTipoDeUbicacion() {
		return this.tipoDeUbicacion;
	}

	public void setTipoDeUbicacion(String tipoDeUbicacion) {
		this.tipoDeUbicacion = tipoDeUbicacion;
	}

	public String getTipoPropiedad() {
		return this.tipoPropiedad;
	}

	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public List<ComAcometida> getComAcometidas() {
		return this.comAcometidas;
	}

	public void setComAcometidas(List<ComAcometida> comAcometidas) {
		this.comAcometidas = comAcometidas;
	}

	public ComAcometida addComAcometida(ComAcometida comAcometida) {
		getComAcometidas().add(comAcometida);
		comAcometida.setComPredio(this);

		return comAcometida;
	}

	public ComAcometida removeComAcometida(ComAcometida comAcometida) {
		getComAcometidas().remove(comAcometida);
		comAcometida.setComPredio(null);

		return comAcometida;
	}

	public List<ComClientePredio> getComClientePredios() {
		return this.comClientePredios;
	}

	public void setComClientePredios(List<ComClientePredio> comClientePredios) {
		this.comClientePredios = comClientePredios;
	}

	public ComClientePredio addComClientePredio(ComClientePredio comClientePredio) {
		getComClientePredios().add(comClientePredio);
		comClientePredio.setComPredio(this);

		return comClientePredio;
	}

	public ComClientePredio removeComClientePredio(ComClientePredio comClientePredio) {
		getComClientePredios().remove(comClientePredio);
		comClientePredio.setComPredio(null);

		return comClientePredio;
	}

	public List<ComPredioServiciosBasico> getComPredioServiciosBasicos() {
		return this.comPredioServiciosBasicos;
	}

	public void setComPredioServiciosBasicos(List<ComPredioServiciosBasico> comPredioServiciosBasicos) {
		this.comPredioServiciosBasicos = comPredioServiciosBasicos;
	}

	public ComPredioServiciosBasico addComPredioServiciosBasico(ComPredioServiciosBasico comPredioServiciosBasico) {
		getComPredioServiciosBasicos().add(comPredioServiciosBasico);
		comPredioServiciosBasico.setComPredio(this);

		return comPredioServiciosBasico;
	}

	public ComPredioServiciosBasico removeComPredioServiciosBasico(ComPredioServiciosBasico comPredioServiciosBasico) {
		getComPredioServiciosBasicos().remove(comPredioServiciosBasico);
		comPredioServiciosBasico.setComPredio(null);

		return comPredioServiciosBasico;
	}

}