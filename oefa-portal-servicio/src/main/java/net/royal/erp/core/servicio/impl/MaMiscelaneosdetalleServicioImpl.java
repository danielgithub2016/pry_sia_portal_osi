package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.dto.DtoMaMiscelaneosdetalle;
import net.royal.erp.core.servicio.MaMiscelaneosdetalleServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioMaMiscelaneosdetalle")
public class MaMiscelaneosdetalleServicioImpl extends GenericoServicioImpl
		implements MaMiscelaneosdetalleServicio {

	private MaMiscelaneosdetalleDao dao;

	private static Log LOGGER = LogFactory
			.getLog(MaMiscelaneosdetalleServicioImpl.class);

	@Autowired
	public void setDao(MaMiscelaneosdetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<MaMiscelaneosdetalle> ListarMiscelaneosdetalle() {
		return dao.ListarMiscelaneosdetalle();
	}

	@Override
	public String obtenerValorCodigo(String aplicacionCodigo, String compania,
			String codigoTabla, String descripcionlocal) {
		return dao.obtenerValorCodigo(aplicacionCodigo, compania, codigoTabla,
				descripcionlocal);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String obtenerDescripcionMiscelaneosXParam(String par_companyowner,
			String par_aplicacion, String par_tabla, String par_codigoelemento) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner",
				String.class, par_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_aplicacion",
				String.class, par_aplicacion));
		parametros.add(new ParametroPersistenciaGenerico("par_tabla",
				String.class, par_tabla));
		parametros.add(new ParametroPersistenciaGenerico("par_codigoelemento",
				String.class, par_codigoelemento));

		List<DtoMaMiscelaneosdetalle> lista = (List) dao.listarPorQuery(
				DtoMaMiscelaneosdetalle.class,
				"mamiscelaneosdetalle.obtenerdescripcionmiscelaneosxparam",
				parametros);

		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getDescripcionlocal();

		return null;
	}

	@Override
	public List<MaMiscelaneosdetalle> listarPorEjemplo(String aplicacionCodigo,
			String codigoTabla, String compania) {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("pk.aplicacioncodigo", aplicacionCodigo));
		c.add(Restrictions.eq("pk.codigotabla", codigoTabla));
		if (!UValidador.esNulo(compania))
			c.add(Restrictions.eq("pk.compania", compania));
		c.addOrder(Order.asc("descripcionlocal"));
		return dao.listarPorCriterios(c);
	}

	@Override
	public MaMiscelaneosdetalle obtenerPorId(String aplicacionCodigo,
			String codigoTabla, String codigoElemento) {
		List result;
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("pk.aplicacioncodigo", aplicacionCodigo));
		c.add(Restrictions.eq("pk.codigotabla", codigoTabla));
		c.add(Restrictions.eq("pk.codigoelemento", codigoElemento));

		result = c.list();

		if (result == null)
			return null;
		if (result.size() != 1)
			return null;

		return (MaMiscelaneosdetalle) result.get(0);
	}

	public String obtenerNombreMiscelaneo(String par_aplicacion,
			String par_compania, String par_miscelaneo, String[] par_valores) {
		return dao.obtenerNombreMiscelaneo(par_aplicacion, par_compania,
				par_miscelaneo, par_valores);
	}

	@Override
	public List<MaMiscelaneosdetalle> listarSelectorVariosMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla) {
		return dao.listarSelectorVariosMiscelaneos(par_aplicacion,
				par_compania, par_tabla);
	}

	@Override
	public List<MaMiscelaneosdetalle> listarBusquedaMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal) {
		return dao.listarBusquedaMiscelaneos(par_aplicacion, par_compania,
				par_tabla, codigoelemento, descripcionlocal);
	}

	@Override
	public List<MaMiscelaneosdetalle> listarVerMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal, String[] areas,
			Integer iv_objetos, String actionButton) {
		return dao.listarVerMiscelaneos(par_aplicacion, par_compania,
				par_tabla, codigoelemento, descripcionlocal, areas, iv_objetos,
				actionButton);
	}

	@Override
	public String obtenerValorCodigo2(String aplicacionCodigo, String compania, String codigoTabla,
			String descripcionlocal) {
		return dao.obtenerValorCodigo2(aplicacionCodigo, compania, codigoTabla, descripcionlocal);
	}

}
