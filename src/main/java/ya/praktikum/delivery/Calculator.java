package ya.praktikum.delivery;

import java.math.BigDecimal;

public class Calculator {

    public static final BigDecimal MINIMUM_PRICE = BigDecimal.valueOf(400);

    public BigDecimal computePrice(Distance distance, Size size, Durability durability, Workload workload) {
        durability.checkDistance(distance.value());
        BigDecimal price = distance.computePrice()
                .add(size.price())
                .add(durability.price())
                .multiply(workload.factor());
        return price.max(MINIMUM_PRICE);
    }
}
