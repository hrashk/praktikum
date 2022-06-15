package ya.praktikum.delivery;

import java.math.BigDecimal;

public enum Workload {
    EXTREME("1.6"), HEAVY("1.4"), HIGH("1.2"), NORMAL("1");

    private final BigDecimal factor;

    Workload(String factor) {
        this.factor = new BigDecimal(factor);
    }

    public BigDecimal factor() {
        return factor;
    }
}
