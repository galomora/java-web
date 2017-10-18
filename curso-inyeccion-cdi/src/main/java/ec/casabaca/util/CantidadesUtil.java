package ec.casabaca.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CantidadesUtil {
	public static BigDecimal redondearPredeterminado (BigDecimal cantidad) {
		return cantidad.setScale(2, RoundingMode.HALF_UP);
	}
}
