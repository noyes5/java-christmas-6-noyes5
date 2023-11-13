package christmas.domain.discount;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayDiscountTest {
    private WeekdayDiscount weekdayDiscount;

    @BeforeEach
    void setUp() {
        weekdayDiscount = new WeekdayDiscount();
    }

    @DisplayName("평일기간 할인 테스트")
    @Test
    void 평일_할인() {
        Reservation weekdayReservation = new Reservation(LocalDate.of(2023, 12, 4));
        DiscountAmount discountAmount = weekdayDiscount.calculateDiscountAmount(weekdayReservation);
        assertThat(discountAmount.getDiscountAmount()).isEqualTo(new BigDecimal("2023"));
    }
}