package sigepaa.view.controller.catastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComVisita;

@Named("frmVisitas")
@SessionScoped
public class FrmVisitas implements Serializable {

	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComVisita objComVisita;

	@PostConstruct
	public void inicializarvisita() {
		objComVisita = new ComVisita();
	}
	
	public void ingresarVisita() {
		try {
			managerComercializacion.ingresarVisitas(objComVisita);
			// ingresarPredio(objComPredio);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializarvisita();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inicializarvisita();
		}
	}

	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}

	private static final long serialVersionUID = 1L;

	
	public ComVisita getObjComVisita() {
		return objComVisita;
	}
	
	public void setObjComVisita(ComVisita objComVisita) {
		this.objComVisita = objComVisita;
	}	
}
