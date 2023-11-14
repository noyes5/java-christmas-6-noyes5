package christmas.domain.discount;

import static christmas.domain.PromotionType.SPECIAL_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public class SpecialDayDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInSpecialPeriods();
    }

    @Override
    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        return Money.of(SPECIAL_DISCOUNT.getDiscount());
    }

    @Override
    public PromotionType getPromotionType() {
        return SPECIAL_DISCOUNT;
    }
}
