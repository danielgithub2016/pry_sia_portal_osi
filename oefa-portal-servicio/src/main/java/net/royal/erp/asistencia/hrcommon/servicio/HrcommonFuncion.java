package net.royal.erp.asistencia.hrcommon.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.dto.DtoMaMiscelaneosdetalle;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrcommonFuncion")
public class HrcommonFuncion {

	private static Log LOGGER = LogFactory.getLog(HrcommonFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder hrcommon.f_dias
	 */
	public void FDias() {
		LOGGER.debug("test de hrcommon.f_dias");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BigDecimal FGetEmpleadoXUsuario(String codigoUsuario) {
		List<Empleadomast> obj = (List) dao.listarPorCriterios(dao.getCriteria(
				Empleadomast.class).add(
				Restrictions.eq("codigousuario", codigoUsuario)));

		if (!UValidador.esListaVacia(obj)) {
			return new BigDecimal(obj.get(0).getPk().getEmpleado());
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String FSqlGetNombrePuestoComentario(Integer par_puesto) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_puesto",
				Integer.class, par_puesto));
		List<DtoMaMiscelaneosdetalle> lista = (List) dao.listarPorQuery(
				DtoMaMiscelaneosdetalle.class,
				"hrcommon.FSqlGetNombrePuestoComentario", parametros);
		
		if(!UValidador.esListaVacia(lista))
			return lista.get(0).getDescripcionlocal();
		
		return "NO ESPECIFICADO";
	}

}
