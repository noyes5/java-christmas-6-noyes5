package christmas.domain.discount;

import christmas.domain.Reservation;

public interface DiscountCondition {
    public boolean isSatisfiedBy(Reservation reservation);
}
