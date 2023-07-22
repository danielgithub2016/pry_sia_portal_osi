package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import net.royal.erp.asistencia.asmast.dominio.dto.DtoDwPrEmpleadoSelect;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.rrhh.dao.HrPuestoempresaDao;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrPuestoempresaPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoSelectMultipleSincia;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadomastDaoImpl extends GenericoDaoImpl<Empleadomast, EmpleadomastPk> implements EmpleadomastDao {

	private static Log LOGGER = LogFactory.getLog(Empleadomast.class);
	private HrPuestoempresaDao daoPuestoEmpresa;

	@Autowired
	public void setDaoPuestoEmpresa(HrPuestoempresaDao daoPuestoEmpresa) {
		this.daoPuestoEmpresa = daoPuestoEmpresa;
	}

	public EmpleadomastDaoImpl() {
		super("empleadomast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public Integer obtenerMaximoEmpleado(String codigoUsuario) {
		LOGGER.debug("logger para prueba");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("codigousuario", codigoUsuario.toUpperCase()));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.empleado"));

		cri.setProjection(proj);

		List lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return (Integer) lista.get(0);
	}

	@Override
	public Empleadomast obtenerPorCodigoUsuario(String codigoUsuario) {
		if (!UValidador.esNulo(codigoUsuario))
			codigoUsuario = codigoUsuario.trim();

		List<Empleadomast> lista = this.listarPorCriterios(
				this.getCriteria().add(Restrictions.eq("codigousuario", codigoUsuario).ignoreCase()));

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

	@Override
	public Empleadomast obtenerEmpleadoMast(Integer p_empleado) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", p_empleado));

		List<Empleadomast> lista = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

	@Override
	public String obtenerNombreCargoEmpleado(Integer par_empleado, String par_compania) {
		EmpleadomastPk pk = new EmpleadomastPk();
		pk.setCompaniasocio(par_compania);
		pk.setEmpleado(par_empleado);
		Empleadomast e = this.obtenerPorId(pk, false);
		HrPuestoempresaPk pkPe = new HrPuestoempresaPk();
		pkPe.setCodigopuesto(e.getCodigocargo());
		HrPuestoempresa pe = daoPuestoEmpresa.obtenerPorId(pkPe);

		if (UValidador.esNulo(pe))
			return "";

		if ((UValidador.esNulo(pe.getCodigocap()) ? "" : pe.getCodigocap()).length() > 0)
			return pe.getDescripcion() + " (" + (UValidador.esNulo(pe.getCodigocap()) ? "" : pe.getCodigocap() + ") ");
		else
			return pe.getDescripcion();
	}

	@Override
	public List listardwList(String sb) {// DtoDwHrEmpleadoSelectMultipleSincia
		StringBuilder sbd = new StringBuilder();

		sbd.append(this.getSesionActual().getNamedQuery("empleadomast.listardwList").getQueryString());

		sbd.append(sb);

		List datos = this.listarPorSentenciaSQL(DtoDwHrEmpleadoSelectMultipleSincia.class, sbd, null);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;
	}

	public List listarEmpleadoEval(String sb) {

		StringBuilder s = new StringBuilder();
		s.append(this.getSesionActual().getNamedQuery("empleadomast.listarEmpleadoEval").getQueryString());

		s.append(sb);
		List datos = this.listarPorSentenciaSQL(DtoDwPrEmpleadoSelect.class, s, null);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BigDecimal obtenerCodigoCargo(Integer empleado) {
		List<Empleadomast> lista = (List) listarPorCriterios(
				getCriteria().add(Restrictions.eq("pk.empleado", empleado)));
		if (!UValidador.esListaVacia(lista)) {
			return UValidador.esNulo(lista.get(0).getCodigocargo()) ? null
					: new BigDecimal(lista.get(0).getCodigocargo());
		}
		return null;
	}

}
