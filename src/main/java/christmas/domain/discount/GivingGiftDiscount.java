package christmas.domain.discount;

import static christmas.domain.promotion.PromotionType.GIVING_GIFT;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.gift.Gift;
import christmas.domain.menu.Orders;
import christmas.domain.promotion.PromotionType;
import christmas.dto.MenuItem;
import christmas.dto.OrderInfo;
import java.util.List;

public class GivingGiftDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(OrderInfo orderInfo) {
        return orderInfo.orders().calculateTotalMoney().exceedsGiftPrice();
    }

    @Override
    public Money calculateDiscountAmount(Reservation reservation, Orders orders) {
        Money totalMoney = orders.calculateTotalMoney();
        Gift gift = orders.giveGift(totalMoney);
        List<MenuItem> gifts = gift.getGifts();

        return gifts.stream()
                .map(giftMenu -> Money.of(giftMenu.menu().getPrice()))
                .reduce(Money::add)
                .orElse(Money.ZERO);
    }

    @Override
    public PromotionType getPromotionType() {
        return GIVING_GIFT;
    }
}
