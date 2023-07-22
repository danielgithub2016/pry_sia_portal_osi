package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.MaMiscelaneosdetalleDao;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.core.dominio.MaMiscelaneosdetallePk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class MaMiscelaneosdetalleDaoImpl extends
		GenericoDaoImpl<MaMiscelaneosdetalle, MaMiscelaneosdetallePk> implements
		MaMiscelaneosdetalleDao {

	private static Log LOGGER = LogFactory.getLog(MaMiscelaneosdetalle.class);

	public MaMiscelaneosdetalleDaoImpl() {
		super("mamiscelaneosdetalle");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<MaMiscelaneosdetalle> ListarMiscelaneosdetalle() {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", "HR"));
		cri.add(Restrictions.eq("pk.codigotabla", "POTENCIAL"));
		cri.add(Restrictions.eq("pk.compania", "999999"));
		cri.addOrder(Order.asc("pk.codigoelemento"));

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return lista;
	}

	public String obtenerNombreMiscelaneo(String par_aplicacion,
			String par_compania, String par_miscelaneo, String[] par_valores) {

		String w_resultado = "", w_nuevowhere, w_descripcion;
		Integer w_fila;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));
		cri.add(Restrictions.eq("pk.compania", par_compania));
		cri.add(Restrictions.eq("pk.codigotabla", par_miscelaneo));

		if (!UValidador.esNulo(par_valores)) {
			if (par_valores.length > 0) {
				cri.add(Restrictions.in("pk.codigoelemento", par_valores));
				List<MaMiscelaneosdetalle> dato = this.listarPorCriterios(cri);
				if (UValidador.esListaVacia(dato)) {
					return null;
				}
				for (MaMiscelaneosdetalle x : dato) {
					if (!UValidador.esNulo(x.getPk().getCodigoelemento())) {
						x.getPk().setCodigoelemento(
								x.getPk().getCodigoelemento().trim());
					}
					if (!UValidador.esNulo(x.getDescripcionlocal())) {
						x.setDescripcionlocal(x.getDescripcionlocal().trim());
					}
					x.setAuxSeleccionado("N");

					w_descripcion = x.getDescripcionlocal();
					if (UValidador.esNulo(w_descripcion)) {
						w_descripcion = w_descripcion + "";
					}
					if (w_resultado.equals("")) {
						w_resultado = w_descripcion;
					} else {
						w_resultado = w_resultado + " - " + w_descripcion;
					}
				}
			}
		}

		return w_resultado;
	}

	@Override
	public List<MaMiscelaneosdetalle> listarSelectorVariosMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));
		cri.add(Restrictions.eq("pk.codigotabla", par_tabla));
		cri.add(Restrictions.eq("pk.compania", par_compania));

		List<MaMiscelaneosdetalle> lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		for (MaMiscelaneosdetalle x : lista) {
			x.setAuxSeleccionado("N");
		}

		return lista;
	}

	@Override
	public List<MaMiscelaneosdetalle> listarBusquedaMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));
		cri.add(Restrictions.eq("pk.codigotabla", par_tabla));
		cri.add(Restrictions.eq("pk.compania", par_compania));

		cri.add(Restrictions.sqlRestriction(" CODIGOELEMENTO LIKE '"
				+ codigoelemento + "%' "));
		cri.add(Restrictions.sqlRestriction(" UPPER(DESCRIPCIONLOCAL) LIKE '"
				+ descripcionlocal.toUpperCase() + "%' "));

		cri.addOrder(Order.asc("descripcionlocal"));
		List<MaMiscelaneosdetalle> lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		for (MaMiscelaneosdetalle x : lista) {
			x.setAuxSeleccionado("N");
		}

		return lista;
	}

	@Override
	public List<MaMiscelaneosdetalle> listarVerMiscelaneos(
			String par_aplicacion, String par_compania, String par_tabla,
			String codigoelemento, String descripcionlocal, String[] areas,
			Integer iv_objetos,String actionButton) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", par_aplicacion));
		cri.add(Restrictions.eq("pk.codigotabla", par_tabla));
		cri.add(Restrictions.eq("pk.compania", par_compania));
		if ( actionButton.equals("VER")) {
			cri.add(Restrictions.in("pk.codigoelemento", areas));
		}
		
		cri.add(Restrictions.sqlRestriction(" CODIGOELEMENTO LIKE '"
				+ codigoelemento + "%' "));
		cri.add(Restrictions.sqlRestriction(" UPPER(DESCRIPCIONLOCAL) LIKE '"
				+ descripcionlocal.toUpperCase() + "%' "));
		cri.addOrder(Order.asc("descripcionlocal"));

		List<MaMiscelaneosdetalle> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		for (MaMiscelaneosdetalle x : datos) {
			x.setAuxSeleccionado("N");
			for (int i = 0; i <= iv_objetos; i++) {
				if (x.getPk().getCodigoelemento().equals(areas[i]))
					x.setAuxSeleccionado("S");
			}
		}

		return datos;
	}

	@Override
	public String obtenerValorCodigo(String aplicacionCodigo, String compania,
			String codigoTabla, String descripcionlocal) {

		String valorCodigo = "";

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", aplicacionCodigo));
		cri.add(Restrictions.eq("pk.codigotabla", codigoTabla));
		cri.add(Restrictions.eq("pk.compania", compania));
		cri.add(Restrictions.like("pk.codigoelemento", descripcionlocal,
				MatchMode.END));

		List<MaMiscelaneosdetalle> lista = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(lista)) {
			valorCodigo = lista.get(0).getValorcodigo1();
		}

		return valorCodigo;
	}

	@Override
	public String obtenerValorCodigo2(String aplicacionCodigo, String compania, String codigoTabla,
			String descripcionlocal) {
		String valorCodigo = "";

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.aplicacioncodigo", aplicacionCodigo));
		cri.add(Restrictions.eq("pk.codigotabla", codigoTabla));
		cri.add(Restrictions.eq("pk.compania", compania));
		cri.add(Restrictions.like("pk.codigoelemento", descripcionlocal,
				MatchMode.END));

		List<MaMiscelaneosdetalle> lista = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(lista)) {
			valorCodigo = lista.get(0).getValorcodigo2();
		}

		return valorCodigo;
	}

}
