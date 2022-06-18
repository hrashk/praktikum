package ya.praktikum.delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @ParameterizedTest(name = "[{index}] deliver a {1} {2} item under {3} workload over {0} km for {4} RUR")
    @CsvSource({
            "1,BIG,FRAGILE,NORMAL,550",
            "1,SMALL,STURDY,HIGH,400",
            "1,BIG,STURDY,HEAVY,400",
            "1,SMALL,FRAGILE,EXTREME,720",
            "7,SMALL,STURDY,NORMAL,400",
            "7,BIG,FRAGILE,HIGH,720",
            "7,SMALL,FRAGILE,HEAVY,700",
            "7,BIG,STURDY,EXTREME,480",
            "13,SMALL,FRAGILE,NORMAL,600",
            "13,BIG,STURDY,HIGH,480",
            "13,SMALL,FRAGILE,HEAVY,840",
            "13,BIG,FRAGILE,EXTREME,1120",
            "42,SMALL,STURDY,NORMAL,400",
            "42,BIG,STURDY,HIGH,600",
            "42,BIG,STURDY,HEAVY,700",
            "42,SMALL,STURDY,EXTREME,640"})
    public void pairwise(String distance, Size size, Durability durability, Workload workload, String price) {
        Calculator calculator = new Calculator();
        BigDecimal actual = calculator.computePrice(Distance.of(distance), size, durability, workload);
        assertEquals(new BigDecimal(price).compareTo(actual), 0);
    }

    @Test
    public void distanceTooLongForFragile() {
        Calculator calculator = new Calculator();
        assertThrows(FragileDistanceException.class, () ->
                calculator.computePrice(Distance.of("100"), Size.SMALL, Durability.FRAGILE, Workload.NORMAL));
    }
}
