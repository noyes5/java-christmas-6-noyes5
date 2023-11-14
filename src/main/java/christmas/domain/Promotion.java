package christmas.domain;

import christmas.domain.discount.DiscountCondition;
import christmas.domain.menu.Orders;
import java.util.Map;

public class Promotion {
    private DiscountPolicy discountPolicy;

    public Promotion(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Map<DiscountCondition, Money> calculateDiscountAmounts(Reservation reservation, Orders userOrders) {
        return discountPolicy.calculateDiscountAmounts(reservation, userOrders);
    }
}
