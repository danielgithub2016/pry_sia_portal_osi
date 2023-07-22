package net.royal.erp.asistencia.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import net.royal.erp.asistencia.dominio.AsPeriodo;
import net.royal.erp.asistencia.dominio.AsPeriodoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsPeriodoDao extends GenericoDao<AsPeriodo, AsPeriodoPk> {
	public boolean validarRangoActivo(Date par_fechadesde,
			Date par_fechahasta, boolean par_mensaje) throws Exception ;
	
	public BigDecimal incrementarPeriodoPlanilla();
	
	/**
	 * Obtener fechas activas.
	 *@powerbuilder f_as_fechasactivas
	 * @return the date[]
	 */
	public Date[] obtenerFechasActivas(String flgadmin)throws ParseException;
}
