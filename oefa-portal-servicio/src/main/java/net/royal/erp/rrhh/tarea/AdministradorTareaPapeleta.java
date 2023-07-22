package net.royal.erp.rrhh.tarea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.royal.erp.asistencia.factory.FactoryErpAsistencia;

public class AdministradorTareaPapeleta {
	private static Log LOGGER = LogFactory.getLog(AdministradorTareaPapeleta.class);
	private FactoryErpAsistencia facAsistencia;

	public void ejecutar() {
		LOGGER.debug("Ejecucion del servio de papeletas");

		/* llamar al servicio de alertas */
		try {
			//getFacAsistencia().getAsAutorizacionServicio().generarAsistenciaOnomastico();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FactoryErpAsistencia getFacAsistencia() {
		return facAsistencia;
	}

	public void setFacAsistencia(FactoryErpAsistencia facAsistencia) {
		this.facAsistencia = facAsistencia;
	}

}
