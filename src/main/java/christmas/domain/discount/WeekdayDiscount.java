package christmas.domain.discount;

import static christmas.domain.promotion.PromotionType.WEEKDAY_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.promotion.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public class WeekdayDiscount implements DiscountCondition {
    private static final int WEEKDAY_DISCOUNT_AMOUNT = WEEKDAY_DISCOUNT.getDiscount();

    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInWeekDayPeriods();
    }

    @Override
    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        int desertAmount = orders.getDessertItemCount();
        return Money.of(WEEKDAY_DISCOUNT_AMOUNT).multiply(Money.of(desertAmount));
    }

    @Override
    public PromotionType getPromotionType() {
        return WEEKDAY_DISCOUNT;
    }
}
