package christmas.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class DiscountAmount {
    private BigDecimal discountAmount;

    private DiscountAmount(String discountAmount) {
        this.discountAmount = new BigDecimal(discountAmount);
    }

    public static DiscountAmount of(String discountAmount) {
        return new DiscountAmount(discountAmount);
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
        DiscountAmount that = (DiscountAmount) o;
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
