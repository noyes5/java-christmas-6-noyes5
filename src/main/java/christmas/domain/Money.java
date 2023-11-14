package christmas.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money add(Money other) {
        BigDecimal result = this.amount.add(other.amount);
        return new Money(result);
    }

    public Money subtract(Money other) {
        BigDecimal result = this.amount.subtract(other.amount);
        return new Money(result);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean exceedsEventPrice() {
        return amount.compareTo(BigDecimal.valueOf(10_000)) >= 0;
    }

    public boolean exceedsGiftPrice() {
        return amount.compareTo(BigDecimal.valueOf(120_000)) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
