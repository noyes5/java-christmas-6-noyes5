package christmas.domain.discount;

import static christmas.domain.discount.ChristmasDiscount.CHRISTMAS_DISCOUNT_PER_DAY;
import static christmas.domain.discount.ChristmasDiscount.DEFAULT_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscountTest {
    private ChristmasDiscount christmasDiscount;
    private Orders orders;
    private Map<String, Integer> fakeOrderItems;

    @BeforeEach
    void setUp() {
        christmasDiscount = new ChristmasDiscount();
        fakeOrderItems = Map.of("티본스테이크",1,"제로콜라",2);
        orders = Orders.createOrder(fakeOrderItems);
    }

    @DisplayName("크리스마스 첫날 할인 금액 확인 테스트")
    @Test
    void 첫날_할인_금액_확인() {
        Reservation reservation = Reservation.of(1);
        Money discountMoney = christmasDiscount.calculateDiscountAmount(reservation, orders);
        assertThat(discountMoney).isEqualTo(Money.of(DEFAULT_DISCOUNT));
    }

    @DisplayName("크리스마스 마지막날 할인 금액 확인 테스트")
    @Test
    void 마지막날_할인_금액_확인() {
        Reservation reservation = Reservation.of(25);
        Money discountMoney = christmasDiscount.calculateDiscountAmount(reservation, orders);
        assertThat(discountMoney).isEqualTo(Money.of(DEFAULT_DISCOUNT).add(Money.of(CHRISTMAS_DISCOUNT_PER_DAY * 24)));
    }
}
