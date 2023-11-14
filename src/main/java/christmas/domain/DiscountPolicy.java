package christmas.domain;

import christmas.domain.discount.ChristmasDiscount;
import christmas.domain.discount.DiscountCondition;
import christmas.domain.discount.GivingGiftDiscount;
import christmas.domain.discount.SpecialDayDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.Orders;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiscountPolicy {
    private static List<DiscountCondition> conditions;

    public DiscountPolicy(Money totalMoney) {
        conditions = new ArrayList<>();
        initializeConditions(totalMoney);
    }

    private void initializeConditions(Money totalMoney) {
        if (totalMoney.exceedsEventPrice()) {
            conditions.add(new ChristmasDiscount());
            conditions.add(new WeekdayDiscount());
            conditions.add(new WeekendDiscount());
            conditions.add(new SpecialDayDiscount());
            conditions.add(new GivingGiftDiscount());
        }
    }

    public Map<DiscountCondition, Money> calculateDiscountAmounts(Reservation reservation, Orders orders) {
        Map<DiscountCondition, Money> discountAmounts = new LinkedHashMap<>();

        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(reservation)) {
                Money discountMoney = condition.calculateDiscountAmount(reservation, orders);
                discountAmounts.put(condition, discountMoney);
            }
        }
        return discountAmounts;
    }
}
