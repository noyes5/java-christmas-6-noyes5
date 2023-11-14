package christmas.domain.discount;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal discountAmount;

    private Money(String discountAmount) {
        this.discountAmount = new BigDecimal(discountAmount);
    }

    public static Money of(String discountAmount) {
        return new Money(discountAmount);
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public boolean isZero() {
        return discountAmount.equals(BigDecimal.ZERO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money that = (Money) o;
        return Objects.equals(discountAmount, that.discountAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountAmount);
    }

    @Override
    public String toString() {
        return "DiscountAmount{" +
                "discountAmount=" + discountAmount +
                '}';
    }
}
