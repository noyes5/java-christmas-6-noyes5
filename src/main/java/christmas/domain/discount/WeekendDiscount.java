package christmas.domain.discount;

import static christmas.domain.PromotionType.WEEKEND_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public class WeekendDiscount implements DiscountCondition {
    private static final int WEEKEND_DISCOUNT_AMOUNT = WEEKEND_DISCOUNT.getDiscount();
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInWeekEndPeriods();
    }

    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        int mainAmount = orders.getMainItemCount();
        return Money.of(WEEKEND_DISCOUNT_AMOUNT).multiply(Money.of(mainAmount));
    }

    @Override
    public PromotionType getPromotionType() {
        return WEEKEND_DISCOUNT;
    }
}
