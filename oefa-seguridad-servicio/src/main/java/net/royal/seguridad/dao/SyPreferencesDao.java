package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.SyPreferences;
import net.royal.seguridad.dominio.SyPreferencesPk;

public interface SyPreferencesDao extends
		GenericoDao<SyPreferences, SyPreferencesPk> {
	public String obtenerValorString(String usuario, String preference);
}
