package christmas.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitByComma(String orderMenus) {
        return Arrays.stream(StringUtils.removeSpace(orderMenus).split(Regex.COMMA.regex))
                .toList();
    }

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    public static List<String> splitByHyphen(String menuAndQuantity) {
        return Arrays.stream(menuAndQuantity.split(Regex.HYPHEN.regex))
                .toList();
    }

    private enum Regex {
        COMMA(","),
        HYPHEN("-"),
        SPACE(" "),
        NO_SPACE("");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }
}
