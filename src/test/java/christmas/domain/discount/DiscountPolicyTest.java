package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Money;
import christmas.domain.Reservation;
import christmas.domain.menu.Orders;
import christmas.dto.OrderInfo;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {
    @DisplayName("할인 정책 테스트 - 금액이 10000원 이하인 경우")
    @Test
    void 주문금액_미달_정책_확인() {
        DiscountPolicy discountPolicy = new DiscountPolicy(Money.of(9_000));

        Reservation christmasReservation = Reservation.from(1);
        Orders orders = Orders.createOrder(Map.of("티본스테이크", 1, "제로콜라", 2));
        OrderInfo orderInfo = new OrderInfo(christmasReservation, orders);

        Map<DiscountCondition, Money> discounts = discountPolicy.collectDiscounts(orderInfo);
        assertThat(discounts.size()).isEqualTo(0);
    }

    @DisplayName("할인 정책 테스트 - 크리스마스 기간, 주말")
    @Test
    void 크리스마스_주말_정책_확인() {
        DiscountPolicy discountPolicy = new DiscountPolicy(Money.of(15_000));
        Reservation christmasReservation = Reservation.from(1);
        Orders orders = Orders.createOrder(Map.of("티본스테이크", 1, "제로콜라", 2));
        OrderInfo orderInfo = new OrderInfo(christmasReservation, orders);

        Map<DiscountCondition, Money> discounts = discountPolicy.collectDiscounts(orderInfo);

        assertThat(discounts.size()).isEqualTo(2);
    }

    @DisplayName("할인 정책 테스트 - 크리스마스 기간, 주말, 특별")
    @Test
    void 크리스마스_주말_특별_정책_확인() {
        DiscountPolicy discountPolicy = new DiscountPolicy(Money.of(15_000));
        Reservation christmasReservation = Reservation.from(3);
        Orders orders = Orders.createOrder(Map.of("티본스테이크", 1, "제로콜라", 2));
        OrderInfo orderInfo = new OrderInfo(christmasReservation, orders);

        Map<DiscountCondition, Money> discounts = discountPolicy.collectDiscounts(orderInfo);

        assertThat(discounts.size()).isEqualTo(3);
    }

    @DisplayName("할인 정책 테스트 - 크리스마스 기간, 주말, 특별, 증정품")
    @Test
    void 크리스마스_주말_특별_증정_정책_확인() {
        DiscountPolicy discountPolicy = new DiscountPolicy(Money.of(120_000));
        Reservation christmasReservation = Reservation.from(24);
        Orders orders = Orders.createOrder(Map.of("티본스테이크", 18, "제로콜라", 2));
        OrderInfo orderInfo = new OrderInfo(christmasReservation, orders);

        Map<DiscountCondition, Money> discounts = discountPolicy.collectDiscounts(orderInfo);

        assertThat(discounts.size()).isEqualTo(4);
    }

}
