package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.asistencia.dominio.AsTipodiaasistencia;
import net.royal.erp.asistencia.dominio.AsTipodiaasistenciaPk;

public interface AsTipodiaasistenciaServicio extends GenericoServicio {

	public List<AsTipodiaasistencia> listarTipoDiaAsistencia();
}
