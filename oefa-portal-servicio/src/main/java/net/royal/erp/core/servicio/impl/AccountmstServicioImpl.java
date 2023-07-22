package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.AccountmstDao;
import net.royal.erp.core.servicio.AccountmstServicio;
import net.royal.erp.core.dominio.Accountmst;
import net.royal.erp.core.dominio.AccountmstPk;
import net.royal.erp.sistema.dominio.dto.DtoDwMaAccountSelectList;

@Service(value = "BeanServicioAccountmst")
public class AccountmstServicioImpl extends GenericoServicioImpl implements
		AccountmstServicio {

	private AccountmstDao dao;

	private static Log LOGGER = LogFactory.getLog(AccountmstServicioImpl.class);

	@Autowired
	public void setDao(AccountmstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer esAfecto(String account) {
		return dao.esAfecto(account);
	}

	@Override
	public Accountmst validarCuenta(String account, String planContable) {
		return dao.validarCuenta(account, planContable);
	}

	public List listarAccount(String w_account, String str_plancontable) {
		return dao.listarAccount(w_account, str_plancontable);
	}

	@Override
	public String leerCuentaContable(String par_account) {
		return dao.leerCuentaContable(par_account);
	}

	@Override
	/**
	 *
	 * @author desarrollo
	 * @powerbuilder symast01.dw_ma_account_select_list wf_prepare_sql
	 */
	public List DwMaAccountSelectList(String w_prime, String w_element,
			String w_plancontable, String w_buscar,
			String codigoDescripcionFlag, String status) {

		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("status", String.class,
				status));

		StringBuilder sb = new StringBuilder();
		sb.append(dao.obtenerSentenciaSqlPorQuery("accountmst.listarCuenta"));

		if(codigoDescripcionFlag.equals("C")){
			if (UValidador.esNulo(w_buscar) || w_buscar.trim().equals("")) {
				w_buscar = "";
			} else {
				sb.append(" AND (AC.account >= '" + w_buscar + "' ) ");
			}
		}
		if(codigoDescripcionFlag.equals("D")){
			w_buscar = "%" + w_buscar.toUpperCase() + "%";
			if (UValidador.esNulo(w_buscar)) {
				w_buscar = "";
				sb.append(" AND (Upper(AC.localname) >= " + w_buscar
						+ " ) ");
			} else {
				sb.append(" AND (Upper(AC.localname) like '" + w_buscar
						+ "')");
			}
		}
		

		if (!UValidador.esNulo(w_prime)) {
			sb.append(" AND AC.prime LIKE '" + w_prime+"'");
		}
		if (!UValidador.esNulo(w_element)) {
			sb.append(" AND AC.element like '" + w_element+"'");
		}
		if (!UValidador.esNulo(w_plancontable)) {
			sb.append(" AND AC.plancontable like '" + w_plancontable + "'");
		}
		sb.append(" ORDER BY AC.ACCOUNT ");
		List datos;
		datos = dao.listarPorSentenciaSQL(DtoDwMaAccountSelectList.class, sb,
				filtro);
		LOGGER.debug("datos == "+datos.size());
		return datos;

	}

	@Override
	/**
	 * 
	 * listaCabecera
	 */
	public List listaCabecera(String w_prime, String w_element,
			String w_plancontable, String w_buscar,
			String codigoDescripcionFlag, String status) {
		LOGGER.debug("test de symast01.dw_ma_account_select_list");
		LOGGER.debug(" usar el siguiente dto :  DtoDwMaAccountSelectList");
		LOGGER.debug(" usar el siguiente sql-query para el dto :  symast01.DwMaAccountSelectList");

		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("status", String.class,
				status));

		StringBuilder sb = new StringBuilder();
		sb.append(dao.obtenerSentenciaSqlPorQuery("accountmst.listarCabecera"));

		if(codigoDescripcionFlag.equals("C")){
			if (UValidador.esNulo(w_buscar) || w_buscar.trim().equals("")) {
				w_buscar = "";
			} else {
				sb.append(" AND (AC.account >= '" + w_buscar + "' ) ");
			}
		}
		if(codigoDescripcionFlag.equals("D")){
			w_buscar = "%" + w_buscar.toUpperCase() + "%";
			if (UValidador.esNulo(w_buscar) || w_buscar.trim().equals("")) {
				w_buscar = "";
				sb.append(" AND (Upper(AC.localname) >= " + w_buscar
						+ " ) ");
			} else {
				sb.append(" AND (Upper(AC.localname) like '" + w_buscar
						+ "')");
			}
		}
		

		if (!UValidador.esNulo(w_prime)) {
			sb.append(" AND AC.prime LIKE '" + w_prime+"'");
		}
		if (!UValidador.esNulo(w_element)) {
			sb.append(" AND AC.element like '" + w_element+"'");
		}
		if (!UValidador.esNulo(w_plancontable)) {
			sb.append(" AND AC.plancontable like '" + w_plancontable + "'");
		}
		sb.append(" group by PR.LOCALNAME,PR.PRIME  ORDER BY PR.PRIME ");
		List datos;
		datos = dao.listarPorSentenciaSQL(DtoDwMaAccountSelectList.class, sb,
				filtro);
		LOGGER.debug("datos == "+datos.size());
		return datos;

	}


}
