package christmas.domain.exception;

public enum DateException {
    INVALID_DATE_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_EMPTY_INPUT("빈 값은 입력할 수 없습니다."),
    INVALID_INT_RANGE("입력범위를 초과하였습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    DateException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
