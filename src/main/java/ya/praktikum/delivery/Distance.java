package ya.praktikum.delivery;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        for (LowerBound b : LowerBound.inDecreasingOrder()) {
            if (b.bound.compareTo(value) < 0)
                return b.price;
        }
        throw new IllegalStateException("value = " + value);
    }

    private enum LowerBound {
        BOUND0("0", "50"),
        BOUND2("2", "100"),
        BOUND10("10", "200"),
        BOUND30("30", "300"),
        ;

        final BigDecimal bound;
        final BigDecimal price;

        LowerBound(String bound, String price) {
            this.bound = new BigDecimal(bound);
            this.price = new BigDecimal(price);
        }

        static List<LowerBound> inDecreasingOrder() {
            return Stream.of(values())
                    .sorted(Comparator.comparing((LowerBound lowerBound) -> lowerBound.bound).reversed())
                    .collect(Collectors.toList());
        }
    }
}
