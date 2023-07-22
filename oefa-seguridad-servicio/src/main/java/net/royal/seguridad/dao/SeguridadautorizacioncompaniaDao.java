package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Seguridadautorizacioncompania;
import net.royal.seguridad.dominio.SeguridadautorizacioncompaniaPk;

public interface SeguridadautorizacioncompaniaDao
		extends GenericoDao<Seguridadautorizacioncompania, SeguridadautorizacioncompaniaPk> {

	public String obtenerCompania(String codigousuario);

}
