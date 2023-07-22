package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.CompaniamastDao;
import net.royal.erp.core.servicio.CompaniamastServicio;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;
import net.royal.erp.core.dominio.dto.DtoCompaniamast;

@Service(value = "BeanServicioCompaniamast")
public class CompaniamastServicioImpl extends GenericoServicioImpl implements CompaniamastServicio {

	private CompaniamastDao dao;

	private static Log LOGGER = LogFactory.getLog(CompaniamastServicioImpl.class);

	@Autowired
	public void setDao(CompaniamastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerNombreCompania(String par_company) {
		return dao.obtenerNombreCompania(par_company);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DtoCompaniamast> listaCompaniaSeguridadPorUsuario(String Usuario) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("usuario", String.class, Usuario));
		return (List)dao.listarPorQuery(DtoCompaniamast.class, "companiamast.dwmacompanyownerselectsecurity", parametros);
	}

}
