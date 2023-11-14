package christmas.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    NONE("없음",0),
    STAR("별",5_000),
    TREE("트리",10_000),
    SANTA("산타",20_000);

    private final String name;
    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge getBadgeByMoney(Money money) {
        int amount = money.getAmount().intValue();
        return Arrays.stream(Badge.values())
                .sorted(Comparator.reverseOrder())
                .filter(badge -> amount >= badge.price)
                .findFirst()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return name;
    }
}
