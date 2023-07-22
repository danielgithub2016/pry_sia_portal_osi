package net.royal.erp.asistencia.sylock.servicio;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioSylockFuncion")
public class SylockFuncion {

	private static Log LOGGER = LogFactory.getLog(SylockFuncion.class);

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_get_userid
	 */
	public void FGetUserid() {
		LOGGER.debug("test de sylock.f_get_userid");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_prepare_add_where_all_cia
	 */
	public void FPrepareAddWhereAllCia() {
		LOGGER.debug("test de sylock.f_prepare_add_where_all_cia");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_prepare_add_where_all_ciasocio
	 */
	public void FPrepareAddWhereAllCiasocio() {
		LOGGER.debug("test de sylock.f_prepare_add_where_all_ciasocio");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_prepare_add_where_all_tipoplanilla
	 */
	public void FPrepareAddWhereAllTipoplanilla() {
		LOGGER.debug("test de sylock.f_prepare_add_where_all_tipoplanilla");
	}


	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_security_fields_unload
	 */
	public void FSecurityFieldsUnload() {
		LOGGER.debug("test de sylock.f_security_fields_unload");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_sql_get_usuarioxcompanyowner
	 */
	public void FSqlGetUsuarioxcompanyowner() {
		LOGGER.debug("test de sylock.f_sql_get_usuarioxcompanyowner");
	}


	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_sql_read_security
	 */
	public void FSqlReadSecurity() {
		LOGGER.debug("test de sylock.f_sql_read_security");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_sql_read_security_codigointerno
	 */
	public void FSqlReadSecurityCodigointerno() {
		LOGGER.debug("test de sylock.f_sql_read_security_codigointerno");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_sql_validate_password_format
	 */
	public void FSqlValidatePasswordFormat() {
		LOGGER.debug("test de sylock.f_sql_validate_password_format");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sylock.f_timestamp
	 */
	public void FTimestamp() {
		LOGGER.debug("test de sylock.f_timestamp");
	}

}
