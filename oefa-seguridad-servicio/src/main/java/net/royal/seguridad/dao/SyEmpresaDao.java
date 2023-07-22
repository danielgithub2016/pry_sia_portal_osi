package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.SyEmpresa;
import net.royal.seguridad.dominio.SyEmpresaPk;

public interface SyEmpresaDao extends GenericoDao<SyEmpresa, SyEmpresaPk> {
	public String obtenerPais(String empresa);
}
