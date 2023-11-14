package christmas.domain.discount;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import christmas.domain.promotion.PromotionType;
import christmas.dto.OrderInfo;

public interface DiscountCondition {

    boolean isSatisfiedBy(OrderInfo orderInfo);

    Money calculateDiscountAmount(Reservation reservation, Orders orders);

    PromotionType getPromotionType();
}
