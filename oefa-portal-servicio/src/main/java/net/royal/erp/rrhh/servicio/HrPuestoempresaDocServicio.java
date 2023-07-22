package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDoc;
import net.royal.erp.rrhh.dominio.HrPuestoempresaDocPk;

public interface HrPuestoempresaDocServicio extends GenericoServicio {

	public List<HrPuestoempresaDoc> listarTabFormatosEvaluacion(Integer codigopuesto);
}
