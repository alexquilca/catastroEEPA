package sigepaa.view.controller.catastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComCliente;
import sigepaa.comercializacion.model.dao.entities.ComClientePredio;
import sigepaa.comercializacion.model.dao.entities.ComPredio;
import sigepaa.comercializacion.model.dao.entities.ComPredioServiciosBasico;
import sigepaa.comercializacion.model.dao.entities.ComServiciosBasico;

@Named("frmPredio")
@SessionScoped
public class FrmPredio implements Serializable {
	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComPredio objComPredio;
	private ComServiciosBasico objserServiciosBasico;
	private ComPredioServiciosBasico objComPredioServiciosBasico;
	private ComClientePredio objComClientePredio;
	private boolean panelPersona;

	@PostConstruct
	public void inicializarpredio() {
		panelPersona = false;
		objComClientePredio = new ComClientePredio();
		objComClientePredio.setComCliente(new ComCliente());
		objComClientePredio.setComPredio(new ComPredio());
		objComPredio = new ComPredio();
		objserServiciosBasico = new ComServiciosBasico();
		inicializarComPredioServiciosBasicos();
	}

	public void agregarServicioBasico() {
		try {
			objserServiciosBasico = managerComercializacion.buscarServicioBasicoById(objserServiciosBasico.getId());
			ComPredioServiciosBasico objPredioSerBasico = new ComPredioServiciosBasico();
			objPredioSerBasico.setComServiciosBasico(objserServiciosBasico);
			objPredioSerBasico.setComPredio(objComPredio);
			objPredioSerBasico.setEstado(1);
			objComPredio.getComPredioServiciosBasicos().add(objPredioSerBasico);
			objserServiciosBasico = new ComServiciosBasico();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buscarPersona() {
		try {
			objComClientePredio.setComCliente(managerComercializacion
					.buscarClienteByIdentificacion(objComClientePredio.getComCliente().getIdentificacion()));
			panelPersona=true;
		} catch (Exception e) {
			panelPersona=false;
			mensajeSatisfactorio(e.getMessage());
			e.printStackTrace();
		}
	}

	public void inicializarComPredioServiciosBasicos() {
		objComPredioServiciosBasico = new ComPredioServiciosBasico();
		objComPredioServiciosBasico.setComServiciosBasico(new ComServiciosBasico());
		objComPredioServiciosBasico.setComPredio(new ComPredio());
		objComPredio.setComPredioServiciosBasicos(new ArrayList<ComPredioServiciosBasico>());
	}

	public void ingresarPredio() {
		try {
			managerComercializacion.ingresarPredio(objComPredio);
			objComClientePredio.setComPredio(objComPredio);
			objComClientePredio.setEstado(1);
			objComClientePredio.setFechaRegistro(new Date());
			managerComercializacion.ingresarClientePredio(objComClientePredio);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializarpredio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ingresarServiciosBasico() {
		objComPredioServiciosBasico.setComPredio(objComPredio);
		objComPredio.getComPredioServiciosBasicos().add(objComPredioServiciosBasico);
		inicializarComPredioServiciosBasicos();
	}

	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}

	private static final long serialVersionUID = 1L;

	public ComPredio getObjComPredio() {
		return objComPredio;
	}

	public void setObjComPredio(ComPredio objComPredio) {
		this.objComPredio = objComPredio;
	}

	public ComPredioServiciosBasico getObjComPredioServiciosBasico() {
		return objComPredioServiciosBasico;
	}

	public void setObjComPredioServiciosBasico(ComPredioServiciosBasico objComPredioServiciosBasico) {
		this.objComPredioServiciosBasico = objComPredioServiciosBasico;
	}

	public ComServiciosBasico getObjserServiciosBasico() {
		return objserServiciosBasico;
	}

	public void setObjserServiciosBasico(ComServiciosBasico objserServiciosBasico) {
		this.objserServiciosBasico = objserServiciosBasico;
	}

	public boolean isPanelPersona() {
		return panelPersona;
	}

	public void setPanelPersona(boolean panelPersona) {
		this.panelPersona = panelPersona;
	}

	public ComClientePredio getObjComClientePredio() {
		return objComClientePredio;
	}

	public void setObjComClientePredio(ComClientePredio objComClientePredio) {
		this.objComClientePredio = objComClientePredio;
	}

}
