package christmas.domain.gift;

public enum GiftList {
    DECEMBER_GIFT("샴페인", 1);

    private final String menuName;
    private final int amount;

    GiftList(String menuName, int amount) {
        this.menuName = menuName;
        this.amount = amount;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getAmount() {
        return amount;
    }
}
