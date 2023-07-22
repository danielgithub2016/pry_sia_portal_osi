package net.royal.erp.rrhh.commodity.servicio;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dominio.dto.DtoMaMiscelaneosdetalle;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioCommodityFuncion")
public class CommodityFuncion {
	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String FNombreNivelServicio(String par_compania,Integer par_nivel){
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_compania", String.class, par_compania));
		parametros.add(new ParametroPersistenciaGenerico("par_nivel",Integer.class,par_nivel));
		
		List<DtoMaMiscelaneosdetalle> lista = (List)dao.listarPorQuery(DtoMaMiscelaneosdetalle.class, "commodity.FNombreNivelServicio", parametros);
		
		if(!UValidador.esListaVacia(lista)){
			return lista.get(0).getDescripcionlocal();
		}
		
		return null;
	}
	
}
