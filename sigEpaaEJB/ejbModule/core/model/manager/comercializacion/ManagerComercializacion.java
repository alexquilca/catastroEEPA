package core.model.manager.comercializacion;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import sigepaa.comercializacion.model.dao.manager.ManagerDaoComercializacion;
import sigepaa.comercializacion.model.dao.entities.ComAcometida;
import sigepaa.comercializacion.model.dao.entities.ComCliente;
import sigepaa.comercializacion.model.dao.entities.ComClientePredio;
import sigepaa.comercializacion.model.dao.entities.ComGrupoVulnerable;
import sigepaa.comercializacion.model.dao.entities.ComLectura;
import sigepaa.comercializacion.model.dao.entities.ComModeloMedidor;
import sigepaa.comercializacion.model.dao.entities.ComPredio;
import sigepaa.comercializacion.model.dao.entities.ComServiciosBasico;
import sigepaa.comercializacion.model.dao.entities.ComTelefonoUsuario;
import sigepaa.comercializacion.model.dao.entities.ComVisita;

/**
 * Session Bean implementation class ManagerComercializacion
 */
@Stateless(mappedName = "managerComercializacion")
@LocalBean
public class ManagerComercializacion {

	/**
	 * Default constructor.
	 */
	public ManagerComercializacion() {
		// TODO Auto-generated constructor stub
	}

	/** ///////////CATASTROS/////////////////// **/
	@EJB

	public ManagerDaoComercializacion managerDao;

	/** ///////////CLIENTE ///////////////// **/
	public void ingresarCliente(ComCliente objComCliente) throws Exception {
		managerDao.insertar(objComCliente);
	}
	/** ///////////BOTON BUSCAR ///////////////// **/
	public ComCliente buscarClienteByIdentificacion(String identificacion) throws Exception {
		List<ComCliente> lstCliente = managerDao.findWhere(ComCliente.class,
				"o.identificacion='" + identificacion + "'", null);
		if (lstCliente.size() == 0)
			throw new Exception("No existe cliente.");
		if (lstCliente.size() > 1)
			throw new Exception("Más de un cliente registrado con número de cédula.");
		for (ComCliente comCliente : lstCliente) {
			for (ComTelefonoUsuario comCliente2 : comCliente.getComTelefonoUsuarios()) {
				comCliente2.getOperadora();
			}
		}
		return lstCliente.get(0);
	}
		
	/** ///////////BOTON BUSCAR SECTOR ///////////////// **/
	
	public ComAcometida buscarAcometidaBySector(String sector) throws Exception {
		List<ComAcometida> comAcometidas = managerDao.findWhere(ComAcometida.class, "o.sector='" + sector + "'", null);
		return buscarAcometidaBySector(sector);		
	}
	  	
	/** /////////// INGRESO DEL GRUPO VULNERABLE //////////////// **/

	@SuppressWarnings("unchecked")
	public List<ComGrupoVulnerable> buscarGrupoVulnerableActivo() {
		return managerDao.findWhere(ComGrupoVulnerable.class, "o.estado=1", "o.nombre");
	}

	@SuppressWarnings("unchecked")
	public List<ComCliente> buscarComCliente() throws Exception {
		// TODO Auto-generated method stub
		try {
			return managerDao.findAll(ComCliente.class, "o.apellido ASC");
		} catch (Exception e) {
			throw new Exception("Error al bucar Personas.");
		}
	}

	public void ingresarVisitas(ComVisita objComVisita) throws Exception {
		managerDao.insertar(objComVisita);
	}

	/** ///////////ACTUALIZAR PERSONA/////////////////// **/
	public void actualizarPersona(ComCliente objComCliente) throws Exception {
		try {
			managerDao.actualizar(objComCliente);
		} catch (Exception e) {
			throw new Exception("Error al acutalizar.");
		}
	}

	/** /////////// PREDIO ///////////////// **/
	public void ingresarPredio(ComPredio objComPredio) throws Exception {
		managerDao.insertar(objComPredio);
	}
 
	/** ///////////SERVICIO BASICO ///////////////// **/
	public ComServiciosBasico buscarServicioBasicoById(Integer id) throws Exception {
		return (ComServiciosBasico) managerDao.findById(ComServiciosBasico.class, id);
	}
	

	/** ///////////INGRESO ACOMETIDA ///////////////// **/

	public void ingresarAcometida(ComAcometida objComAcometida) throws Exception {
		managerDao.insertar(objComAcometida);
	}

	/** ///////////LECTURA/////////////////// **/
	public void ingresarLectura(ComLectura objComLectura) throws Exception {
		managerDao.insertar(objComLectura);
	}

	/** ///////////MODELO MEDIDOR ///////////////// **/
	public void ingresarModeloMedidor(ComModeloMedidor objComModeloMedidor) throws Exception {
		managerDao.insertar(objComModeloMedidor);
	}
	public void ingresarClientePredio(ComClientePredio objComClientePredio) throws Exception {
		managerDao.insertar(objComClientePredio);
		
	}
	public Integer buscarSecuenciaSectro(Integer sector) {
		@SuppressWarnings("unchecked")
		List<ComAcometida> lstComAcometida = managerDao.findWhere(ComAcometida.class, "o.sector="+sector, "o.cuenta DESC");
		
		if ( lstComAcometida.isEmpty())
			return 1;
		return lstComAcometida.get(0).getCuenta()+1;
	}

}
