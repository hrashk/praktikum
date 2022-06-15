package ya.praktikum.delivery;

import java.math.BigDecimal;

public enum Durability {
    FRAGILE("300") {
        @Override
        public void checkDistance(BigDecimal distance) {
            if (distance.compareTo(MAX_FRAGILE_DISTANCE) > 0) {
                throw new FragileDistanceException();
            }
        }
    },
    STURDY("0");

    private static final BigDecimal MAX_FRAGILE_DISTANCE = new BigDecimal("30");
    private final BigDecimal price;

    Durability(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal price() {
        return price;
    }

    public void checkDistance(BigDecimal distance) {

    }
}
