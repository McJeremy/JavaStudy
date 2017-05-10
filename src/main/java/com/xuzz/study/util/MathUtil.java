package com.xuzz.study.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathUtil {
	
	/**
	 * 处理金额
	 * 
	 * @param target
	 * @return
	 */
	public static BigDecimal build(double target) {
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.FLOOR);
		BigDecimal bg = new BigDecimal(df.format(target));
		return bg;
	}
}
