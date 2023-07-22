package net.royal.erp.rrhh.hrrepus.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dominio.dto.DtoDddWMaHrGradoSalairalMastSelect;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrrepusFuncion")
public class HrrepusFuncion {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BigDecimal FSqlGetMaximNivelsalarial(String par_grado,
			Integer par_tipo) {
		BigDecimal salmaximo = null, salminimo = null;

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_grado",
				String.class, par_grado));

		List<DtoDddWMaHrGradoSalairalMastSelect> lista = (List) dao
				.listarPorQuery(DtoDddWMaHrGradoSalairalMastSelect.class,
						"hrrepus.FSqlGetMaximNivelsalarial", parametros);

		if (!UValidador.esListaVacia(lista)) {
			salmaximo = lista.get(0).getSalariomaximo();
			salminimo = lista.get(0).getSalariominimo();
		}

		if (par_tipo == 1)
			return UValidador.esNulo(salmaximo) ? BigDecimal.ZERO : salmaximo;
		else
			return UValidador.esNulo(salminimo) ? BigDecimal.ZERO : salminimo;
	}

	public BigDecimal FHrGetSueldo(BigDecimal empleado, String concepto)
			throws Exception {
		BigDecimal montolocal = BigDecimal.ZERO, total = BigDecimal.ZERO, montolocal_Subvencion = BigDecimal.ZERO;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				BigDecimal.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto",
				String.class, concepto));

		List data = dao.listarPorQuery(
				DtoDddWMaHrGradoSalairalMastSelect.class,
				"hrrepus.obtenerMontoLocal", filtros);
		if (!UValidador.esListaVacia(data)) {
			montolocal = ((DtoDddWMaHrGradoSalairalMastSelect) data.get(0))
					.getMontolocal();
		}

		concepto = "2300";

		filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				BigDecimal.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_concepto",
				String.class, concepto));

		data = dao.listarPorQuery(DtoDddWMaHrGradoSalairalMastSelect.class,
				"hrrepus.obtenerMontoLocal", filtros);
		if (!UValidador.esListaVacia(data)) {
			montolocal_Subvencion = ((DtoDddWMaHrGradoSalairalMastSelect) data
					.get(0)).getMontolocal();
		}

		BigDecimal asigfamiliar = BigDecimal.ZERO;
		String periodo;
		periodo = UFechaHora.convertirFechaCadena(new Date(), "yyyyMM");

		filtros = new ArrayList<>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				BigDecimal.class, empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_periodo",
				String.class, periodo));

		data = dao.listarPorQuery(DtoDddWMaHrGradoSalairalMastSelect.class,
				"hrrepus.obtenerMonto", filtros);
		if (!UValidador.esListaVacia(data)) {
			asigfamiliar = ((DtoDddWMaHrGradoSalairalMastSelect) data.get(0))
					.getMonto();
		}

		total = montolocal.add(asigfamiliar).add(montolocal_Subvencion);

		return total;
	}

}
