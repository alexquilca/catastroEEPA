package sigepaa.view.controller.catastro;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComAcometida;
import sun.swing.SwingUtilities2.Section;

@Named("frmAcometida")
@SessionScoped
public class FrmAcometida implements Serializable {
	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComAcometida objComAcometida;
	private String sectorBuscar;	

	@PostConstruct
	public void inicializaracometida() {
		objComAcometida= new ComAcometida();
	
	}
	
	public void ingresarAcometida() {
		try {
			managerComercializacion.ingresarAcometida(objComAcometida);
			// ingresarPredio(objComPredio);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializaracometida();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inicializaracometida();
		}
	}
	
	public void buscarUltimaSecuenciaSector() {
		objComAcometida.setCuenta(managerComercializacion.buscarSecuenciaSectro(objComAcometida.getSector()));
	}
	

	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}
		
         ///////bucar sector ///////
	public void buscarAcometidaBySector() {
		try {
			objComAcometida = managerComercializacion.buscarAcometidaBySector(sectorBuscar);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención!", "Sector encontrado."));
	}
	
	

	private static final long serialVersionUID = 1L;

	public ComAcometida getObjComAcometida() {
		return objComAcometida;
	}

	public void setObjComAcometida(ComAcometida objComAcometida) {
		this.objComAcometida = objComAcometida;
	}

	public String getSectorBuscar() {
		return sectorBuscar;
	}
	
	public void setSectorBuscar(String sectorBuscar) {
		this.sectorBuscar = sectorBuscar;
	}

}
