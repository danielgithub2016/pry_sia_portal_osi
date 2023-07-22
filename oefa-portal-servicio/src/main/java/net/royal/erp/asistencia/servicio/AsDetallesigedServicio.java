package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsAutorizacionPreprocesoHextraeditV2;
import net.royal.erp.asistencia.dominio.AsDetallesiged;
import net.royal.erp.asistencia.dominio.AsDetallesigedPk;
import net.royal.erp.asistencia.dominio.dto.DtoBandejaSIGED;
import net.royal.erp.asistencia.dominio.dto.DtoEmpleadoSIGED;
import net.royal.framework.web.servicio.GenericoServicio;

public interface AsDetallesigedServicio extends GenericoServicio {

	public List<AsDetallesiged>listaDetalleSiged(AsDetallesigedPk pk);
	
	public DtoEmpleadoSIGED obtenerBandejas(DtoEmpleadoSIGED detalle,DtoDwAsAutorizacionPreprocesoHextraeditV2 dw_1);
}
