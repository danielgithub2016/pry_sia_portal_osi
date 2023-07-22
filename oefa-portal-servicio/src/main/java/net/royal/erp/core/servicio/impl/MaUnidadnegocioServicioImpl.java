package net.royal.erp.core.servicio.impl;

import java.util.List;

import net.royal.erp.core.dao.MaUnidadnegocioDao;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.core.servicio.MaUnidadnegocioServicio;
import net.royal.erp.sistema.dao.SySeguridadautorizacionesDao;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioMaUnidadnegocio")
public class MaUnidadnegocioServicioImpl extends GenericoServicioImpl implements
		MaUnidadnegocioServicio {

	private MaUnidadnegocioDao dao;
	
	private SySeguridadautorizacionesDao daoSySeguridadautorizaciones;

	private static Log LOGGER = LogFactory
			.getLog(MaUnidadnegocioServicioImpl.class);

	@Autowired
	public void setDao(MaUnidadnegocioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<MaUnidadnegocio> obtenerCombo() {
		return dao.obtenerCombo();
	}

	public List<MaUnidadnegocio> listarUnidadNegocio(String par_unidad) {
		return dao.listarUnidadNegocio(par_unidad);
	}

	/**
	 * f_sql_read_unidadnegocio_name
	 */
	@Override
	public String obtenerNombreUnidadNegocio(String par_unidad) {
		return dao.obtenerNombreUnidadNegocio(par_unidad);
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder maunidadnegocio.dw_ma_unidadnegocio_select_security
	 */
	public List<MaUnidadnegocio> DwMaUnidadnegocioSelectSecurity(String par_usuario) {
		
		Criteria criteria= daoSySeguridadautorizaciones.getCriteria();
		criteria.add(Restrictions.eq("pk.aplicacioncodigo", "SY"));
		criteria.add(Restrictions.eq("pk.grupo", "UNIDADNEGOCIO"));
		criteria.add(Restrictions.eq("pk.usuario", par_usuario));
		
		List<SySeguridadautorizaciones> datos=daoSySeguridadautorizaciones.listarPorCriterios(criteria);
		
		String[] seguridadAut = new String[datos.size()+1];
		Integer contador=0;
		
		for (SySeguridadautorizaciones seg : datos) {
			seguridadAut[contador] = seg.getPk().getConcepto();			
			contador++;
		}
		
		LOGGER.debug(seguridadAut);
		
		
		Criteria unidad=dao.getCriteria();
		unidad.add(Restrictions.eq("estado", "A"));
		unidad.add(Restrictions.in("pk.unidadnegocio", seguridadAut));
		
		List<MaUnidadnegocio> lstunidad=dao.listarPorCriterios(unidad);
		
		return lstunidad;
	}

	@Autowired
	public void setDaoSySeguridadautorizaciones(
			SySeguridadautorizacionesDao daoSySeguridadautorizaciones) {
		this.daoSySeguridadautorizaciones = daoSySeguridadautorizaciones;
	}


}
