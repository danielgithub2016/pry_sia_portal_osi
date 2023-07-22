package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.EmpleadomastDao;
import net.royal.erp.core.dao.ParametrosmastDao;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.EmpleadomastPk;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.rrhh.dao.HrFactoresevaluacionplantillaDao;
import net.royal.erp.rrhh.servicio.HrFactoresevaluacionplantillaServicio;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantilla;
import net.royal.erp.rrhh.dominio.HrFactoresevaluacionplantillaPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;

@Service (value = "BeanServicioHrFactoresevaluacionplantilla")
public class HrFactoresevaluacionplantillaServicioImpl extends GenericoServicioImpl implements HrFactoresevaluacionplantillaServicio {

	private HrFactoresevaluacionplantillaDao dao;
	private EmpleadomastDao daoEmpleado;
	private ParametrosmastDao daoParametros;

	private static Log LOGGER = LogFactory.getLog(HrFactoresevaluacionplantillaServicioImpl.class);

	@Autowired
	public void setDao(HrFactoresevaluacionplantillaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	
	// of_get_plantilla_empleado
	public String obtenerPlantillaEmpleado(String as_companyowner,
			Integer al_secuenciaeval, String as_tipoplantilla,
			Integer al_empleado) {
		
		// RichardG 2009-03-01
		Integer ll_CodigoCargo;
		String ls_GradoSalario, ls_Codigo, ls_plantilla = "";
		
		
		EmpleadomastPk pk = new EmpleadomastPk();
		pk.setCompaniasocio(as_companyowner);
		pk.setEmpleado(al_empleado);
		Empleadomast e = daoEmpleado.obtenerPorId(pk,false);
		
		ll_CodigoCargo=e.getCodigocargo();
		ls_GradoSalario=e.getGradosalario();
				

		String is_TipoCodigo = daoParametros.obtenerValorCadena(new ParametrosmastPk("HR","999999","EVALCODIGO")); 

		if(is_TipoCodigo.equals("CA")){
			ls_Codigo=ll_CodigoCargo.toString();
		}else{
			ls_Codigo = ls_GradoSalario;
		}

		// Buscar Plantilla
		List<ParametroPersistenciaGenerico>parametros= new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("as_companyowner", String.class, as_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("as_tipoplantilla", String.class, as_tipoplantilla));
		parametros.add(new ParametroPersistenciaGenerico("al_secuenciaeval", Integer.class, al_secuenciaeval));
		parametros.add(new ParametroPersistenciaGenerico("is_TipoCodigo", String.class, is_TipoCodigo));
		parametros.add(new ParametroPersistenciaGenerico("ls_codigo", String.class, ls_Codigo));
		
		List datos= dao.listarPorQuery(DtoHrDetalleEvaluacion.class,"hrfactoresevaluacionplantilla.obtenerPlantilla",parametros);
		
		if(!UValidador.esListaVacia(datos)){
			DtoHrDetalleEvaluacion dto= new DtoHrDetalleEvaluacion();
			dto=(DtoHrDetalleEvaluacion) datos.get(0);
			ls_plantilla=dto.getPlantilla();
			if(UValidador.esNulo(ls_plantilla)){
				ls_plantilla="";
			}
		}
		
		return ls_plantilla;
	}

	@Autowired
	public void setDaoEmpleado(EmpleadomastDao daoEmpleado) {
		this.daoEmpleado = daoEmpleado;
	}

	@Autowired
	public void setDaoParametros(ParametrosmastDao daoParametros) {
		this.daoParametros = daoParametros;
	}

}
