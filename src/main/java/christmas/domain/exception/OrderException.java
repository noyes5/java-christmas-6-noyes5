package christmas.domain.exception;

public enum OrderException {
    BEVERAGE_ONLY_ORDER_ERROR("음료수만 주문할 수 없습니다."),
    INVALID_TOTAL_QUANTITY("주문 수량은 총 20개를 넘을 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    OrderException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
