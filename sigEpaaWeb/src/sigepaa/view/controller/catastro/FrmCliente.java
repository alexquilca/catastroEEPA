package sigepaa.view.controller.catastro;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import core.model.manager.comercializacion.ManagerComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComCliente;
import sigepaa.comercializacion.model.dao.entities.ComGrupoVulnerable;
import sigepaa.comercializacion.model.dao.entities.ComTelefonoUsuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("frmCliente")
@SessionScoped
public class FrmCliente implements Serializable {

	@EJB
	private ManagerComercializacion managerComercializacion;
	private ComCliente objComCliente;
	private List<ComCliente> lstComCliente;
	private ComTelefonoUsuario objComTelefonoUsuario;
	private String cedulaBuscar;

	@PostConstruct
	public void inicializarcliente() {
		objComCliente = new ComCliente();
		objComCliente.setComGrupoVulnerable(new ComGrupoVulnerable());
		objComCliente.setComTelefonoUsuarios(new ArrayList<ComTelefonoUsuario>());
		inicializarobjComTelefonoUsuario();

		try {
			lstComCliente = new ArrayList<ComCliente>();
			lstComCliente = managerComercializacion.buscarComCliente();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void inicializarobjComTelefonoUsuario() {
		objComTelefonoUsuario = new ComTelefonoUsuario();
	}

	public void ingresarCliente() {
		try {
			validarObjCliente();
			if (objComCliente.getId()!=null)
				managerComercializacion.actualizarPersona(objComCliente);
			else
				managerComercializacion.ingresarCliente(objComCliente);
			mensajeSatisfactorio("Se ingreso correctamente.");
			inicializarcliente();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Atención", "Error al ingresar. " + e.getMessage()));

		}

	}
         ///vaidacion de la cedula ///
	private void validarObjCliente() throws Exception {
		if (vacioNulo(objComCliente.getIdentificacion()))
			throw new Exception("Campo cédula vacio.");
	}

	private boolean vacioNulo(String cadena) {
		if (cadena.isEmpty() || cadena == null)
			return true;
		return false;
	}
        ///ingreso del telefono///
	public void ingresarTelefonoCliente() {
		objComTelefonoUsuario.setComCliente(objComCliente);
		objComCliente.getComTelefonoUsuarios().add(objComTelefonoUsuario);
		inicializarobjComTelefonoUsuario();
	}

	public void mensajeSatisfactorio(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atención", mensaje));
	}
   
	     ///busqueda///
	public void buscarPersonaByCedula() {
		try {
			objComCliente = managerComercializacion.buscarClienteByIdentificacion(cedulaBuscar);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención!", "Cliente encontrado."));
	}

	public void actualizarPersona() {
		try {

			inicializarcliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> lstSelectGrupoVulnerable() {
		List<SelectItem> lstVulnerables = new ArrayList<SelectItem>();
		List<ComGrupoVulnerable> lstGrupoVulnerable = managerComercializacion.buscarGrupoVulnerableActivo();
		for (ComGrupoVulnerable comGrupoVulnerable : lstGrupoVulnerable) {
			SelectItem selecItem = new SelectItem();
			selecItem.setLabel(comGrupoVulnerable.getNombre());
			selecItem.setValue(comGrupoVulnerable.getId());
			lstVulnerables.add(selecItem);

		}
		return lstVulnerables;
	}

	private static final long serialVersionUID = 1L;

	public void ManagerComercializacion() {
		// TODO Auto-generated constructor stub
	}

	public ComCliente getObjComCliente() {
		return objComCliente;
	}

	public void setObjComCliente(ComCliente objComCliente) {
		this.objComCliente = objComCliente;
	}

	public List<ComCliente> getLstComCliente() {
		return lstComCliente;
	}

	public void setLstComCliente(List<ComCliente> lstComCliente) {
		this.lstComCliente = lstComCliente;
	}

	public ComTelefonoUsuario getObjComTelefonoUsuario() {
		return objComTelefonoUsuario;
	}

	public void setObjComTelefonoUsuario(ComTelefonoUsuario objComTelefonoUsuario) {
		this.objComTelefonoUsuario = objComTelefonoUsuario;
	}

	public String getCedulaBuscar() {
		return cedulaBuscar;
	}

	public void setCedulaBuscar(String cedulaBuscar) {
		this.cedulaBuscar = cedulaBuscar;
	}

}
