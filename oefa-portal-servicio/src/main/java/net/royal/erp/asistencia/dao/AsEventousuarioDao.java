package net.royal.erp.asistencia.dao;

import java.math.BigDecimal;

import net.royal.erp.asistencia.dominio.AsEventousuario;
import net.royal.erp.asistencia.dominio.AsEventousuarioPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AsEventousuarioDao extends
		GenericoDao<AsEventousuario, AsEventousuarioPk> {
	
	public BigDecimal incrementarEventoUsuario(String userId);

}
