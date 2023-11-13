package christmas.domain.exception;

public enum MenuException {
    INVALID_EMPTY_INPUT("빈 값은 입력할 수 없습니다."),
    INVALID_MENU_INPUT("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    MenuException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
