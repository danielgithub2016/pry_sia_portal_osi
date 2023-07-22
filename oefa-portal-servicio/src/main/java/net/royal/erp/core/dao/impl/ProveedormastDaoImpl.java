package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.PersonamastDao;
import net.royal.erp.core.dao.ProveedormastDao;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.core.dominio.Proveedormast;
import net.royal.erp.core.dominio.ProveedormastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProveedormastDaoImpl extends
		GenericoDaoImpl<Proveedormast, ProveedormastPk> implements
		ProveedormastDao {

	private static Log LOGGER = LogFactory.getLog(Proveedormast.class);
	private PersonamastDao daoPersonamast;

	public ProveedormastDaoImpl() {
		super("proveedormast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder whothers.f_sql_get_name_for_check
	*/
	@Override
	public String obtenerNmobrePagarA(Integer proveedor) {
		Proveedormast prv = null;
		Personamast per = null;
		String pagarANombre = null;
		String nombre,apep, apem;

		if (proveedor == null)
			return null;
		if (proveedor == 0)
			return null;

		prv = this.obtenerPorId(new ProveedormastPk(proveedor), false);
		if(UValidador.esNulo(prv)){
			pagarANombre=null;
		}else{
			pagarANombre = prv.getPagaranombre();
		}
		
		per = daoPersonamast.obtenerPorId(new PersonamastPk(proveedor));
		nombre = per.getNombres();
		apep = per.getApellidopaterno();
		apem = per.getApellidomaterno();
		
		if (UValidador.validarEsNuloVacio(pagarANombre)) {
			pagarANombre = per.getNombrecompleto();
			if (UValidador.validarEsNuloVacio(pagarANombre)) {
				pagarANombre = nombre + " " + apep + " " + apem;
				pagarANombre = pagarANombre.trim();
				if (UValidador.validarEsNuloVacio(pagarANombre)) {
					pagarANombre = per.getBusqueda();
				}
			}
		}

		return pagarANombre;
	}

	@Autowired
	public void setObligacionesDao(PersonamastDao daoPersonamast) {
		this.daoPersonamast = daoPersonamast;
	}

	@Override
	public Proveedormast obtenerProveedor(Integer proveedor) {
		
		List<Proveedormast> lista = this.listarPorCriterios(this.getCriteria()
				.add(Restrictions.eq("pk.proveedor", proveedor)));

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0);
	}

}