package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.discount.Money;
import org.junit.jupiter.api.Test;

class DiscountAmountTest {
    @Test
    void 할인_금액_테스트() {
        Money amount1 = Money.of("10000");
        Money amount2 = Money.of("10000");
        assertThat(amount1).isEqualTo(amount2);
    }

    @Test
    void testZero() {
        Money zeroAmount = Money.of("0");
        assertThat(zeroAmount.isZero()).isEqualTo(true);
    }
}