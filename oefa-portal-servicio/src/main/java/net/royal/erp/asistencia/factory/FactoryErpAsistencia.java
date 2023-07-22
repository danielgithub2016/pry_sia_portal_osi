package net.royal.erp.asistencia.factory;

import java.util.List;

import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.erp.asistencia.servicio.AsAccesosdiariosServicio;
import net.royal.erp.asistencia.servicio.AsAreaServicio;
import net.royal.erp.asistencia.servicio.AsAsistenciadiariaServicio;
import net.royal.erp.asistencia.servicio.AsAutorizacionServicio;
import net.royal.erp.asistencia.servicio.AsAutorizacionfechaServicio;
import net.royal.erp.asistencia.servicio.AsCarnetidentificacionServicio;
import net.royal.erp.asistencia.servicio.AsConceptoaccesoServicio;
import net.royal.erp.asistencia.servicio.AsConceptoaccesosistemaServicio;
import net.royal.erp.asistencia.servicio.AsDetallesigedServicio;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepcionServicio;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepciondetalleServicio;
import net.royal.erp.asistencia.servicio.AsEmpleadoexcepcionsolicitudServicio;
import net.royal.erp.asistencia.servicio.AsEmpleadosAutorizadosServicio;
import net.royal.erp.asistencia.servicio.AsEventoServicio;
import net.royal.erp.asistencia.servicio.AsEventousuarioServicio;
import net.royal.erp.asistencia.servicio.AsIntervaloaccesoServicio;
import net.royal.erp.asistencia.servicio.AsPeriodoServicio;
import net.royal.erp.asistencia.servicio.AsTipodiaasistenciaServicio;
import net.royal.erp.asistencia.servicio.AsTipodiamovimientoServicio;
import net.royal.erp.asistencia.servicio.AsTipohorarioServicio;
import net.royal.erp.asistencia.servicio.TerminalServicio;

public interface FactoryErpAsistencia {
	
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AS
	 */
	public FactoryErpAs getAS();

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AS
	 */
	/**
	 * @param FactoryErpAs
	 */
	public void setAS(FactoryErpAs FactoryErpAs);
	
	public AsDetallesigedServicio getAsDetallesigedServicio();
	public void setAsDetallesigedServicio(AsDetallesigedServicio asDetallesigedServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsAccesosdiarios
	 */
	public AsAccesosdiariosServicio getAsAccesosdiariosServicio();

	public void setAsAccesosdiariosServicio(
			AsAccesosdiariosServicio asAccesosdiariosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsArea
	 */
	public AsAreaServicio getAsAreaServicio();

	public void setAsAreaServicio(AsAreaServicio asAreaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsCarnetidentificacion
	 */
	public AsCarnetidentificacionServicio getAsCarnetidentificacionServicio();

	public void setAsCarnetidentificacionServicio(
			AsCarnetidentificacionServicio asCarnetidentificacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsConceptoacceso
	 */
	public AsConceptoaccesoServicio getAsConceptoaccesoServicio();

	public void setAsConceptoaccesoServicio(
			AsConceptoaccesoServicio asConceptoaccesoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsConceptoaccesosistema
	 */
	public AsConceptoaccesosistemaServicio getAsConceptoaccesosistemaServicio();

	public void setAsConceptoaccesosistemaServicio(
			AsConceptoaccesosistemaServicio asConceptoaccesosistemaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEmpleadoexcepcion
	 */
	public AsEmpleadoexcepcionServicio getAsEmpleadoexcepcionServicio();

	public void setAsEmpleadoexcepcionServicio(
			AsEmpleadoexcepcionServicio asEmpleadoexcepcionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEmpleadoexcepciondetalle
	 */
	public AsEmpleadoexcepciondetalleServicio getAsEmpleadoexcepciondetalleServicio();

	public void setAsEmpleadoexcepciondetalleServicio(
			AsEmpleadoexcepciondetalleServicio asEmpleadoexcepciondetalleServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEmpleadosAutorizados
	 */
	public AsEmpleadosAutorizadosServicio getAsEmpleadosAutorizadosServicio();

	public void setAsEmpleadosAutorizadosServicio(
			AsEmpleadosAutorizadosServicio asEmpleadosAutorizadosServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEvento
	 */
	public AsEventoServicio getAsEventoServicio();

	public void setAsEventoServicio(AsEventoServicio asEventoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEventousuario
	 */
	public AsEventousuarioServicio getAsEventousuarioServicio();

	public void setAsEventousuarioServicio(
			AsEventousuarioServicio asEventousuarioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsIntervaloacceso
	 */
	public AsIntervaloaccesoServicio getAsIntervaloaccesoServicio();

	public void setAsIntervaloaccesoServicio(
			AsIntervaloaccesoServicio asIntervaloaccesoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsPeriodo
	 */
	public AsPeriodoServicio getAsPeriodoServicio();

	public void setAsPeriodoServicio(AsPeriodoServicio asPeriodoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsTipodiaasistencia
	 */
	public AsTipodiaasistenciaServicio getAsTipodiaasistenciaServicio();

	public void setAsTipodiaasistenciaServicio(
			AsTipodiaasistenciaServicio asTipodiaasistenciaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsTipodiamovimiento
	 */
	public AsTipodiamovimientoServicio getAsTipodiamovimientoServicio();

	public void setAsTipodiamovimientoServicio(
			AsTipodiamovimientoServicio asTipodiamovimientoServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsTipohorario
	 */
	public AsTipohorarioServicio getAsTipohorarioServicio();

	public void setAsTipohorarioServicio(
			AsTipohorarioServicio asTipohorarioServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsAutorizacion
	 */
	public AsAutorizacionServicio getAsAutorizacionServicio();

	public void setAsAutorizacionServicio(
			AsAutorizacionServicio asAutorizacionServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.terminal
	 */
	public TerminalServicio getTerminalServicio();

	public void setTerminalServicio(TerminalServicio terminalServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsAsistenciadiaria
	 */
	public AsAsistenciadiariaServicio getAsAsistenciadiariaServicio();

	public void setAsAsistenciadiariaServicio(
			AsAsistenciadiariaServicio asAsistenciadiariaServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsEmpleadoexcepcionsolicitud
	 */
	public AsEmpleadoexcepcionsolicitudServicio getAsEmpleadoexcepcionsolicitudServicio();

	public void setAsEmpleadoexcepcionsolicitudServicio(
			AsEmpleadoexcepcionsolicitudServicio asEmpleadoexcepcionsolicitudServicio);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asistencia.AsAutorizacionfecha
	 */
	public AsAutorizacionfechaServicio getAsAutorizacionfechaServicio();

	public void setAsAutorizacionfechaServicio(
			AsAutorizacionfechaServicio asAutorizacionfechaServicio);

}
