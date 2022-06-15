package ya.praktikum.delivery;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void priceComputation() {
        Calculator calculator = new Calculator();
        BigDecimal price = calculator.computePrice(Distance.of("1"), Size.SMALL, Durability.FRAGILE, Workload.NORMAL);
        assertEquals(BigDecimal.valueOf(450), price);
    }

    @Test
    public void below400() {
        Calculator calculator = new Calculator();
        BigDecimal price = calculator.computePrice(Distance.of("1"), Size.SMALL, Durability.STURDY, Workload.NORMAL);
        assertEquals(BigDecimal.valueOf(400), price);
    }
}
