package sigepaa.view.controller.catastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComModeloMedidor;



@Named("frmModeloMedidor")
@SessionScoped


public class FrmModeloMedidor implements Serializable {
	
	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComModeloMedidor objComModeloMedidor;
	
	@PostConstruct
	public void inicializarmodelo_medidor() {
		objComModeloMedidor = new ComModeloMedidor();
	}
	
	public void ingresarModeloMedidor() {
		try {
			managerComercializacion.ingresarModeloMedidor(objComModeloMedidor);
			// ingresarPredio(objComPredio);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializarmodelo_medidor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inicializarmodelo_medidor();
		}
	}
	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}	

	private static final long serialVersionUID = 1L;

	public ComModeloMedidor getObjComModeloMedidor() {
		return objComModeloMedidor;
	}

	public void setObjComModeloMedidor(ComModeloMedidor objComModeloMedidor) {
		this.objComModeloMedidor = objComModeloMedidor;
	}
	
}
