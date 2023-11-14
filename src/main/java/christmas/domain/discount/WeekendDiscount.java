package christmas.domain.discount;

import static christmas.domain.promotion.PromotionType.WEEKEND_DISCOUNT;

import christmas.domain.Money;
import christmas.domain.promotion.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import christmas.dto.OrderInfo;

public class WeekendDiscount implements DiscountCondition {
    public static final int WEEKEND_DISCOUNT_AMOUNT = WEEKEND_DISCOUNT.getDiscount();

    @Override
    public boolean isSatisfiedBy(OrderInfo orderInfo) {
        return orderInfo.reservation().hasInWeekEndPeriods();
    }

    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        int mainAmount = orders.getMainItemCount();
        return Money.of(WEEKEND_DISCOUNT_AMOUNT).multiply(Money.of(mainAmount));
    }

    @Override
    public PromotionType getPromotionType() {
        return WEEKEND_DISCOUNT;
    }
}
