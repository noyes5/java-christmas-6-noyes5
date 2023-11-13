package christmas.domain.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountAmount;
import christmas.domain.Reservation;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscountTest {
    private ChristmasDiscount christmasDiscount;

    @BeforeEach
    void setUp() {
        christmasDiscount = new ChristmasDiscount();
    }

    @DisplayName("크리스마스 첫날 할인 금액 확인 테스트")
    @Test
    void 첫날_할인_금액_확인() {
        Reservation reservation = Reservation.of(1);
        DiscountAmount discount = christmasDiscount.calculateDiscountAmount(reservation);
        assertThat(discount.getDiscountAmount()).isEqualTo(new BigDecimal("1000"));
    }

    @DisplayName("크리스마스 마지막날 할인 금액 확인 테스트")
    @Test
    void 마지막날_할인_금액_확인() {
        Reservation reservation = Reservation.of(25);
        DiscountAmount discount = christmasDiscount.calculateDiscountAmount(reservation);
        assertThat(discount.getDiscountAmount()).isEqualTo(new BigDecimal("3400"));
    }
}
