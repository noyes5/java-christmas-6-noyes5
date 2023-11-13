package christmas.util.validator;

import christmas.domain.exception.MenuException;
import christmas.util.StringUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class MenuValidator extends Validator {
    private static final Pattern ORDER_REGEX = Pattern.compile("^[가-힣]+-(1?[0-9]|20)$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateEmpty(input);
        List<String> order = StringUtils.splitByComma(input);
        validateRegex(order);
        validateDuplicate(order);
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(MenuException.INVALID_EMPTY_INPUT.getMessage());
        }
    }

    private void validateRegex(List<String> order) {
        order.forEach(this::validateRegex);
    }

    private void validateRegex(String input) {
        if (!ORDER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(MenuException.INVALID_MENU_INPUT.getMessage());
        }
    }

    private static void validateDuplicate(List<String> order) {
        Set<String> uniqueOrders = new HashSet<>(order);
        if (uniqueOrders.size() != order.size()) {
            throw new IllegalArgumentException(MenuException.INVALID_MENU_INPUT.getMessage());
        }
    }
}
