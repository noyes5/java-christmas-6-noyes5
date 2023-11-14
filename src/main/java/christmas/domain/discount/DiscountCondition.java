package christmas.domain.discount;

import christmas.domain.PromotionType;
import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public interface DiscountCondition {

    boolean isSatisfiedBy(Reservation reservation);

    Money calculateDiscountAmount(Reservation reservation, Orders orders);

    PromotionType getPromotionType();
}
