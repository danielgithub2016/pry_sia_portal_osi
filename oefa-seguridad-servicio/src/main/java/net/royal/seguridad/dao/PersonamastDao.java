package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Personamast;
import net.royal.seguridad.dominio.PersonamastPk;

public interface PersonamastDao extends GenericoDao<Personamast, PersonamastPk> {

	public Personamast obtenerPorUsuario(String usuario);

}
