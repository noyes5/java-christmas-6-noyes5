package christmas.domain.discount;


import static christmas.domain.discount.WeekdayDiscount.WEEKDAY_DISCOUNT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayDiscountTest {
    private WeekdayDiscount weekdayDiscount;
    private Orders orders;
    private Map<String, Integer> fakeOrderItems;

    @BeforeEach
    void setUp() {
        weekdayDiscount = new WeekdayDiscount();
        fakeOrderItems = Map.of("초코케이크",1,"제로콜라",2);
        orders = Orders.createOrder(fakeOrderItems);
    }

    @DisplayName("평일기간 할인 테스트")
    @Test
    void 평일_할인() {
        Reservation weekdayReservation = Reservation.of(3);
        Money discountMoney = weekdayDiscount.calculateDiscountAmount(weekdayReservation, orders);
        assertThat(discountMoney).isEqualTo(Money.of(WEEKDAY_DISCOUNT_AMOUNT));
    }
}