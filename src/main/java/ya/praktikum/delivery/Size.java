package ya.praktikum.delivery;

import java.math.BigDecimal;

public enum Size {
    BIG("200"), SMALL("100");

    private final BigDecimal price;

    Size(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal price() {
        return price;
    }
}
