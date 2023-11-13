package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDiscountTest {
    private WeekendDiscount weekendDiscount;

    @BeforeEach
    void setUp() {
        weekendDiscount = new WeekendDiscount();
    }

    @DisplayName("주말기간 할인 테스트")
    @Test
    void 주말_할인() {
        Reservation weekendReservation =Reservation.of(4);
        DiscountAmount discountAmount = weekendDiscount.calculateDiscountAmount(weekendReservation);
        assertThat(discountAmount.getDiscountAmount()).isEqualTo(new BigDecimal("2023"));
    }
}