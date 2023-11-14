package christmas.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ResultFormatter {
    private static final String DATE_FORMAT = "M월 d일";
    private static final String MONEY_FORMAT = "#,###원";
    private static final String MENU_RESULT_FORMAT = "%s %d개";
    
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
}
