package net.royal.erp.asistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionsolicitudDao;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitud;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionsolicitudPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AsEmpleadoexcepcionsolicitudDaoImpl
		extends
		GenericoDaoImpl<AsEmpleadoexcepcionsolicitud, AsEmpleadoexcepcionsolicitudPk>
		implements AsEmpleadoexcepcionsolicitudDao {

	private static Log LOGGER = LogFactory
			.getLog(AsEmpleadoexcepcionsolicitud.class);

	public AsEmpleadoexcepcionsolicitudDaoImpl() {
		super("asempleadoexcepcionsolicitud");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<AsEmpleadoexcepcionsolicitud> listarEmpleadoExcepcionSolicitud(Integer p_empleado,
			Date p_fechasolicitud) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", p_empleado));
		cri.add(Restrictions.eq("pk.fechasolicitud", p_fechasolicitud));

		List<AsEmpleadoexcepcionsolicitud> lista = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(lista))
			return null;
		
		for (AsEmpleadoexcepcionsolicitud obj : lista) {
			obj.setAuxHoras(0.00);
		}

		return lista;
	}
}
