package net.royal.erp.asistencia.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.asistencia.dao.AsAsistenciadiariaDao;
import net.royal.erp.asistencia.dominio.AsAsistenciadiaria;
import net.royal.erp.asistencia.dominio.AsAsistenciadiariaPk;
import net.royal.erp.asistencia.dominio.dto.DtoFiltrosGenericos;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

@Repository
public class AsAsistenciadiariaDaoImpl extends GenericoDaoImpl<AsAsistenciadiaria, AsAsistenciadiariaPk> implements AsAsistenciadiariaDao {

	private static Log LOGGER = LogFactory.getLog(AsAsistenciadiaria.class);

	public AsAsistenciadiariaDaoImpl() {
		super("asasistenciadiaria");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List obtenerEmpleadosSeleccionados(Date p_fecha_desde, Date p_fecha_hasta, String p_flag_periodo,
			Integer p_sid,String p_seleccionadosAdicionados) {
		List<DtoFiltrosGenericos> resultado;
		String query = obtenerSentenciaSqlPorQuery("asasistenciadiaria.obtenerEmpleadosSeleccionados");
		List<ParametroPersistenciaGenerico>parametros= new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("p_fecha_desde", Date.class, p_fecha_desde));
		parametros.add(new ParametroPersistenciaGenerico("p_fecha_hasta",  Date.class, p_fecha_hasta));
		parametros.add(new ParametroPersistenciaGenerico("p_flag_periodo", String.class, p_flag_periodo));
		parametros.add(new ParametroPersistenciaGenerico("p_sid", BigDecimal.class, p_sid));


		if (!UValidador.estaVacio(p_seleccionadosAdicionados)) {
			query = query.replace("[FILTROADICIONALES]", p_seleccionadosAdicionados );
		} else {
			query = query.replace("[FILTROADICIONALES]", "");
		}

		List data = listarPorSentenciaSQL(DtoFiltrosGenericos.class, new StringBuilder(query), parametros);
		resultado = data;
		return resultado;
		
		
	}

}
