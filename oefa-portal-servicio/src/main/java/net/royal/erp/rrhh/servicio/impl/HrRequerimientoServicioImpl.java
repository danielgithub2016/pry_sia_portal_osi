package net.royal.erp.rrhh.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dominio.dto.DtoMetaPresupuestal;
import net.royal.erp.rrhh.dao.HrRequerimientoDao;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrRequerimientoSeguimiento;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoEdit;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.rrhh.servicio.HrRequerimientoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.dominio.UsuarioActual;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioHrRequerimiento")
public class HrRequerimientoServicioImpl extends GenericoServicioImpl implements HrRequerimientoServicio {

	private HrRequerimientoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientoServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer obtenerMaximoRequerimiento(String companyowner, String unidadreplicacion) {
		return dao.obtenerMaximoRequerimiento(companyowner, unidadreplicacion);
	}

	@Override
	public Integer secuenciaNextEval() {
		return dao.contar("hrrequerimiento.secuenciaNextEval");
	}

	@Override
	public List<DtoDwHrRequerimientoList> listarRequerimientos(Integer par_codigopuesto, Integer p_codigoPuesto,
			String p_convocatoria, String p_tiporequerimiento, String p_compania, BigDecimal p_concurso,
			String p_tipoplanilla, Integer p_empleadoresponsable, BigDecimal p_codigoPosicionSolicitante,
			String p_fechas, String p_estado, String p_desierto, String p_numero, Date p_fini, Date p_ffin,
			Integer par_empleado, String par_validacion1, String par_validacion2) {

		return dao.listarRequerimientos(par_codigopuesto, p_codigoPuesto, p_convocatoria, p_tiporequerimiento,
				p_compania, p_concurso, p_tipoplanilla, p_empleadoresponsable, p_codigoPosicionSolicitante, p_fechas,
				p_estado, p_desierto, p_numero, p_fini, p_ffin, par_empleado, par_validacion1, par_validacion2);
	}

	@Override
	public List<DtoTipoPlanilla> listarTipoPlanilla(String tiposdePlanilla) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("tiposdePlanilla", String.class, tiposdePlanilla));

		List datos = dao.listarPorQuery(DtoTipoPlanilla.class, "hrrequerimiento.listarTipoPlanillaCandidatos",
				parametros);
		return datos;
	}

	@Override
	public HrRequerimiento obtenerRequerimiento(String requerimeinto, String compania) {
		HrRequerimientoPk pk = new HrRequerimientoPk();
		pk.setCompanyowner(compania);
		pk.setRequerimiento(requerimeinto);

		HrRequerimiento reque = dao.obtenerPorId(pk, false);

		return reque;
	}

	@Override
	public Date obtenerfechahoraServidor() {
		DtoDwHrRequerimientoList dto = new DtoDwHrRequerimientoList();
		List datos = dao.listarPorQuery(DtoDwHrRequerimientoList.class, "hrrequerimiento.obtenerFechaHoraServidor");

		if (!UValidador.esListaVacia(datos)) {
			dto = (DtoDwHrRequerimientoList) datos.get(0);
		}

		return dto.getFechasolicitud();
	}

	@Override
	public String obtenerFlgPublicado(String p_requerimiento, String p_companyowner, Integer p_secuencia) {

		String publicado = "";
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento", String.class, p_requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_companyowner", String.class, p_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("p_secuencia", Integer.class, p_secuencia));

		List datos = dao.listarPorQuery(DtoDwHrRequerimientoList.class, "hrrequerimiento.obtenerFlgPublicado",
				parametros);

		if (!UValidador.esListaVacia(datos)) {
			DtoDwHrRequerimientoList dto = new DtoDwHrRequerimientoList();
			dto = (DtoDwHrRequerimientoList) datos.get(0);
			publicado = dto.getFlagpublicado();
		}

		return publicado;
	}

	@Override
	public Integer obtenerEvaluacion(String p_requerimiento, String p_companyowner, Integer p_secuencia,
			String p_fecha) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento", String.class, p_requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_companyowner", String.class, p_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("p_secuencia", Integer.class, p_secuencia));
		parametros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class, p_fecha));

		return dao.contar("hrrequerimiento.obtenerEvaluacion", parametros);
	}

	@Override
	public Integer obtenercantidadPost(Integer p_evaluador, String p_requerimiento, String p_companyowner) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento", String.class, p_requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_companyowner", String.class, p_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("p_evaluador", Integer.class, p_evaluador));

		return dao.contar("hrrequerimiento.obtenercantidadPost", parametros);
	}

	@Override
	public List<DtoMetaPresupuestal> obtenermetapresupuestal(String compania, String ano) {
		// TODO Auto-generated method stub
		List<DtoMetaPresupuestal> resultado = null;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();

		filtros.add(new ParametroPersistenciaGenerico("p_companiasocio", String.class, compania));
		filtros.add(new ParametroPersistenciaGenerico("p_ano", String.class, ano));

		List data = dao.listarPorQuery(DtoMetaPresupuestal.class, "hrrequerimiento.obtenermetapresupuestal", filtros);

		if (!UValidador.esListaVacia(data)) {
			resultado = data;
		}

		return resultado;
	}

	@Override
	public void registrarDocAprobacion(String usuario, DtoDwHrRequerimientoEdit requerimiento) {
		// TODO Auto-generated method stub
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(
				new ParametroPersistenciaGenerico("p_requerimiento", String.class, requerimiento.getRequerimiento()));
		parametros.add(
				new ParametroPersistenciaGenerico("p_companyowner", String.class, requerimiento.getCompanyowner()));
		parametros.add(new ParametroPersistenciaGenerico("p_empleadosolicitante", BigDecimal.class,
				requerimiento.getEmpleadosolicitante()));
		parametros.add(new ParametroPersistenciaGenerico("p_usuario", Integer.class, usuario));

		dao.ejecutarPorQuery("hrrequerimiento.insertarDocAprobacion", parametros);
	}

	@Override
	public List<UsuarioActual> obtenerUsuariosEnvio() {
		// TODO Auto-generated method stub
		List data = dao.listarPorQuery(UsuarioActual.class, "hrrequerimiento.obtenerUsuariosEnvio");
		return data;
	}

	@Override
	public List<DtoHrRequerimientoSeguimiento> listarSeguimiento(String requerimiento) {
		// TODO Auto-generated method stub
		List<DtoHrRequerimientoSeguimiento> data = new ArrayList<>();
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento", String.class, requerimiento));

		List data1 = dao.listarPorQuery(DtoHrRequerimientoSeguimiento.class, "hrrequerimiento.listarseguimiento",
				parametros);

		if (!UValidador.esListaVacia(data1)) {
			data.addAll(data1);
		}

		return data;
	}

	@Override
	public List<DtoHrRequerimientoSeguimiento> listarFlagTipoSecuencia(String requerimiento, Integer evaluacion) {
		// TODO Auto-generated method stub
		List<DtoHrRequerimientoSeguimiento> data = new ArrayList<>();
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_requerimiento", String.class, requerimiento));
		parametros.add(new ParametroPersistenciaGenerico("p_evaluacion", Integer.class, evaluacion));

		List data1 = dao.listarPorQuery(DtoHrRequerimientoSeguimiento.class, "hrrequerimiento.listarFlagTipoSecuencia",
				parametros);

		if (!UValidador.esListaVacia(data1)) {
			data.addAll(data1);
		}

		return data;

	}

}
