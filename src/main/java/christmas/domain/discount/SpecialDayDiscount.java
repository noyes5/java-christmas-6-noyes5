package christmas.domain.discount;

import static christmas.domain.promotion.PromotionType.SPECIAL_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.promotion.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import christmas.dto.OrderInfo;

public class SpecialDayDiscount implements DiscountCondition {
    public static final int SPECIAL_DISCOUNT_AMOUNT = SPECIAL_DISCOUNT.getDiscount();

    @Override
    public boolean isSatisfiedBy(OrderInfo orderInfo) {
        return orderInfo.reservation().hasInSpecialPeriods();
    }

    @Override
    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        return Money.of(SPECIAL_DISCOUNT_AMOUNT);
    }

    @Override
    public PromotionType getPromotionType() {
        return SPECIAL_DISCOUNT;
    }
}
