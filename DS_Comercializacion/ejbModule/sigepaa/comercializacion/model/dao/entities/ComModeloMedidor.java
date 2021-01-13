package sigepaa.comercializacion.model.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the com_modelo_medidor database table.
 * 
 */
@Entity
@Table(name="com_modelo_medidor")
@NamedQuery(name="ComModeloMedidor.findAll", query="SELECT c FROM ComModeloMedidor c")
public class ComModeloMedidor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COM_MODELO_MEDIDOR_ID_GENERATOR", sequenceName="SEQ_COM_MODELO_MEDIDOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COM_MODELO_MEDIDOR_ID_GENERATOR")
	private Integer id;

	private String descripcion;

	private String marca;

	private String modelo;

	@Column(name="tipo_de_medidor")
	private String tipoDeMedidor;

	//bi-directional many-to-one association to ComMedidor
	@OneToMany(mappedBy="comModeloMedidor")
	private List<ComMedidor> comMedidors;

	public ComModeloMedidor() {
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

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoDeMedidor() {
		return this.tipoDeMedidor;
	}

	public void setTipoDeMedidor(String tipoDeMedidor) {
		this.tipoDeMedidor = tipoDeMedidor;
	}

	public List<ComMedidor> getComMedidors() {
		return this.comMedidors;
	}

	public void setComMedidors(List<ComMedidor> comMedidors) {
		this.comMedidors = comMedidors;
	}

	public ComMedidor addComMedidor(ComMedidor comMedidor) {
		getComMedidors().add(comMedidor);
		comMedidor.setComModeloMedidor(this);

		return comMedidor;
	}

	public ComMedidor removeComMedidor(ComMedidor comMedidor) {
		getComMedidors().remove(comMedidor);
		comMedidor.setComModeloMedidor(null);

		return comMedidor;
	}

}