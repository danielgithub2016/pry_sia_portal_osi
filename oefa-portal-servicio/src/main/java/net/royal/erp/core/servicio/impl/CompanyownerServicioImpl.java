package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dao.CompanyownerDao;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.servicio.CompanyownerServicio;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioCompanyowner")
public class CompanyownerServicioImpl extends GenericoServicioImpl implements
		CompanyownerServicio {

	private CompanyownerDao dao;

	private static Log LOGGER = LogFactory
			.getLog(CompanyownerServicioImpl.class);

	@Autowired
	public void setDao(CompanyownerDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List DwMaCompanyownerSelect(String par_company) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_company",
				String.class, par_company));

		List datos = dao.listarPorQuery(DtoDwMaCompanyownerSelect.class,
				"companyowner.DwMaCompanyownerSelect", parametros);

		return datos;
	}

	@Override
	public List<DtoDwMaCompanyownerSelect> DwMaCompanyownerSelectSecurity(
			String par_usuario) {

		List<DtoDwMaCompanyownerSelect> compania = new ArrayList<DtoDwMaCompanyownerSelect>();
		List<DtoDwMaCompanyownerSelect> companiaActual = new ArrayList<DtoDwMaCompanyownerSelect>();

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_usuario",
				String.class, par_usuario.toUpperCase()));

		/*
		 * utilizo este Dto para castearlo en la controladora
		 */
		List datos = dao.listarPorQuery(DtoDwMaCompanyownerSelect.class,
				"companyowner.DwMaCompanyownerSelectSecurity", parametros);

		compania.addAll(datos);
		for (DtoDwMaCompanyownerSelect obj : compania) {
			if (obj.getTipocompania().equals("P")) {
				companiaActual.add(obj);
			}
		}

		return companiaActual;
	}

	@Override
	public List<Companyowner> listarEjecutoras() {
		return dao.listarEjecutoras();
	}

}
