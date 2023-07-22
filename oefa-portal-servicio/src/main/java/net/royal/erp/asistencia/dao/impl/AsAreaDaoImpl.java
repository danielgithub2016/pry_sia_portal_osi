package net.royal.erp.asistencia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsAreaDao;
import net.royal.erp.asistencia.dominio.AsArea;
import net.royal.erp.asistencia.dominio.AsAreaPk;
import net.royal.erp.asistencia.servicio.AsAreaServicio;
import net.royal.erp.contabilidad.dominio.AcCostcentermst;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AsAreaDaoImpl extends GenericoDaoImpl<AsArea, AsAreaPk> implements
		AsAreaDao {

	private static Log LOGGER = LogFactory.getLog(AsArea.class);

	private EmpleadomastDao daoEmpleadomast;

	public AsAreaDaoImpl() {
		super("asarea");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerAreaOperativa(Integer par_empleado, String par_compania) {

		String nombreArea = "";

		EmpleadomastPk pk = new EmpleadomastPk();
		pk.setCompaniasocio(par_compania);
		pk.setEmpleado(par_empleado);
		Empleadomast e = daoEmpleadomast.obtenerPorId(pk, false);

		AsAreaPk pka = new AsAreaPk();
		pka.setArea(e.getDptoareaoperativa());

		AsArea area = this.obtenerPorId(pka, false);

		if (!UValidador.esNulo(area)) {
			nombreArea = area.getNombre();
		}
		return nombreArea;
	}

	@Override
	public AsArea obtenerArea(Integer par_empleado, String par_compania) {

		EmpleadomastPk pk = new EmpleadomastPk();
		pk.setCompaniasocio(par_compania);
		pk.setEmpleado(par_empleado);
		Empleadomast e = daoEmpleadomast.obtenerPorId(pk, false);

		AsAreaPk pka = new AsAreaPk();
		pka.setArea(e.getDptoareaoperativa());

		AsArea area = this.obtenerPorId(pka, false);

		return area;
	}

	@Autowired
	public void setDaoEmpleadomast(EmpleadomastDao daoEmpleadomast) {
		this.daoEmpleadomast = daoEmpleadomast;
	}

	@Override
	public List<AsArea> listaComboAreaServicio() {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("nombre"));

		List<AsArea> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}

	@Override
	public AsArea obtenerAreaEmpleadoResponsable(Integer empleado) {
		// TODO Auto-generated method stub
		AsArea resultado = null;

		Criteria cri = getCriteria();
		cri.add(Restrictions.disjunction()
				.add(Restrictions.eq("empleadoresponsable", empleado))
				.add(Restrictions.eq("empleadoresponsable2", empleado))
				.add(Restrictions.eq("empleadoresponsable3", empleado))
				.add(Restrictions.eq("empleadoresponsable4", empleado)));

		List<AsArea> data = listarPorCriterios(cri);

		if (!UValidador.esListaVacia(data)) {
			resultado = data.get(0);
		}

		return resultado;
	}

}
