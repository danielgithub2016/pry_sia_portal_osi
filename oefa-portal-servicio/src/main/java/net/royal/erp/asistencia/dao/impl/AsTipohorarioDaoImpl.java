package net.royal.erp.asistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionDao;
import net.royal.erp.asistencia.dao.AsTipohorarioDao;
import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipohorario;
import net.royal.erp.asistencia.dominio.AsTipohorarioPk;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
public class AsTipohorarioDaoImpl extends
		GenericoDaoImpl<AsTipohorario, AsTipohorarioPk> implements
		AsTipohorarioDao {

	private static Log LOGGER = LogFactory.getLog(AsTipohorario.class);

	private AsEmpleadoexcepcionDao daoEmpleadoExcepcion;
	private EmpleadomastDao daoEmpleadoMast;

	public AsTipohorarioDaoImpl() {
		super("astipohorario");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public Integer devuelveHorario(Integer parEmpleado, Date parFecha) {
		Integer tipoHorarioRows;
		List<AsTipohorario> tipoHorarioList;

		tipoHorarioList = this.listarPorCriterios(this.getCriteria());
		tipoHorarioRows = UValidador.esListaVacia(tipoHorarioList) ? 0
				: tipoHorarioList.size();

		Integer tipoDia, tipoHorario;
		AsTipohorario tipoHorarioRow = null;
		tipoDia = daoEmpleadoExcepcion.obtenerTieneProgramacion(parEmpleado,
				parFecha);

		if (UValidador.esNulo(tipoDia))
			tipoDia = 0;

		if (tipoDia == 0) {
			List<Empleadomast> emp = daoEmpleadoMast
					.listarPorCriterios(daoEmpleadoMast.getCriteria().add(
							Restrictions.eq("pk.empleado", parEmpleado)));
			tipoHorario = UValidador.esListaVacia(emp) ? 0 : emp.get(0)
					.getTipohorario();

			if ((UValidador.esNulo(tipoHorario) ? 0 : tipoHorario) > 0) {
				for (AsTipohorario th : tipoHorarioList) {
					if (th.getPk().getTipohorario() == tipoHorario)
						tipoHorarioRow = th;
				}

				if (!UValidador.esNulo(tipoHorarioRow)) {
					if (parEmpleado == 90) {
					}

					Integer lvdia;
					String lvnombre;
					lvdia = UFechaHora.obtenerNumeroDiaSemana(parFecha);
					lvnombre = UFechaHora.obtenerDiaEnCadena(UValidador
							.esNulo(lvdia) ? 0 : lvdia);

					lvdia = UValidador.esNulo(lvdia) ? 0 : lvdia;

					if (!UValidador.estaVacio(lvnombre))
						tipoDia = lvdia == 1 ? tipoHorarioRow.getDomingo()
								: lvdia == 2 ? tipoHorarioRow.getLunes()
										: lvdia == 3 ? tipoHorarioRow
												.getMartes()
												: lvdia == 4 ? tipoHorarioRow
														.getMiercoles()
														: lvdia == 5 ? tipoHorarioRow
																.getJueves()
																: lvdia == 6 ? tipoHorarioRow
																		.getViernes()
																		: lvdia == 7 ? tipoHorarioRow
																				.getSabado()
																				: 0;
				} else
					return 0;

				return tipoDia;
			} else
				return 0;
		} else
			return tipoDia;
	}

	@Override
	public String obtenerDescripcionLocal(Integer tipohorario) {
		// TODO Auto-generated method stub

		String descripcionlocal = null;

		List<AsTipohorario> lstTipoHorario = listarPorCriterios(getCriteria()
				.add(Restrictions.eq("pk.tipohorario", tipohorario)));

		if (!UValidador.esListaVacia(lstTipoHorario)) {
			descripcionlocal = lstTipoHorario.get(0).getDescripcionlocal();
		}

		return descripcionlocal;

	}

	@Autowired
	public void setDaoEmpleadoExcepcion(
			AsEmpleadoexcepcionDao daoEmpleadoExcepcion) {
		this.daoEmpleadoExcepcion = daoEmpleadoExcepcion;
	}

	@Autowired
	public void setDaoEmpleadoMast(EmpleadomastDao daoEmpleadoMast) {
		this.daoEmpleadoMast = daoEmpleadoMast;
	}

	@Override
	public List<AsTipohorario> listarTipoHorarioOrden() {
		Criteria c = this.getCriteria();
		
		c.addOrder(Order.asc("pk.tipohorario"));
		List<AsTipohorario> lista = this.listarPorCriterios(c);
		
		if(UValidador.estaVacio(lista))
			return null;
		
		return lista;
	}



}
