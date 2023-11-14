package christmas.domain.discount;

import static christmas.domain.promotion.PromotionType.CHRISTMAS_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.promotion.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public class ChristmasDiscount implements DiscountCondition {
    public static final int DEFAULT_DISCOUNT = 1_000;
    public static final int CHRISTMAS_DISCOUNT_PER_DAY = CHRISTMAS_DISCOUNT.getDiscount();

    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInChristmasPeriods();
    }

    @Override
    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        int dayOfMonth = reservation.getDate().getDayOfMonth();
        int discountSum = DEFAULT_DISCOUNT + ((dayOfMonth - 1) * CHRISTMAS_DISCOUNT_PER_DAY);
        return Money.of(discountSum);
    }

    @Override
    public PromotionType getPromotionType() {
        return CHRISTMAS_DISCOUNT;
    }
}
