package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {
	public static String format(long number) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(number);
	}
}
