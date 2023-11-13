package christmas.domain.discount;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;

public class SpecialDayDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInSpecialPeriods();
    }

    public DiscountAmount calculateDiscountAmount(Reservation reservation) {
        return DiscountAmount.of("1000");
    }
}
