package net.royal.framework.web.core;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UFormula {

	private static final Log LOGGER = LogFactory.getLog(UFormula.class);

	// Formula para evaluacion de criterios de la entrevista
	public static BigDecimal porcentajeSuma(BigDecimal suma, BigDecimal porcentaje, BigDecimal maximo) {
		BigDecimal resultado = BigDecimal.ZERO;

		if (suma != BigDecimal.ZERO && porcentaje != BigDecimal.ZERO && maximo != BigDecimal.ZERO) {
			resultado = (suma.multiply(porcentaje)).divide(maximo, 2, BigDecimal.ROUND_HALF_UP);
		}
		return resultado;
	}
}
