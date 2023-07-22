package net.royal.erp.asistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsEmpleadoexcepcionDao;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcion;
import net.royal.erp.asistencia.dominio.AsEmpleadoexcepcionPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AsEmpleadoexcepcionDaoImpl extends
		GenericoDaoImpl<AsEmpleadoexcepcion, AsEmpleadoexcepcionPk> implements
		AsEmpleadoexcepcionDao {

	private static Log LOGGER = LogFactory.getLog(AsEmpleadoexcepcion.class);

	public AsEmpleadoexcepcionDaoImpl() {
		super("asempleadoexcepcion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Integer obtenerTieneProgramacion(Integer parEmpleado, Date parFecha) {
		Integer ildia = null;
		String hql = "SELECT NVL( MAX(aexd.tipodia),0 ) "
				+ "FROM  AsEmpleadoexcepcion aex , AsEmpleadoexcepciondetalle aexd  "
				+ "WHERE aex.pk.empleado = :parempleado "
				+ "AND aex.pk.fecha <= :sldate  "
				+ "AND aex.pk.fechahasta >= :sldate  "
				+ "AND aex.pk.fecha = aexd.pk.fecha  "
				+ "AND aex.pk.empleado = aexd.pk.empleado  "
				+ "AND aex.clasehorario = 'D' "
				+ "AND aex.clasehorario = aexd.clasehorario ";
		List res = this.getSesionActual().createQuery(hql)
				.setInteger("parempleado", parEmpleado)
				.setDate("sldate", parFecha).list();
		
		if(UValidador.esListaVacia(res))
			ildia =0;
		else{
			if(res.get(0) instanceof Long){
				ildia =((Long) res.get(0)).intValue();
			}else if(res.get(0) instanceof Integer){
				ildia =(Integer) res.get(0);
			}
		}
		
		return ildia;
	}

}
