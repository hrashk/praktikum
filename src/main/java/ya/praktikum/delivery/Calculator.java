package ya.praktikum.delivery;

import java.math.BigDecimal;

public class Calculator {
    public BigDecimal computePrice(Distance distance, Size size, Durability durability, Workload workload) {
        return distance.computePrice()
                .add(size.price())
                .add(durability.price())
                .multiply(workload.factor());
    }
}
