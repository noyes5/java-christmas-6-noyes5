package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDayDiscountTest {
    private SpecialDayDiscount specialDayDiscount;

    @BeforeEach
    void setUp() {
        specialDayDiscount = new SpecialDayDiscount();
    }

    @DisplayName("특별기간 할인 테스트")
    @Test
    void 특별일자_할인() {
        Reservation specialdayReservation = new Reservation(LocalDate.of(2023, 12, 3));
        DiscountAmount discountAmount = specialDayDiscount.calculateDiscountAmount(specialdayReservation);
        assertThat(discountAmount.getDiscountAmount()).isEqualTo(new BigDecimal("1000"));
    }
}