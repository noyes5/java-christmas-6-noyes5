package christmas.domain.discount;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiscountPolicy {
    private final List<DiscountCondition> conditions;

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

    public Map<DiscountCondition, Money> collectDiscounts(Reservation reservation, Orders orders) {
        Map<DiscountCondition, Money> collectDiscounts = new LinkedHashMap<>();

        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(reservation)) {
                Money discountMoney = condition.calculateDiscountAmount(reservation, orders);
                collectDiscounts.put(condition, discountMoney);
            }
        }
        return collectDiscounts;
    }
}
