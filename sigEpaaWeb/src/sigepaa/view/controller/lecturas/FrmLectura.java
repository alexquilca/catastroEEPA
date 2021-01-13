
package sigepaa.view.controller.lecturas;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComLectura;


@Named("frmLectura")
@SessionScoped
public class FrmLectura implements Serializable {

	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComLectura objComLectura;

	@PostConstruct
	public void inicializarlectura() {
		objComLectura = new ComLectura();
	}
	
	public void ingresarLectura() {
		try {
			managerComercializacion.ingresarLectura(objComLectura);
			//ingresarPredio(objComPredio);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializarlectura();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inicializarlectura();
		}
	}

	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}
	
	private static final long serialVersionUID = 1L;

	public FrmLectura() {
		// TODO Auto-generated constructor stub
	}

	public ComLectura getObjComLectura() {
		return objComLectura;
	}

	public void setObjComLectura(ComLectura objComLectura) {
		this.objComLectura = objComLectura;
	}

}
