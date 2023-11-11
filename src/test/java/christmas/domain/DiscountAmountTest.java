package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DiscountAmountTest {
    @Test
    void 할인_금액_테스트() {
        DiscountAmount amount1 = DiscountAmount.of("10000");
        DiscountAmount amount2 = DiscountAmount.of("10000");
        assertThat(amount1).isEqualTo(amount2);
    }

    @Test
    void testZero() {
        DiscountAmount zeroAmount = DiscountAmount.of("0");
        assertThat(zeroAmount.isZero()).isEqualTo(true);
    }
}