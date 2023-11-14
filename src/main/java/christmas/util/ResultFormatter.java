package christmas.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ResultFormatter {
    private static final String DATE_FORMAT = "M월 d일";
    private static final String MONEY_FORMAT = "#,###원";
    private static final String PROMO_MONEY_FORMAT = "-#,###원";
    private static final String MENU_RESULT_FORMAT = "%s %d개";
    private static final String DISCOUNT_RESULT_FORMAT = "%s: -%s";

    public static String dateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.KOREAN);
        return date.format(formatter);
    }

    public static String moneyFormat(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        return decimalFormat.format(bigDecimal);
    }

    public static String menuFormat(String menuName, int quantity) {
        return String.format(MENU_RESULT_FORMAT, menuName, quantity);
    }

    public static String discountFormat(String menuName, BigDecimal bigDecimal) {
        return String.format(DISCOUNT_RESULT_FORMAT, menuName, moneyFormat(bigDecimal));
    }

    public static String benefitMoneyFormat(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return new DecimalFormat(MONEY_FORMAT).format(bigDecimal);
        }
        return new DecimalFormat(PROMO_MONEY_FORMAT).format(bigDecimal);
    }
}
