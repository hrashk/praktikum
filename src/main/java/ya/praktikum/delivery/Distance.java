package ya.praktikum.delivery;

import java.math.BigDecimal;

public final class Distance {
    private final BigDecimal value;

    public Distance(BigDecimal d) {
        this.value = d;
    }

    public static Distance of(String d) {
        return of(new BigDecimal(d));
    }

    public static Distance of(BigDecimal d) {
        if (BigDecimal.ZERO.compareTo(d) >= 0)
            throw new NonPositiveDistanceException();

        return new Distance(d);
    }

    public BigDecimal computePrice() {
        if (value.compareTo(BigDecimal.valueOf(2)) <= 0)
            return BigDecimal.valueOf(50);
        return BigDecimal.valueOf(100);
    }
}
