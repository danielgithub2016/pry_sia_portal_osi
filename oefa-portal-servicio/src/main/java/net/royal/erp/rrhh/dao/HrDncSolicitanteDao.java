package net.royal.erp.rrhh.dao;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.GenericoDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dominio.HrDncSolicitante;
import net.royal.erp.rrhh.dominio.HrDncSolicitantePk;
import net.royal.erp.rrhh.dominio.dto.DtoPuestoCapacitacion;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public interface HrDncSolicitanteDao extends GenericoDao<HrDncSolicitante, HrDncSolicitantePk> {
	
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
	
	public void insertarHrPuestoNecesidadCapacita(String compania,Integer secuencia ,Integer puesto);
	
	public List<DtoPuestoCapacitacion> obtenerPuestoCapacitacion(String compania, Integer secuencia);


}
