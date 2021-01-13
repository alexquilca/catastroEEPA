package sigepaa.comercializacion.model.dao.manager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class ManagerDaoComercializacion
 */
@Stateless(mappedName="managerDaoComercializacion")
@LocalBean
public class ManagerDaoComercializacion {

    /**
     * Default constructor. 
     */
    public ManagerDaoComercializacion() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName = "DS_Comercializacion")
	private EntityManager em;


	/**
	 * finder Generico que devuelve todos las entidades de una tabla.
	 * 
	 * @param clase   La clase que se desea consultar. Por ejemplo:
	 *                <ul>
	 *                <li>Usuario.class</li>
	 *                </ul>
	 * @param orderBy Expresión que indica la propiedad de la entidad por la que se
	 *                desea ordenar la consulta. Debe utilizar el alias "o" para
	 *                nombrar a la(s) propiedad(es) por la que se va a ordenar. por
	 *                ejemplo:
	 *                <ul>
	 *                <li>o.nombre</li>
	 *                <li>o.codigo,o.nombre</li>
	 *                </ul>
	 *                Puede aceptar null o una cadena vacia, en este caso no
	 *                ordenara el resultado.
	 * @return Listado resultante.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")

	public List findAll(Class clase, String orderBy) throws Exception {
		Query q;
		List listado;
		String sentenciaSQL;

		if (orderBy == null || orderBy.length() == 0)
			sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o";
		else
			sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o ORDER BY " + orderBy;

		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		// mLog.MostrarLog(this.getClass(),"findAll",sentenciaSQL);
		return listado;
	}

	/**
	 * finder Generico que devuelve todos las entidades de una tabla.
	 * 
	 * @param clase La clase que se desea consultar. Por ejemplo:
	 *              <ul>
	 *              <li>Usuario.class</li>
	 *              </ul>
	 * 
	 * @return Listado resultante.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")

	public List findAll(Class clase) throws Exception {
		return findAll(clase, null);
	}

	/**
	 * Finder genérico para buscar un objeto especifico.
	 * 
	 * @param clase La clase sobre la que se desea consultar, ejemplo: Usuario.class
	 * @param pID   Identificador (la clave primaria) que permitira la busqueda.
	 * @return El objeto solicitado (si existiera).
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public Object findById(Class clase, Object pID) throws Exception {
		if (pID == null)
			throw new Exception("Debe especificar el código para buscar el dato.");
		Object o;
		try {
			o = em.find(clase, pID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar la información especificada (" + pID + ") : " + e.getMessage());
		}
		return o;
	}

	/**
	 * Finder generico que permite aplicar clausulas where y order by.
	 * 
	 * @param clase          La entidad sobre la que se desea consultar. Ej:
	 *                       Usuario.class
	 * @param pClausulaWhere Clausula where de tipo JPQL (sin la palabra reservada
	 *                       WHERE). Ejemplo:
	 *                       <ul>
	 *                       <li>o.nombre='Antonio'</li>
	 *                       <li>o.nombre='Antonio' and o.telefono='0444-434'</li>
	 *                       <li>o.nombre like 'Ant%'</li>
	 *                       </ul>
	 * @param pOrderBy       Clausula order by de tipo JPQL (sin la palabra
	 *                       reservada ORDER BY). Puede ser null para no ordenar.
	 *                       por ejemplo:
	 *                       <ul>
	 *                       <li>o.nombre</li>
	 *                       <li>o.codigo,o.nombre</li>
	 *                       </ul>
	 *                       Tanto para la clausula <b>where</b> como <b>order
	 *                       by</b> debe utilizarse el alias de entidad "o".
	 * @return Listado resultante.
	 */
	@SuppressWarnings("rawtypes")
	public List findWhere(Class clase, String pClausulaWhere, String pOrderBy) {
		// mostrarLog("findAll(where): "+clase.getSimpleName());
		Query q;
		List listado;
		String sentenciaSQL;
		if (pOrderBy == null || pOrderBy.length() == 0)
			sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o WHERE " + pClausulaWhere;

		else
			sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o WHERE " + pClausulaWhere + " ORDER BY "
					+ pOrderBy;
		System.out.println(sentenciaSQL);
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}

	/**
	 * Almacena un objeto en la persistencia.
	 * 
	 * @param pObjeto El objeto a insertar.
	 * @throws Exception
	 */

	public void insertar(Object pObjeto) throws Exception {
		if (pObjeto == null)
			throw new Exception("No se puede insertar un objeto null.");
		try {
			em.persist(pObjeto);
			// mostrarLog("Objeto insertado: "+pObjeto.getClass().getSimpleName());
		} catch (Exception e) {
			// mostrarLog("No se pudo insertar el objeto especificado:
			// "+pObjeto.getClass().getSimpleName());
			throw new Exception("No se pudo insertar el objeto especificado: " + e.getMessage());
		}

	}

	/**
	 * Elimina un objeto de la persistencia.
	 * 
	 * @param clase La clase correspondiente al objeto que se desea eliminar.
	 * @param pID   El identificador del objeto que se desea eliminar.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")

	public void eliminar(Class clase, Object pID) throws Exception {
		if (pID == null) {
			// mostrarLog("Debe especificar un identificador para eliminar el dato
			// solicitado: "+clase.getSimpleName());
			throw new Exception("Debe especificar un identificador para eliminar el dato solicitado.");
		}
		Object o = findById(clase, pID);
		try {
			em.remove(o);
			// mostrarLog("Dato eliminado: "+clase.getSimpleName()+" " +pID.toString());
		} catch (Exception e) {
			// mostrarLog("No se pudo eliminar el dato: "+clase.getSimpleName());
			throw new Exception("No se pudo eliminar el dato (" + pID + ") : " + e.getMessage());
		}
	}

	/**
	 * Actualiza la información de un objeto en la persistencia.
	 * 
	 * @param pObjeto Objeto que contiene la información que se debe actualizar.
	 * @throws Exception
	 */

	public void actualizar(Object pObjeto) throws Exception {
		if (pObjeto == null)
			throw new Exception("No se puede actualizar un dato null");
		try {
			em.merge(pObjeto);
		} catch (Exception e) {
			throw new Exception("No se pudo actualizar el dato: " + e.getMessage());
		}

	}

	public Long obtenerSecuencia(String nombreSecuencia) throws Exception {
		String sentenciaSQL;
		Query q;
		BigInteger valSeq;
		Long valorSeq = null;

		try {
			sentenciaSQL = "SELECT nextval('" + nombreSecuencia + "')";
			q = em.createNativeQuery(sentenciaSQL);
			valSeq = (BigInteger) q.getSingleResult();
			valorSeq = valSeq.longValue();
		} catch (Exception e) {
			// managerLog.MostrarLog(this.getClass(), "obtenerSecuencia","Error al obtener
			// valor de secuencia: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al obtener valor de secuencia: " + nombreSecuencia);
		}
		return valorSeq;
	}

	// TODO: implementar en otros manager DAO
	/**
	 * Obtiene el valor maximo de una propiedad correspondiente a una entidad.
	 * 
	 * @param clase           La clase sobre la que se quiere consultar.
	 * @param nombrePropiedad El nombre de la propiedad sobre la que se quiere
	 *                        obtener el valor maximo.
	 * @return El valor maximo.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Long obtenerValorMax(Class clase, String nombrePropiedad) throws Exception {
		Query q;
		String sentenciaSQL;
		Long valorMax;
		try {
			sentenciaSQL = "SELECT MAX(o." + nombrePropiedad + ") FROM " + clase.getSimpleName() + " o";
			q = em.createQuery(sentenciaSQL);
			valorMax = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor max: " + clase.getCanonicalName() + "[" + nombrePropiedad
					+ "]. " + e.getMessage());
		}
		return valorMax;
	}

	public Long obtenerValorMax2(String clase, String nombrePropiedad) throws Exception {
		Query q;
		String sentenciaSQL;
		BigDecimal valorMax;
		try {
			sentenciaSQL = "SELECT MAX(to_number(" + nombrePropiedad + ")) FROM " + clase;
			q = em.createNativeQuery(sentenciaSQL);
			valorMax = (BigDecimal) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor max: " + clase + "[" + nombrePropiedad + "]");
		}
		if (valorMax == null)
			return new Long(1);
		return valorMax.longValue() + 1;
	}

	@SuppressWarnings("rawtypes")
	public List findAllCcosto(Class clase, String ccosto, String id_puesto) {
		Query q;
		List listado;
		String sentenciaSQL;
		// if (ccosto == null || ccosto.length() == 0 && id_puesto == null ||
		// id_puesto.length() == 0)
		sentenciaSQL = "SELECT o FROM " + clase.getSimpleName() + " o where o.centroCostosCodigo = " + ccosto
				+ " and o.codListaPuesto = " + id_puesto;
		// else
		// sentenciaSQL = "SELECT o FROM " + clase.getSimpleName()
		// + " o ORDER BY " + orderBy;
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		return listado;
	}

	public void ejecutarProcesoFichaAnt(Long ficha_anterior, Long ficha_actual) throws Exception {
		Query q;
		String sentenciaSQL;
		try {
			sentenciaSQL = "BEGIN PRO_CARGAR_INF_FICHA_ANT(" + ficha_anterior + "," + ficha_actual + "); END;";
			q = em.createNativeQuery(sentenciaSQL);
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor max: ");
		}
	}

	/*
	 * FUNCION QUE NOS PERMITE EJECUTAR UN PROCEDIMIENTO DE LA BASE DE DATOS
	 * PARAMETRO: RECIBE UNA STRING CON EL NOMBRE Y LOS PARAMETROS PARA EJECUTAR LA
	 * FUNCION EJEMPLO SIN PARAMETROS: THMCP_PRO_DESC_DIAVACACIONES(); EJEMPLO CON
	 * PARAMETROS: THMCP_PRO_MARC_TO_ASIST2('01','2015'); OBSERVACION: EL PARAMETRO
	 * DEBE SER RECIBIDO INCLUYENDO EL ;
	 */
	public void ejecutarProcedimiento(String procedimiento) throws Exception {
		Query q;
		String sentenciaSQL;
		try {
			sentenciaSQL = "BEGIN " + procedimiento + " END;";
			q = em.createNativeQuery(sentenciaSQL);
			System.out.println(sentenciaSQL);
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al ejecutar el procedimiento");
		}
	}

	public Long obtenerCodFichaAnterior(String codigo_empleado) throws Exception {
		Query q;
		String sentenciaSQL;
		BigDecimal codigo;
		try {
			sentenciaSQL = "select max(codigo_ficha) from TTHMTS_FICHA_SOCIAL where CEDULA_EMPLEADO='" + codigo_empleado
					+ "'";
			q = em.createNativeQuery(sentenciaSQL);
			if (q.getSingleResult() == null) {
				codigo = new BigDecimal(0);
			} else {
				codigo = (BigDecimal) q.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor de la ficha anterior: " + e.getCause().getMessage());
		}
		return codigo.longValue();
	}

	/**
	 * MÉTODO QUE PERMITE OBTENER EL SIGUIENTE CÓDIGO PARA UNA EMPLEADO.
	 * 
	 * @return LONG CODIGO_EMPLEADO
	 * @throws Exception
	 */
	public Long obtenerCodigoEmpleadoSig() throws Exception {
		Query q;
		String sentenciaSQL;
		BigDecimal codigo;
		try {
			sentenciaSQL = "SELECT MAX(PNUMEMP) FROM PERFIL";
			q = em.createNativeQuery(sentenciaSQL);
			if (q.getSingleResult() == null) {
				codigo = new BigDecimal(0);
			} else {
				codigo = (BigDecimal) q.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor de la ficha anterior: " + e.getCause().getMessage());
		}
		return codigo.longValue() + 1;
	}

	@SuppressWarnings("rawtypes")

	public List GroupBy(Class clase, String columna) throws Exception {
		Query q;
		List listado;
		String sentenciaSQL;

		sentenciaSQL = "SELECT o." + columna + " FROM " + clase.getSimpleName() + " o GROUP BY " + "o." + columna;
		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		// mLog.MostrarLog(this.getClass(),"findAll",sentenciaSQL);
		return listado;
	}

	@SuppressWarnings("rawtypes")
	public List GroupByWhere(Class clase, String where, String columna) throws Exception {
		Query q;
		List listado;
		String sentenciaSQL;

		sentenciaSQL = "SELECT o." + columna + " FROM " + clase.getSimpleName() + " o WHERE o." + where + " GROUP BY "
				+ "o." + columna;

		q = em.createQuery(sentenciaSQL);
		listado = q.getResultList();
		// mLog.MostrarLog(this.getClass(),"findAll",sentenciaSQL);
		return listado;
	}

	/** ENCUESTAS **/
	/**
	 * Obtiene la suma de un conjunto de valores mediante consulta solo valores de
	 * tipo Int
	 * 
	 * @param clase          La clase sobre la que se quiere consultar.
	 * @param pClausulaWhere Clausula where de tipo JPQL (sin la palabra reservada
	 *                       WHERE). Ejemplo:
	 *                       <ul>
	 *                       <li>o.nombre='Antonio'</li>
	 *                       <li>o.nombre='Antonio' and o.telefono='0444-434'</li>
	 *                       <li>o.nombre like 'Ant%'</li>
	 *                       </ul>
	 * @return El valor de la suma del campo requerido
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public long obtenerSumaTabulacion(Class clase, String nombrePropiedad, String pClausulaWhere) throws Exception {
		Query q;
		String sentenciaSQL;
		long total;
		try {
			sentenciaSQL = "SELECT SUM(" + nombrePropiedad + ") FROM " + clase.getSimpleName() + " o WHERE "
					+ pClausulaWhere;
			q = em.createQuery(sentenciaSQL);
			total = (long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al obtener valor suma: " + clase.getCanonicalName() + "[" + nombrePropiedad
					+ "]. " + e.getMessage());
		}
		return total;
	}

}
