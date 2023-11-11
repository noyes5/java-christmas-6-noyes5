package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.discount.ChristmasDiscount;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasDiscountTest {
    private ChristmasDiscount christmasDiscount;

    @BeforeEach
    void setUp() {
        christmasDiscount = new ChristmasDiscount();
    }

    @DisplayName("크리스마스 기간 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    void 크리스마스_기간_확인(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(date);
        assertThat(christmasDiscount.isSatisfiedBy(reservation)).isTrue();
    }

    @DisplayName("비크리스마스 기간 테스트")
    @ParameterizedTest
    @ValueSource(ints = {26, 31})
    void 비크리스마스_기간_확인(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(date);
        assertThat(christmasDiscount.isSatisfiedBy(reservation)).isFalse();
    }

    @DisplayName("크리스마스 첫날 할인 금액 확인 테스트")
    @Test
    void 첫날_할인_금액_확인() {
        Reservation reservation = new Reservation(LocalDate.of(2023, 12, 1));
        DiscountAmount discount = christmasDiscount.calculateDiscountAmount(reservation);
        assertThat(discount.getDiscountAmount()).isEqualTo(new BigDecimal("1000"));
    }

    @DisplayName("크리스마스 마지막날 할인 금액 확인 테스트")
    @Test
    void 마지막날_할인_금액_확인() {
        Reservation reservation = new Reservation(LocalDate.of(2023, 12, 25));
        DiscountAmount discount = christmasDiscount.calculateDiscountAmount(reservation);
        assertThat(discount.getDiscountAmount()).isEqualTo(new BigDecimal("3400"));
    }
}
