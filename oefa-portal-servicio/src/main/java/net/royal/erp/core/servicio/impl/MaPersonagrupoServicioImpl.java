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
import net.royal.erp.core.dao.MaPersonagrupoDao;
import net.royal.erp.core.servicio.MaPersonagrupoServicio;
import net.royal.erp.core.dominio.MaPersonagrupo;
import net.royal.erp.core.dominio.MaPersonagrupoPk;
import net.royal.erp.sistema.dominio.dto.DtoDwMaPersonaGrupoSelect;

@Service (value = "BeanServicioMaPersonagrupo")
public class MaPersonagrupoServicioImpl extends GenericoServicioImpl implements MaPersonagrupoServicio {

	private MaPersonagrupoDao dao;

	private static Log LOGGER = LogFactory.getLog(MaPersonagrupoServicioImpl.class);

	@Autowired
	public void setDao(MaPersonagrupoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerWork(String iv_type) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("iv_type",
				String.class, iv_type));

		List datos = dao.listarPorQuery(DtoDwMaPersonaGrupoSelect.class,
				"mapersonagrupo.w_open", parametros);

		DtoDwMaPersonaGrupoSelect w_work = new DtoDwMaPersonaGrupoSelect();
		w_work = (DtoDwMaPersonaGrupoSelect) datos.get(0);

		return w_work.getDescripcionlocal();

	}

}
