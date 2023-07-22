package net.royal.erp.contabilidad.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.contabilidad.dao.AcCostcenterCompaniaDao;
import net.royal.erp.contabilidad.dominio.AcCostcenterCompania;
import net.royal.erp.contabilidad.servicio.AcCostcenterCompaniaServicio;
import net.royal.erp.sistema.dao.SySeguridadautorizacionesDao;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.erp.sistema.dominio.SySeguridadautorizacionesPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioAcCostcenterCompania")
public class AcCostcenterCompaniaServicioImpl extends GenericoServicioImpl
		implements AcCostcenterCompaniaServicio {

	private AcCostcenterCompaniaDao dao;
	private SySeguridadautorizacionesDao daoSySeguridad;

	@Autowired
	public void setDao(AcCostcenterCompaniaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Autowired
	public void setDaoSySeguridad(SySeguridadautorizacionesDao daoSySeguridad) {
		this.daoSySeguridad = daoSySeguridad;
	}

	@Override
	public List<AcCostcenterCompania> listarAreaCreaDemanda(String compania,
			String ano, Integer version, Integer tipo, String usuario) {
		List<AcCostcenterCompania> lista = dao.listarAreaCreaDemanda(compania,
				ano, version);
		if (tipo.equals(2)) {
			for (int i = 0; i < lista.size(); i++) {
				AcCostcenterCompania cc = lista.get(i);
				SySeguridadautorizacionesPk pk = new SySeguridadautorizacionesPk();
				pk.setAplicacioncodigo("SY");
				pk.setConcepto(cc.getPk().getCostcenter());
				pk.setGrupo("CENTROCOSTOS");
				pk.setUsuario(usuario);

				SySeguridadautorizaciones sy = daoSySeguridad.obtenerPorId(pk);
				if (UValidador.esNulo(sy)) {
					lista.remove(i);
					i--;
				}
			}
		}

		return lista;
	}

}
