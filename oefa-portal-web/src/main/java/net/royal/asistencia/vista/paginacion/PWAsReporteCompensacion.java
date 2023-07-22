package net.royal.asistencia.vista.paginacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import net.royal.asistencia.vista.filtros.FwAsAutorizacionPreprocesoAprobacion;
import net.royal.comun.vista.controladora.CComunGlobal;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsConceptoacceso;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl.SORT_ORDER;
import net.royal.framework.web.dominio.ParametroPaginacion;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;

public class PWAsReporteCompensacion extends LazyDataModel<DtoEmpleadomast> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ParametroPersistenciaGenerico> parametros;
	private FwAsAutorizacionPreprocesoAprobacion dwFiltros;
	private UsuarioActual usuarioActual;

	public PWAsReporteCompensacion(List<ParametroPersistenciaGenerico> parametros,
			FwAsAutorizacionPreprocesoAprobacion dwFiltros, UsuarioActual usuarioActual) {
		this.parametros = parametros;
		this.dwFiltros = dwFiltros;
		this.usuarioActual = usuarioActual;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DtoEmpleadomast> load(int registroInicio, int registrosPorPagina, String campoOrden,
			SortOrder sortOrder, Map<String, Object> filters) {

		// inicializando parametros
		List lstResultado;
		ParametroPaginacion paginacion = new ParametroPaginacion();

		// seteando los valores de la paginacion para la consulta
		paginacion.setRegistroInicio(registroInicio);
		paginacion.setRegistrosPorPagina(registrosPorPagina);
		paginacion.setParametros(parametros);
		paginacion.setClazz(DtoEmpleadomast.class);
		paginacion.setCampoOrden(campoOrden);
		paginacion.setDireccionOrden(sortOrder == SortOrder.DESCENDING ? SORT_ORDER.DESC : SORT_ORDER.ASC);

		// llamando al negocio para devolver los datos
		paginacion = CComunGlobal.getInstance().getFacCore().getEmpleadomastServicio().listarActivosArea(paginacion);

		// devolviendo los valores obtenidos
		setRowCount(paginacion.getRegistroEncontrados());
		lstResultado = paginacion.getListaResultado();

		AsConceptoacceso objCon = new AsConceptoacceso();
		objCon.getPk().setConceptoacceso("PAHE");

		objCon = (AsConceptoacceso) CComunGlobal.getInstance().getFacAsistencia().getAsConceptoaccesoServicio()
				.obtenerPorId(objCon.getPk());

		if (!UValidador.esListaVacia(lstResultado)) {
			// recorremos la lista y completamos los siguientes datos
			for (int i = 0; i < lstResultado.size(); i++) {

				DtoEmpleadomast obj = (DtoEmpleadomast) lstResultado.get(i);
				// -----------------------------ACT HOCR 20180223
				// ----------------------------------//
				String ls_FlagNumerosRestriccion = null;
				BigDecimal ll_CantidadMesesRestriccion = null, ll_NumeroHorasMesesRestriccion = null,
						ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
				Date ld_FechaInicioRestriccion = null, ld_fechaingreso = null, ld_fechacorte = null, ld_fechainiciobase,
						ld_fecharegistro, ld_fechainiciotemp;
				Date ld_fechainiciosemestre, ld_fechafinsemestre;
				// double ll_segundosafter;
				BigDecimal ll_minutarthhee, ll_minutarthhee2;
				ld_fecharegistro = dwFiltros.getFechadesde();
				BigDecimal ll_cantidadiasfechas;
				BigDecimal ldc_bloquesmeses;
				int ll_bloquesmeses;
				int ll_cantidadbloques;

				// verificamos las horas extras por área
				AsArea area = CComunGlobal.getInstance().getFacAsistencia().getAsAreaServicio()
						.obtenerArea(obj.getEmpleado().intValue(), usuarioActual.getCompaniaSocioCodigo());
				if ("S".equals(area.getFlagexondirectiva())) {
					// validamos la cantidad de horas extras
					// generadas al mes
					Date fechalimite1 = dwFiltros.getFechadesde();
					Date fechalimite2 = dwFiltros.getFechaHasta();
					ll_NumeroHorasMesesRestriccion = BigDecimal.valueOf(area.getnNroHoras().intValue());

					fechalimite1 = UFechaHora.obtenerPrimerDiaMesFecha(fechalimite1);
					fechalimite2 = UFechaHora.obtenerUltimoDiaMesFecha(fechalimite2);

					try {
						ll_CantidadMesesRestriccionCAS = CComunGlobal.getInstance().getFacAsistencia()
								.getAsAutorizacionServicio()
								.obtenerHoraGanadas(obj.getEmpleado().intValue(), fechalimite1, fechalimite2);

						if (UValidador.esNulo(ll_CantidadMesesRestriccionCAS)) {
							ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
						}

						// int dias =
						// UFechaHora.obtenerDiasTranscurridos(dw_1.getFechafin(),
						// dw_1.getFecha());

						// ll_minutarthhee =
						// CComunGlobal.getInstance().getFacAsistencia().getAsAutorizacionServicio()
						// .obtenerMinutosSobreTiempo(obj.getEmpleado().intValue(),
						// fechalimite1, fechalimite2);
						//
						// if (ll_minutarthhee == null) {
						// ll_minutarthhee = BigDecimal.ZERO;
						// }
						//
						// ll_minutarthhee = (ll_minutarthhee.divide(new
						// BigDecimal(60.0), 2, BigDecimal.ROUND_HALF_UP));

						ll_minutarthhee2 = CComunGlobal.getInstance().getFacAsistencia().getAsAutorizacionServicio()
								.obtenerHorasSobreTiempo3(obj.getEmpleado().intValue(), fechalimite1, fechalimite2);

						if (UValidador.esNulo(ll_minutarthhee2)) {
							ll_minutarthhee2 = BigDecimal.ZERO;
						}
						//
						// ll_minutarthhee2 = ll_minutarthhee2.divide(new
						// BigDecimal(60.0), 2, BigDecimal.ROUND_HALF_UP);

						obj.setHorasSolicitadas(ll_minutarthhee2);
						obj.setHorasArea(ll_NumeroHorasMesesRestriccion);
						obj.setHorasConsumidas(ll_CantidadMesesRestriccionCAS);
						obj.setHorasConsumidasTexto(obtenerHorasAcumuladas(ll_CantidadMesesRestriccionCAS));
						obj.setHorasSolicitadasTexto(obtenerHorasAcumuladas(ll_minutarthhee2));
						obj.setSemestre(UFechaHora.convertirFechaCadena(fechalimite1, "dd/MM/yyyy") + " al "
								+ UFechaHora.convertirFechaCadena(fechalimite2, "dd/MM/yyyy"));

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					if (!UValidador.esNulo(objCon)) {
						ls_FlagNumerosRestriccion = objCon.getFlagnumerosrestriccion();
						ll_CantidadMesesRestriccion = objCon.getCantidadmesesrestriccion();
						ll_NumeroHorasMesesRestriccion = objCon.getNumerohorasmesesrestriccion();
						ld_FechaInicioRestriccion = objCon.getFechainiciorestriccion();
					}

					if (UValidador.estaVacio(ls_FlagNumerosRestriccion)) {
						ls_FlagNumerosRestriccion = "N";
					}

					if (ls_FlagNumerosRestriccion.equals("S")) {

						if (ll_CantidadMesesRestriccion.intValue() > 0) {
							ld_fecharegistro = dwFiltros.getFechadesde();
							ld_fechacorte = ld_FechaInicioRestriccion;

							Empleadomast emp = (Empleadomast) CComunGlobal.getInstance().getFacCore()
									.getEmpleadomastServicio().obtenerPorId(new EmpleadomastPk(
											obj.getEmpleado().intValue(), usuarioActual.getCompaniaSocioCodigo()));

							if (!UValidador.esNulo(emp)) {
								ld_fechaingreso = emp.getFechaingreso();
							}

							if (ld_fechaingreso.getTime() > ld_fechacorte.getTime()) {
								ld_fechainiciobase = ld_fechaingreso;
							} else {
								ld_fechainiciobase = ld_fechacorte;
							}
							ld_fechainiciotemp = ld_fechainiciobase;

							ll_cantidadiasfechas = BigDecimal.valueOf(
									UFechaHora.obtenerDiasTranscurridos(ld_fecharegistro, ld_fechainiciotemp) + 1);

							ldc_bloquesmeses = (ll_cantidadiasfechas.divide(
									ll_CantidadMesesRestriccion.multiply(BigDecimal.valueOf(30)), 2,
									BigDecimal.ROUND_HALF_UP));

							if (ldc_bloquesmeses.subtract(BigDecimal.valueOf(ldc_bloquesmeses.intValue()))
									.equals(BigDecimal.ZERO)) {
								ll_bloquesmeses = ldc_bloquesmeses.intValue();
							} else {
								ll_bloquesmeses = ldc_bloquesmeses.intValue() + 1;
							}

							ll_cantidadbloques = 1;

							do {
								ld_fechainiciotemp = UFechaHora.addMesesToDate(ld_fechainiciotemp,
										ll_CantidadMesesRestriccion.intValue());
								ll_cantidadbloques++;
							} while (ll_cantidadbloques < ll_bloquesmeses);

							// -------------------------ACT HOCR
							// 20181017
							// ------------------------//

							ld_fechainiciobase = UFechaHora.addMesesToDate(ld_fecharegistro,
									-1 * ll_CantidadMesesRestriccion.intValue());
							ld_fechainiciosemestre = ld_fechainiciotemp;
							ld_fechafinsemestre = UFechaHora.addMesesToDate(ld_fechainiciosemestre,
									ll_CantidadMesesRestriccion.intValue());
							// Restamos un día
							ld_fechafinsemestre = UFechaHora.anadirDiasAFechas(ld_fechafinsemestre, -1);

							try {

								ll_CantidadMesesRestriccionCAS = CComunGlobal.getInstance().getFacAsistencia()
										.getAsAutorizacionServicio().obtenerHoraGanadas(obj.getEmpleado().intValue(),
												ld_fechainiciosemestre, ld_fechafinsemestre);
								// ll_minutarthhee =
								// CComunGlobal.getInstance().getFacAsistencia()
								// .getAsAutorizacionServicio()
								// .obtenerMinutosSobreTiempo(obj.getEmpleado().intValue(),
								// ld_fechainiciosemestre,
								// ld_fechafinsemestre);
								//
								// if (ll_minutarthhee == null) {
								// ll_minutarthhee = BigDecimal.ZERO;
								// }

								// ll_minutarthhee = (ll_minutarthhee.divide(new
								// BigDecimal(60.0), 2,
								// BigDecimal.ROUND_HALF_UP));

								ll_minutarthhee2 = CComunGlobal.getInstance().getFacAsistencia()
										.getAsAutorizacionServicio()
										.obtenerHorasSobreTiempo3(obj.getEmpleado().intValue(), ld_fechainiciosemestre,
												ld_fechafinsemestre);

								if (UValidador.esNulo(ll_minutarthhee2)) {
									ll_minutarthhee2 = BigDecimal.ZERO;
								}

								// ll_minutarthhee2 =
								// ll_minutarthhee2.divide(new BigDecimal(60.0),
								// 2,
								// BigDecimal.ROUND_HALF_UP);

								if (UValidador.esNulo(ll_CantidadMesesRestriccionCAS)) {
									ll_CantidadMesesRestriccionCAS = BigDecimal.ZERO;
								}

								obj.setHorasGeneral(ll_NumeroHorasMesesRestriccion);
								obj.setHorasConsumidas(ll_CantidadMesesRestriccionCAS);
								obj.setHorasConsumidasTexto(obtenerHorasAcumuladas(ll_CantidadMesesRestriccionCAS));
								obj.setHorasSolicitadas(ll_minutarthhee2);
								obj.setHorasSolicitadasTexto(obtenerHorasAcumuladas(ll_minutarthhee2));
								obj.setSemestre(UFechaHora.convertirFechaCadena(ld_fechainiciosemestre, "dd/MM/yyyy")
										+ " al " + UFechaHora.convertirFechaCadena(ld_fechafinsemestre, "dd/MM/yyyy"));

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}

				//
				// if (dwFiltros.getIsexceden()) {
				// if (!(obj.getHorasConsumidas().compareTo(obj.getHorasArea())
				// == 1
				// && obj.getHorasConsumidas().compareTo(obj.getHorasGeneral())
				// == 1)) {
				// lstResultado.remove(i);
				// i--;
				// }
				// }
			}

		}

		return lstResultado;
	}

	private String obtenerHorasAcumuladas(BigDecimal saldoinicial) {
		// TODO Auto-generated method stub
		BigDecimal sexagesimal, decimales;
		Integer enteros;

		sexagesimal = f_cent2sex(saldoinicial);
		BigDecimal cal1 = sexagesimal.subtract(BigDecimal.valueOf(sexagesimal.intValue())).setScale(2,
				RoundingMode.HALF_EVEN);

		decimales = cal1.multiply(BigDecimal.valueOf(100));

		enteros = sexagesimal.intValue();

		if (UValidador.esCero(decimales.compareTo(BigDecimal.valueOf(60)))) {
			enteros = enteros + 1;
			decimales = BigDecimal.valueOf(0.0);
		}

		if (UValidador.esNulo(enteros) && UValidador.esNulo(decimales)) {
			return "";
		} else if (UValidador.esCero(enteros) && UValidador.esCero(decimales.intValue())) {
			return "00:00";
		} else {
			String signo = enteros >= 0 ? "" : "-";
			return signo + ((enteros < 10 && enteros > -10) ? ("0" + Math.abs(enteros)) : Math.abs(enteros)) + ":"
					+ ((decimales.intValue() < 10) ? ("0" + decimales.intValue()) : decimales.intValue());
		}
	}

	private BigDecimal f_cent2sex(BigDecimal par_cent) {
		BigDecimal decimales;
		BigDecimal valor;
		valor = par_cent;
		decimales = valor.subtract(BigDecimal.valueOf(valor.intValue()));

		BigDecimal cal1 = decimales.divide(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(6)).setScale(2,
				RoundingMode.HALF_UP);

		return BigDecimal.valueOf(valor.intValue()).add(cal1);
	}

}
