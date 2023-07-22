package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestosimilar;
import net.royal.erp.rrhh.dominio.HrPuestosimilarPk;

public interface HrPuestosimilarServicio extends GenericoServicio {

	public List<HrPuestosimilar> listarPuestosSimilar(Integer codigopuesto);
}
