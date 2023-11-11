package christmas.domain.discount;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;

public class ChristmasDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInChristmasPeriods();
    }

    public DiscountAmount calculateDiscountAmount(Reservation reservation) {
        int dayOfMonth = reservation.getDate().getDayOfMonth();
        int discountSum = 1000 + ((dayOfMonth - 1)* 100);
        String discountAmount = String.valueOf(discountSum);
        return DiscountAmount.of(discountAmount);
    }
}
