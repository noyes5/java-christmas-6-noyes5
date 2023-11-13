package christmas.util.validator;

import christmas.domain.exception.DateException;
import java.util.regex.Pattern;

public class ReservationValidator extends Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int LAST_DAY_OF_MONTH = 31;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNullOrEmpty(input);
        validateNumeric(input);
        validateDateRange(input);
    }

    private static void validateNullOrEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(DateException.INVALID_EMPTY_INPUT.getMessage());
        }
    }

    private void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(DateException.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    private void validateDateRange(String input) {
        int date = validateParseInt((input));
        if (date < FIRST_DAY_OF_MONTH || date > LAST_DAY_OF_MONTH) {
            throw new IllegalArgumentException(DateException.INVALID_DATE_RANGE.getMessage());
        }
    }

    private int validateParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(DateException.INVALID_INT_RANGE.getMessage());
        }
    }
}
