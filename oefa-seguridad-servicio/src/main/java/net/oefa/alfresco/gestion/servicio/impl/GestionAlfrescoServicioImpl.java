package net.oefa.alfresco.gestion.servicio.impl;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.oefa.alfresco.gestion.servicio.GestionAlfrescoServicio;
import net.royal.alfresco.ws.ContenidoECMBean;
import net.royal.alfresco.ws.RptaWsBean;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.ParametrosmastDao;
import net.royal.seguridad.dominio.ParametrosmastPk;
import pe.gob.oefa.ws.alfresco.service.UOsinergminAlfresco;

@Service(value = "BeanServicioSeguridadAlfresco")
@Transactional
public class GestionAlfrescoServicioImpl extends GenericoServicioImpl implements GestionAlfrescoServicio {

	private static Log LOGGER = LogFactory.getLog(GestionAlfrescoServicioImpl.class);

	private ParametrosmastDao parametrosmastDao;

	private UOsinergminAlfresco uOsinergminAlfresco;

	@Autowired
	public void setDao(ParametrosmastDao parametrosmastDao) {
		this.parametrosmastDao = parametrosmastDao;
	}

	@Override
	public String transferirDocumentos(String uiddalfresoc, String carpetadestino, String nombrearchivo)
			throws Exception {
		// TODO Auto-generated method stub
		String key = parametrosmastDao.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "KEYALFRESC"));
		String ws = parametrosmastDao.obtenerValorExplicacion(new ParametrosmastPk("SP", "999999", "WSALFRESCO"));

		if (UValidador.estaVacio(key) || UValidador.estaVacio(ws)) {
			return "NOTFOUNDKEY";
		}

		if (!UValidador.estaVacio(uiddalfresoc)) {
			try {
				ContenidoECMBean respuestaconsulta = getuOsinergminAlfresco().obtenerDocumento(uiddalfresoc);
				LOGGER.debug(respuestaconsulta);
				if (respuestaconsulta.getCodMsg().equalsIgnoreCase("ok")) {
					LOGGER.debug("Se encontro el archivo");
					LOGGER.debug("Se elimino el archivo");
					if (!UValidador.estaVacio(carpetadestino)) {

						LOGGER.debug("Archivo a guardar " + carpetadestino);
						File file = new File(UAplicacion.getRealPath() + File.separator + "temporaloefa"
								+ File.separator + nombrearchivo);
						FileUtils.writeByteArrayToFile(file, respuestaconsulta.getContenidoFile());

						RptaWsBean respuestaws = getuOsinergminAlfresco().registrarDocumento(nombrearchivo,
								carpetadestino, file);
						System.gc();
						LOGGER.debug(respuestaws);
						if (respuestaws.getCodMsg().equalsIgnoreCase("ok")) {
							return respuestaws.getUuid();
						} else {
							return respuestaws.getCadMsg();
						}

					}
				}
			} catch (Exception e) {
				return "ERRORWS";
			}
		}
		return null;

	}

	public UOsinergminAlfresco getuOsinergminAlfresco() {
		if (UValidador.esNulo(uOsinergminAlfresco)) {
			uOsinergminAlfresco = new UOsinergminAlfresco();
		}
		return uOsinergminAlfresco;
	}

	public void setuOsinergminAlfresco(UOsinergminAlfresco uOsinergminAlfresco) {
		this.uOsinergminAlfresco = uOsinergminAlfresco;
	}

}
