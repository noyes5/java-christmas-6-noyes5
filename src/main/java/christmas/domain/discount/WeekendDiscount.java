package christmas.domain.discount;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;

public class WeekendDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInWeekEndPeriods();
    }

    public DiscountAmount calculateDiscountAmount(Reservation reservation) {
        return DiscountAmount.of("2023");
    }
}
