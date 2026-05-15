import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountCalculatorTest {

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "TC1, NEW, 0, false, 5",
        "TC4, REGULAR, 0, true, 10",
        "TC5, REGULAR, 10, false, 13",
        "TC7, PREMIUM, 0, false, 10",
        "TC8, PREMIUM, 10, true, 15"
    })
    void testValidDiscounts(String tc, String type, int orders, boolean newsletter, int expected) {
        assertEquals(expected, DiscountCalculator.calculateDiscount(type, orders, newsletter));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "TC2, NEW, 10, true",
        "TC3, NEW, -1, false",
        "TC6, REGULAR, -1, true",
        "TC9, PREMIUM, -1, false",
        "TC10, VIP, 5, true",
        "TC11, VIP, 10, false",
        "TC12, VIP, -1, true"
    })
    void testInvalidInputs(String tc, String type, int orders, boolean newsletter) {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountCalculator.calculateDiscount(type, orders, newsletter);
        });
    }
}
