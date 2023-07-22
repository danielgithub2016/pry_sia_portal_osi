package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.rrhh.dominio.HrDncSolicitante;
import net.royal.erp.rrhh.dominio.HrDncSolicitantePk;

public interface HrDncSolicitanteServicio extends GenericoServicio {

	public Integer cantHrDncSolicitantePuesto(String wsbuscar1,
			String wsbuscar2, String wsbuscar3, String wsbuscar4);

	public Integer cantHrDncSolicitanteArea(String wsbuscar1, String wsbuscar2,
			String wsbuscar3, String wsbuscar4);

	public Integer obtenerMaximoSolicitante(String iv_compania);

	public Integer obtenerSecuencia(String iv_compania, String estado,
			Integer wiCurso);

	public void grabarDncSolicitanteArea(String wsflagpuesto, String wsPuesto,
			String wsflagarea, String wsArea, String iv_compania,
			Integer wiSecuencia);
	
	public void insertarDncSolicitante(HrDncSolicitante solicitante);

}
