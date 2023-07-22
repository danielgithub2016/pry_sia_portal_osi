package net.royal.erp.core.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.dominio.dto.DtoTablaNuevaBandeja;
import net.royal.erp.core.dao.PersonamastDao;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.erp.core.servicio.PersonamastServicio;
import net.royal.erp.sistema.dominio.dto.DtoDwWhImportacionSelect;
import net.royal.erp.sistema.dominio.dto.DtoDwWhImportacionSelectBlDetail;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioPersonamast")
public class PersonamastServicioImpl extends GenericoServicioImpl implements
		PersonamastServicio {

	private PersonamastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(PersonamastServicioImpl.class);

	@Autowired
	public void setDao(PersonamastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Personamast obtenerporPersona(Integer persona) {
		return dao.obtenerporPersona(persona);
	}

	public Personamast obtenerporPersonaAnt(String personaAnt){
		return dao.obtenerporPersonaAnt(personaAnt);
	}

	@Override
	public String obtenerNombrePersona(BigDecimal codigoPersona) {
		return dao.obtenerNombrePersona(codigoPersona);
	}

	@Override
	public List obtenerEmpleadosAutorizados() {
		return dao.obtenerEmpleadosAutorizados();
	}

	@Override
	public Integer obtenerPersonaxRUC(String par_documentoFiscal) {
		return dao.obtenerPersonaxRUC(par_documentoFiscal);
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycommon.f_sql_validate_persona_unidadnegocio
	 */

	public DtoTablaNuevaBandeja obtenerDatosParaNuevaBandeja(String usuarioRed){
		DtoTablaNuevaBandeja empleadoBandeja= new DtoTablaNuevaBandeja();
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("p_usuario",
				String.class, usuarioRed));
		
		List datos = dao.listarPorQuery(DtoTablaNuevaBandeja.class,
				"personamast.obtenerDatosParaNuevaBandeja", parametros);

		if (!UValidador.esListaVacia(datos)) {
			empleadoBandeja=(DtoTablaNuevaBandeja) datos.get(0);
			return empleadoBandeja;
		} 
		
		return empleadoBandeja;
	}
	public Integer FSqlValidatePersonaUnidadnegocio(Integer par_persona,
			String par_unidadnegocio) {
		LOGGER.debug("test de sycommon.f_sql_validate_persona_unidadnegocio");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("par_persona",
				Integer.class, par_persona));
		parametros.add(new ParametroPersistenciaGenerico("par_unidadnegocio",
				String.class, par_unidadnegocio));

		List datos = dao.listarPorQuery(DtoPersonamast.class,
				"personamast.fsqlvalidatepersonaunidadnegocio", parametros);

		if (!UValidador.esListaVacia(datos)) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public ParametroPaginacion DwMaPersonaSelectByBusquedaPaginacion(
			ParametroPaginacion paginacion) {
		BigDecimal registros;
		List lstResultado;
		StringBuilder query = new StringBuilder();
		StringBuffer queryContar = new StringBuffer();
		StringBuilder sentenciaSQL = new StringBuilder();
		StringBuilder sentenciaSQLCompleto = new StringBuilder();

		query.append(filtrosListadoDinamico(paginacion.getParametros()));

		queryContar.append(dao.getSesionActual()
				.getNamedQuery("personamast.DwMaPersonaSelectByBusquedaContar")
				.getQueryString());

		sentenciaSQL
				.append(filtrosListadoDinamico(paginacion.getParametros()));

		queryContar.append(sentenciaSQL);
		sentenciaSQLCompleto.append(queryContar);

		registros = dao.contarPorSentenciaSQL(sentenciaSQLCompleto);

		lstResultado = dao.listarConPaginacion(paginacion.getRegistroInicio(),
				paginacion.getRegistrosPorPagina(), paginacion.getCampoOrden(),
				paginacion.getDireccionOrden(), null,
				"personamast.DwMaPersonaSelectByBusquedaListar",
				paginacion.getClazz(), query.toString());

		paginacion.setRegistroEncontrados(registros.intValue());
		paginacion.setListaResultado(lstResultado);
		return paginacion;
	}
	
	public String filtrosListadoDinamico(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		StringBuilder query1 = new StringBuilder();

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("estado")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a estado");
					query.append(" AND Estado='" + objParam.getValue() + "' ");
				}

				if (objParam.getField().equals("Pyme_all")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a Pyme_all");
					query.append(" AND PersonaMast.PYMEFlag='"
							+ objParam.getValue() + "' ");
				}

				if (objParam.getField().equals("P")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a P");
					query.append(" AND EsProveedor='S' ");
				}

				if (objParam.getField().equals("C")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a C");
					query.append(" AND EsCliente='S' ");
				}

				if (objParam.getField().equals("E")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a E");
					query.append(" AND EsEmpleado='S' ");
				}

				if (objParam.getField().equals("O")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a O =");
					query.append(" AND EsOtro='S' ");
				}

				if (objParam.getField().equals("PE")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PE =");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S')  ");
				}

				if (objParam.getField().equals("PO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PE =");
					query.append(" AND (EsOtro = 'S' or EsProveedor = 'S') ");
				}

				if (objParam.getField().equals("CO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a CO ");
					query.append(" AND (EsOtro = 'S' or EsProveedor = 'S') ");
				}

				if (objParam.getField().equals("EO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a EO ");
					query.append(" AND (EsOtro = 'S' or EsEmpleado = 'S') ");
				}

				if (objParam.getField().equals("POE")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a POE ");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S' or EsOtro = 'S') ");
				}

				if (objParam.getField().equals("PCO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PCO ");
					query.append("  AND (EsCliente = 'S' or EsProveedor = 'S' or EsOtro = 'S') ");
				}

				if (objParam.getField().equals("PEOC")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PEOC ");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S' or EsOtro = 'S' or EsCliente = 'S') ");
				}

				if (objParam.getField().equals("iv_type")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a iv_type ");
					query.append(" AND EXISTS (SELECT 1 FROM MA_PersonaPersonaGrupo WHERE PersonaMast.Persona = MA_PersonaPersonaGrupo.Persona AND MA_PersonaPersonaGrupo.PersonaGrupo = '"
							+ objParam.getValue() + "')");
				}

			}

			for (ParametroPersistenciaGenerico objParam1 : parametros) {

				if (objParam1.getField().equals("B")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a B");
					query1.append(" AND Busqueda LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%' AND ROWNUM <=100 ORDER BY Busqueda");
				}

				if (objParam1.getField().equals("D")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a D");
					query1.append(" AND Documento LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%' AND ROWNUM <=100 ORDER BY Documento");
				}

				if (objParam1.getField().equals("N")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a N");
					query1.append(" AND Persona >=  " + objParam1.getValue()
							+ " AND ROWNUM <=100 ORDER BY Persona");
				}

				if (objParam1.getField().equals("I")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a I");
					query1.append(" AND DocumentoIdentidad LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%' AND ROWNUM <=100 ORDER BY DocumentoIdentidad");
				}

				if (objParam1.getField().equals("F")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a F");
					query1.append(" AND DocumentoFiscal LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%' AND ROWNUM <=100 ORDER BY DocumentoFiscal");
				}

				if (objParam1.getField().equals("A")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a A");
					query1.append(" AND PersonaAnt LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%' AND ROWNUM <=100 ORDER BY PersonaAnt");
				}

				if (objParam1.getField().equals("T")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a T");
					query1.append(" AND Telefono LIKE " + objParam1.getValue()
							+ "'%' AND ROWNUM <=100 ORDER BY Telefono");
				}

			}
		}

		if (query1.length() > 0) {
			LOGGER.debug("QUERY1::" + query1.toString());
			return query.toString() + query1.toString();
		} else {
			LOGGER.debug("QUERY::" + query.toString());
			query.append(" AND ROWNUM <=100 ORDER BY PersonaMast.Busqueda");
			
			return query.toString();
		}
	}

	public String filtrosContarPaginacion(
			List<ParametroPersistenciaGenerico> parametros) {

		StringBuilder query = new StringBuilder();
		StringBuilder query1 = new StringBuilder();

		query.append(" WHERE 1=1 ");

		if (!UValidador.esNulo(parametros)) {
			for (ParametroPersistenciaGenerico objParam : parametros) {

				if (objParam.getField().equals("estado")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a estado");
					query.append(" AND Estado='" + objParam.getValue() + "' ");
				}

				if (objParam.getField().equals("Pyme_all")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a Pyme_all");
					query.append(" AND PersonaMast.PYMEFlag='"
							+ objParam.getValue() + "' ");
				}

				if (objParam.getField().equals("P")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a P");
					query.append(" AND EsProveedor='S' ");
				}

				if (objParam.getField().equals("C")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a C");
					query.append(" AND EsCliente='S' ");
				}

				if (objParam.getField().equals("E")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a E");
					query.append(" AND EsEmpleado='S' ");
				}

				if (objParam.getField().equals("O")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a O =");
					query.append(" AND EsOtro='S' ");
				}

				if (objParam.getField().equals("PE")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PE =");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S')  ");
				}

				if (objParam.getField().equals("PO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PE =");
					query.append(" AND (EsOtro = 'S' or EsProveedor = 'S') ");
				}

				if (objParam.getField().equals("CO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a CO ");
					query.append(" AND (EsOtro = 'S' or EsProveedor = 'S') ");
				}

				if (objParam.getField().equals("EO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a EO ");
					query.append(" AND (EsOtro = 'S' or EsEmpleado = 'S') ");
				}

				if (objParam.getField().equals("POE")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a POE ");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S' or EsOtro = 'S') ");
				}

				if (objParam.getField().equals("PCO")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PCO ");
					query.append("  AND (EsCliente = 'S' or EsProveedor = 'S' or EsOtro = 'S') ");
				}

				if (objParam.getField().equals("PEOC")
						&& !UValidador
								.estaVacio(objParam.getValue().toString())) {
					LOGGER.debug("entra a PEOC ");
					query.append(" AND (EsEmpleado = 'S' or EsProveedor = 'S' or EsOtro = 'S' or EsCliente = 'S') ");
				}
			}

			for (ParametroPersistenciaGenerico objParam1 : parametros) {

				if (objParam1.getField().equals("B")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a B");
					query1.append(" AND Busqueda LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%'");
				}

				if (objParam1.getField().equals("D")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a D");
					query1.append(" AND Documento LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%'");
				}

				if (objParam1.getField().equals("N")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a N");
					query1.append(" AND Persona >=  " + objParam1.getValue());
				}

				if (objParam1.getField().equals("I")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a I");
					query1.append(" AND DocumentoIdentidad LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%'");
				}

				if (objParam1.getField().equals("F")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a F");
					query1.append(" AND DocumentoFiscal LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%'");
				}

				if (objParam1.getField().equals("A")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a A");
					query1.append(" AND PersonaAnt LIKE '"
							+ objParam1.getValue().toString().toUpperCase()
							+ "%'");
				}

				if (objParam1.getField().equals("T")
						&& !UValidador.estaVacio(objParam1.getValue()
								.toString())) {
					LOGGER.debug("entra a T");
					query1.append(" AND Telefono LIKE " + objParam1.getValue()
							+ "'%'");
				}

			}
		}

		if (query1.length() > 0) {
			LOGGER.debug("QUERY1::" + query1.toString());
			return query.toString() + query1.toString();
		} else {
			LOGGER.debug("QUERY::" + query.toString());
			return query.toString();
		}
	}
	
	public List DwWhImportacionSelect(String companiasocio) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("companiasocio",
				String.class, companiasocio));
		List lista = dao.listarPorQuery(DtoDwWhImportacionSelect.class,
				"personamast.DwWhImportacionSelect", filtros);
		return lista;
	}
	
	public List DwWhImportacionSelectBlDetail(String companiasocio,
			String blnumero) {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("companiasocio",
				String.class, companiasocio));
		filtros.add(new ParametroPersistenciaGenerico("blnumero", String.class,
				blnumero));
		List lista = dao.listarPorQuery(DtoDwWhImportacionSelectBlDetail.class,
				"personamast.DwWhImportacionSelectBlDetail", filtros);
		return lista;

	}


	@Override
	public List<DtoPersonamast> filtrofecha(Date fecha,Date fecha2) {
		LOGGER.debug("Filtro por Fecha");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("par_fecha",
				Date.class, fecha));
		parametros.add(new ParametroPersistenciaGenerico("par_fecha2",
				Date.class, fecha2));

		List datos = dao.listarPorQuery(DtoPersonamast.class,
				"personamast.filtrofecha", parametros);
		
		return datos;
	}

	@Override
	public List<DtoPersonamast> filtroTodo() {
		LOGGER.debug("Filtrar Todo");

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		List datos = dao.listarPorQuery(Personamast.class,
				"personamast.filtrotodo", parametros);
		
		return datos;
	}

	
}
