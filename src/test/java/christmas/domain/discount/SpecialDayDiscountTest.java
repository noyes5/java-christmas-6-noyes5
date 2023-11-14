package christmas.domain.discount;

import static christmas.domain.discount.SpecialDayDiscount.SPECIAL_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDayDiscountTest {
    private SpecialDayDiscount specialDayDiscount;
    private Orders orders;
    private Map<String, Integer> fakeOrderItems;

    @BeforeEach
    void setUp() {
        specialDayDiscount = new SpecialDayDiscount();
        fakeOrderItems = Map.of("티본스테이크",1,"제로콜라",2);
        orders = Orders.createOrder(fakeOrderItems);
    }

    @DisplayName("특별기간 할인 테스트")
    @Test
    void 특별일자_할인() {
        Reservation specialdayReservation = Reservation.from(3);
        Money discountMoney = specialDayDiscount.calculateDiscountAmount(specialdayReservation, orders);
        assertThat(discountMoney).isEqualTo(Money.of(SPECIAL_DISCOUNT_AMOUNT));
    }
}