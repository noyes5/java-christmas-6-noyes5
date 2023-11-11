package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("금액을 더하는 테스트")
    @Test
    void 금액을_더함() {
        Money currentMoney = new Money(new BigDecimal("10000"));
        Money plusMoney = new Money(new BigDecimal("1000"));
        assertThat(currentMoney.add(plusMoney)).isEqualTo(new Money(new BigDecimal("11000")));
    }

    @DisplayName("큰수에 금액을 더하는 테스트")
    @Test
    void 큰수_금액을_더함() {
        Money currentMoney = new Money(new BigDecimal("1000000000000"));
        Money plusMoney = new Money(new BigDecimal("1000000000000"));
        assertThat(currentMoney.add(plusMoney)).isEqualTo(new Money(new BigDecimal("2000000000000")));
    }

    @DisplayName("금액을 차감하는 테스트")
    @Test
    void 금액을_뺌() {
        Money currentMoney = new Money(new BigDecimal("10000"));
        Money minusMoney = new Money(new BigDecimal("1000"));
        assertThat(currentMoney.subtract(minusMoney)).isEqualTo(new Money(new BigDecimal("9000")));
    }

    @DisplayName("금액이 마이너스인 테스트")
    @Test
    void 작은수에서_큰수_금액을_뺌() {
        Money currentMoney = new Money(new BigDecimal("1000"));
        Money minusMoney = new Money(new BigDecimal("10000"));
        assertThat(currentMoney.subtract(minusMoney)).isEqualTo(new Money(new BigDecimal("-9000")));
    }
}
