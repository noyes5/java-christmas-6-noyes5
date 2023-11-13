package christmas.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {
    private static final String DATE_FORMAT = "M월 d일";

    public static String formatResult(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.KOREAN);
        return date.format(formatter);
    }
}
