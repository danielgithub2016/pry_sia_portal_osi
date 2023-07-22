package net.royal.erp.asistencia.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsPeriodoDao;
import net.royal.erp.asistencia.dominio.AsPeriodo;
import net.royal.erp.asistencia.dominio.AsPeriodoPk;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
public class AsPeriodoDaoImpl extends GenericoDaoImpl<AsPeriodo, AsPeriodoPk>
		implements AsPeriodoDao {

	private static Log LOGGER = LogFactory.getLog(AsPeriodo.class);

	public AsPeriodoDaoImpl() {
		super("asperiodo");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asmain.f_as_validar_rango_activo
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean validarRangoActivo(Date par_fechadesde, Date par_fechahasta,
			boolean par_mensaje) throws Exception {
		BigDecimal wRegistrosEncontrados;

		par_fechadesde = UFechaHora.obtenerFechaHoraInicioDia(par_fechadesde);
		par_fechahasta = UFechaHora.obtenerFechaHoraInicioDia(par_fechahasta);

		Criteria cri = this
				.getCriteria()
				.add(Restrictions.and(Restrictions.eq("estado", "A"),
						Restrictions.and(
								Restrictions.ge("fechahasta", par_fechadesde),
								Restrictions.le("fechadesde", par_fechadesde)),
						Restrictions.and(
								Restrictions.ge("fechahasta", par_fechahasta),
								Restrictions.le("fechadesde", par_fechahasta))));

		List res = cri.list();

		if (UValidador.esNulo(res))
			wRegistrosEncontrados = BigDecimal.ZERO;
		else if (UValidador.esListaVacia(res))
			wRegistrosEncontrados = BigDecimal.ZERO;
		else
			wRegistrosEncontrados = new BigDecimal(res.size());

		if (wRegistrosEncontrados.compareTo(BigDecimal.ZERO) == 0)
			return false;

		return true;
	}

	@Override
	public BigDecimal incrementarPeriodoPlanilla() {
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.eq("estado", "A"))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("periodoplanilla")));
		return this.incrementarBigDecimal(cri);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Date[] obtenerFechasActivas(String flgadmin) throws ParseException {
		Date resultado[] = new Date[2];
		Date fechadesde, fechahasta;

		fechadesde = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
				.parse("01/01/1990 00:00:00");
		fechahasta = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
				.parse("01/01/2040 23:59:59");

		ProjectionList plist = Projections.projectionList();
		plist.add(Projections.min("fechadesde"));
		plist.add(Projections.max("fechahasta"));
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.eq((flgadmin.equals("S") ? "estado"
						: "estadoprog"), "A")).setProjection(plist);

		List lista = cri.list();

		if (!UValidador.esListaVacia(lista)) {
			Object[] res = (Object[]) lista.get(0);
			if (!UValidador.esNulo(res)) {
				if (res.length > 1) {
					fechadesde = (Date) res[0];
					fechahasta = (Date) res[1];
				}
			}
		} else {
			fechadesde = new Date();
			fechahasta = new Date();
		}

		resultado[0] = fechadesde;
		resultado[1] = fechahasta;

		return resultado;
	}

}
