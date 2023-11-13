package christmas.domain.discount;

import christmas.domain.Reservation;

@FunctionalInterface
public interface DiscountCondition {
    boolean isSatisfiedBy(Reservation reservation);
}
