package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {
    @DisplayName("금액을 더하는 테스트")
    @ParameterizedTest
    @CsvSource({"10000, 100, 10100", "5000, 200, 5200", "0, 50, 50"})
    void 금액을_더함(int firstMoney, int secondMoney, int resultMoney) {
        Money currentMoney = Money.of(firstMoney);
        Money plusMoney = Money.of(secondMoney);
        assertThat(currentMoney.add(plusMoney)).isEqualTo(Money.of(resultMoney));
    }

    @DisplayName("금액을 차감하는 테스트")
    @ParameterizedTest
    @CsvSource({"10000, 100, 9900", "5000, 200, 4800", "0, 50, -50"})
    void 금액을_뺌(int firstMoney, int secondMoney, int resultMoney) {
        Money currentMoney = Money.of(firstMoney);
        Money minusMoney = Money.of(secondMoney);
        assertThat(currentMoney.subtract(minusMoney)).isEqualTo(Money.of(resultMoney));
    }
}
