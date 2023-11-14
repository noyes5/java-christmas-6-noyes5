package christmas.domain.discount;

import static christmas.domain.PromotionType.GIVING_GIFT;

import christmas.domain.Money;
import christmas.domain.PromotionType;
import christmas.domain.Reservation;
import christmas.domain.dto.MenuItem;
import christmas.domain.gift.Gift;
import christmas.domain.menu.Orders;
import java.util.List;

public class GivingGiftDiscount implements DiscountCondition {
    @Override
    public boolean isSatisfiedBy(Reservation reservation) {
        return reservation.hasInPeriods();
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
