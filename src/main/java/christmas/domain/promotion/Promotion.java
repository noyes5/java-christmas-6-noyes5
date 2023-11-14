package christmas.domain.promotion;

import static christmas.domain.promotion.PromotionType.GIVING_GIFT;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.discount.DiscountCondition;
import christmas.domain.menu.Orders;
import java.util.Map;

public class Promotion {
    private Map<DiscountCondition, Money> collectDiscounts;

    public Promotion(DiscountPolicy discountPolicy, Reservation reservation, Orders orders) {
        this.collectDiscounts = discountPolicy.collectDiscounts(reservation, orders);
    }

    public Map<DiscountCondition, Money> getCollectDiscounts() {
        return collectDiscounts;
    }

    public Money calculateBenefitAmount() {
        Money benefitMoney = Money.ZERO;

        for (Money discountAmount : collectDiscounts.values()) {
            benefitMoney = benefitMoney.add(discountAmount);
        }
        return benefitMoney;
    }

    public Money calculateDiscountAmount() {
        Money discountMoney = calculateBenefitAmount();

        for (DiscountCondition condition : collectDiscounts.keySet()) {
            if (condition.getPromotionType() == GIVING_GIFT) {
                discountMoney = discountMoney.subtract(collectDiscounts.get(condition));
            }
        }
        return discountMoney;
    }
}
