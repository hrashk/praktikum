package ya.praktikum.delivery;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DistanceTest {

    @ParameterizedTest(name = "[{index}] {0} km throws exception")
    @ValueSource(strings = {"0", "-3", "-0.1"})
    public void nonPostiveDistance(String distance) {
        assertThrows(NonPositiveDistanceException.class, () -> Distance.of(distance));
    }

    @ParameterizedTest(name = "[{index}] {0} km for {1} RUR")
    @CsvSource(value = {"0.1=50", "1=50", "2=50", "2.1=100", "7.13=100", "10=100",
            "10.1=200", "23.405=200", "30=200", "30.1=300", "773=300"}, delimiter = '=')
    public void boundaryValues(String distance, String price) {
        assertEquals(new BigDecimal(price), Distance.of(distance).computePrice());
    }
}
