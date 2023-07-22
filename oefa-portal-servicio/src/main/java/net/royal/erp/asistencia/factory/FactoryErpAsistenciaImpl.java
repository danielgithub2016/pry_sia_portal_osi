package net.royal.erp.asistencia.factory;

import net.royal.erp.asistencia.dominio.AsDetallesiged;
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

public class FactoryErpAsistenciaImpl implements FactoryErpAsistencia {

	private AsAccesosdiariosServicio asAccesosdiariosServicio;

	@Override
	public AsAccesosdiariosServicio getAsAccesosdiariosServicio() {
		return asAccesosdiariosServicio;
	}

	@Override
	public void setAsAccesosdiariosServicio(AsAccesosdiariosServicio asAccesosdiariosServicio) {
		this.asAccesosdiariosServicio = asAccesosdiariosServicio;
	}

	private AsAreaServicio asAreaServicio;

	@Override
	public AsAreaServicio getAsAreaServicio() {
		return asAreaServicio;
	}

	@Override
	public void setAsAreaServicio(AsAreaServicio asAreaServicio) {
		this.asAreaServicio = asAreaServicio;
	}

	private AsCarnetidentificacionServicio asCarnetidentificacionServicio;

	@Override
	public AsCarnetidentificacionServicio getAsCarnetidentificacionServicio() {
		return asCarnetidentificacionServicio;
	}

	@Override
	public void setAsCarnetidentificacionServicio(AsCarnetidentificacionServicio asCarnetidentificacionServicio) {
		this.asCarnetidentificacionServicio = asCarnetidentificacionServicio;
	}

	private AsConceptoaccesoServicio asConceptoaccesoServicio;

	@Override
	public AsConceptoaccesoServicio getAsConceptoaccesoServicio() {
		return asConceptoaccesoServicio;
	}

	@Override
	public void setAsConceptoaccesoServicio(AsConceptoaccesoServicio asConceptoaccesoServicio) {
		this.asConceptoaccesoServicio = asConceptoaccesoServicio;
	}

	private AsConceptoaccesosistemaServicio asConceptoaccesosistemaServicio;

	@Override
	public AsConceptoaccesosistemaServicio getAsConceptoaccesosistemaServicio() {
		return asConceptoaccesosistemaServicio;
	}

	@Override
	public void setAsConceptoaccesosistemaServicio(AsConceptoaccesosistemaServicio asConceptoaccesosistemaServicio) {
		this.asConceptoaccesosistemaServicio = asConceptoaccesosistemaServicio;
	}

	private AsEmpleadoexcepcionServicio asEmpleadoexcepcionServicio;

	@Override
	public AsEmpleadoexcepcionServicio getAsEmpleadoexcepcionServicio() {
		return asEmpleadoexcepcionServicio;
	}

	@Override
	public void setAsEmpleadoexcepcionServicio(AsEmpleadoexcepcionServicio asEmpleadoexcepcionServicio) {
		this.asEmpleadoexcepcionServicio = asEmpleadoexcepcionServicio;
	}

	private AsEmpleadoexcepciondetalleServicio asEmpleadoexcepciondetalleServicio;

	@Override
	public AsEmpleadoexcepciondetalleServicio getAsEmpleadoexcepciondetalleServicio() {
		return asEmpleadoexcepciondetalleServicio;
	}

	@Override
	public void setAsEmpleadoexcepciondetalleServicio(
			AsEmpleadoexcepciondetalleServicio asEmpleadoexcepciondetalleServicio) {
		this.asEmpleadoexcepciondetalleServicio = asEmpleadoexcepciondetalleServicio;
	}

	private AsEmpleadosAutorizadosServicio asEmpleadosAutorizadosServicio;

	@Override
	public AsEmpleadosAutorizadosServicio getAsEmpleadosAutorizadosServicio() {
		return asEmpleadosAutorizadosServicio;
	}

	@Override
	public void setAsEmpleadosAutorizadosServicio(AsEmpleadosAutorizadosServicio asEmpleadosAutorizadosServicio) {
		this.asEmpleadosAutorizadosServicio = asEmpleadosAutorizadosServicio;
	}

	private AsEventoServicio asEventoServicio;

	@Override
	public AsEventoServicio getAsEventoServicio() {
		return asEventoServicio;
	}

	@Override
	public void setAsEventoServicio(AsEventoServicio asEventoServicio) {
		this.asEventoServicio = asEventoServicio;
	}

	private AsEventousuarioServicio asEventousuarioServicio;

	@Override
	public AsEventousuarioServicio getAsEventousuarioServicio() {
		return asEventousuarioServicio;
	}

	@Override
	public void setAsEventousuarioServicio(AsEventousuarioServicio asEventousuarioServicio) {
		this.asEventousuarioServicio = asEventousuarioServicio;
	}

	private AsIntervaloaccesoServicio asIntervaloaccesoServicio;

	@Override
	public AsIntervaloaccesoServicio getAsIntervaloaccesoServicio() {
		return asIntervaloaccesoServicio;
	}

	@Override
	public void setAsIntervaloaccesoServicio(AsIntervaloaccesoServicio asIntervaloaccesoServicio) {
		this.asIntervaloaccesoServicio = asIntervaloaccesoServicio;
	}

	private AsPeriodoServicio asPeriodoServicio;

	@Override
	public AsPeriodoServicio getAsPeriodoServicio() {
		return asPeriodoServicio;
	}

	@Override
	public void setAsPeriodoServicio(AsPeriodoServicio asPeriodoServicio) {
		this.asPeriodoServicio = asPeriodoServicio;
	}

	private AsTipodiaasistenciaServicio asTipodiaasistenciaServicio;

	@Override
	public AsTipodiaasistenciaServicio getAsTipodiaasistenciaServicio() {
		return asTipodiaasistenciaServicio;
	}

	@Override
	public void setAsTipodiaasistenciaServicio(AsTipodiaasistenciaServicio asTipodiaasistenciaServicio) {
		this.asTipodiaasistenciaServicio = asTipodiaasistenciaServicio;
	}

	private AsTipodiamovimientoServicio asTipodiamovimientoServicio;

	@Override
	public AsTipodiamovimientoServicio getAsTipodiamovimientoServicio() {
		return asTipodiamovimientoServicio;
	}

	@Override
	public void setAsTipodiamovimientoServicio(AsTipodiamovimientoServicio asTipodiamovimientoServicio) {
		this.asTipodiamovimientoServicio = asTipodiamovimientoServicio;
	}

	private AsTipohorarioServicio asTipohorarioServicio;

	@Override
	public AsTipohorarioServicio getAsTipohorarioServicio() {
		return asTipohorarioServicio;
	}

	@Override
	public void setAsTipohorarioServicio(AsTipohorarioServicio asTipohorarioServicio) {
		this.asTipohorarioServicio = asTipohorarioServicio;
	}

	private AsAutorizacionServicio asAutorizacionServicio;

	@Override
	public AsAutorizacionServicio getAsAutorizacionServicio() {
		return asAutorizacionServicio;
	}

	@Override
	public void setAsAutorizacionServicio(AsAutorizacionServicio asAutorizacionServicio) {
		this.asAutorizacionServicio = asAutorizacionServicio;
	}

	private FactoryErpAs factoryErpAs;

	@Override
	public FactoryErpAs getAS() {
		return factoryErpAs;
	}

	@Override
	public void setAS(FactoryErpAs factoryErpAs) {
		this.factoryErpAs = factoryErpAs;
	}

	private TerminalServicio terminalServicio;

	@Override
	public TerminalServicio getTerminalServicio() {
		return terminalServicio;
	}

	@Override
	public void setTerminalServicio(TerminalServicio terminalServicio) {
		this.terminalServicio = terminalServicio;
	}

	private AsAsistenciadiariaServicio asAsistenciadiariaServicio;

	@Override
	public AsAsistenciadiariaServicio getAsAsistenciadiariaServicio() {
		return asAsistenciadiariaServicio;
	}

	@Override
	public void setAsAsistenciadiariaServicio(AsAsistenciadiariaServicio asAsistenciadiariaServicio) {
		this.asAsistenciadiariaServicio = asAsistenciadiariaServicio;
	}

	private AsEmpleadoexcepcionsolicitudServicio asEmpleadoexcepcionsolicitudServicio;

	@Override
	public AsEmpleadoexcepcionsolicitudServicio getAsEmpleadoexcepcionsolicitudServicio() {
		return asEmpleadoexcepcionsolicitudServicio;
	}

	@Override
	public void setAsEmpleadoexcepcionsolicitudServicio(
			AsEmpleadoexcepcionsolicitudServicio asEmpleadoexcepcionsolicitudServicio) {
		this.asEmpleadoexcepcionsolicitudServicio = asEmpleadoexcepcionsolicitudServicio;
	}

	private AsAutorizacionfechaServicio asAutorizacionfechaServicio;

	@Override
	public AsAutorizacionfechaServicio getAsAutorizacionfechaServicio() {
		return asAutorizacionfechaServicio;
	}

	@Override
	public void setAsAutorizacionfechaServicio(AsAutorizacionfechaServicio asAutorizacionfechaServicio) {
		this.asAutorizacionfechaServicio = asAutorizacionfechaServicio;
	}

	private AsDetallesigedServicio asDetallesigedServicio;

	@Override
	public AsDetallesigedServicio getAsDetallesigedServicio() {
		return asDetallesigedServicio;
	}

	@Override
	public void setAsDetallesigedServicio(AsDetallesigedServicio asDetallesigedServicio) {
		this.asDetallesigedServicio = asDetallesigedServicio;
	}

	

}
