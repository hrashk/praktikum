package ya.praktikum.delivery;

import java.math.BigDecimal;

public enum Durability {
    FRAGILE("300"), STURDY("0");

    private final BigDecimal price;

    Durability(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal price() {
        return price;
    }
}
