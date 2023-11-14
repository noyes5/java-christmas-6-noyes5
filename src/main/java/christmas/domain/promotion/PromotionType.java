package christmas.domain.promotion;

public enum PromotionType {
    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인", 100),
    WEEKDAY_DISCOUNT("평일 할인", 2_023),
    WEEKEND_DISCOUNT("주말 할인", 2_023),
    SPECIAL_DISCOUNT("특별 할인", 1_000),
    GIVING_GIFT("증정 이벤트", 0);

    private final String message;
    private final int discount;

    PromotionType(String message, int discount) {
        this.message = message;
        this.discount = discount;
    }

    public String getMessage() {
        return message;
    }

    public int getDiscount() {
        return discount;
    }
}
