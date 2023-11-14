package christmas.domain.discount;

import static christmas.domain.discount.WeekendDiscount.WEEKEND_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDiscountTest {
    private WeekendDiscount weekendDiscount;
    private Orders orders;
    private Map<String, Integer> fakeOrderItems;

    @BeforeEach
    void setUp() {
        weekendDiscount = new WeekendDiscount();
        fakeOrderItems = Map.of("티본스테이크",1,"제로콜라",2);
        orders = Orders.createOrder(fakeOrderItems);
    }

    @DisplayName("주말기간 할인 테스트")
    @Test
    void 주말_할인() {
        Reservation weekendReservation =Reservation.of(4);
        christmas.domain.Money discountMoney = weekendDiscount.calculateDiscountAmount(weekendReservation, orders);
        assertThat(discountMoney).isEqualTo(Money.of(WEEKEND_DISCOUNT_AMOUNT));
    }
}