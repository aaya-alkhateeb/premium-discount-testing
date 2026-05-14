import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    void testDiscountCalculation() {
        assertEquals(5, DiscountCalculator.calculateDiscount("NEW", 0, false));

        assertEquals(10, DiscountCalculator.calculateDiscount("REGULAR", 0, true));

        assertEquals(13, DiscountCalculator.calculateDiscount("REGULAR", 10, false));

        assertEquals(10, DiscountCalculator.calculateDiscount("PREMIUM", 0, false));

        assertEquals(15, DiscountCalculator.calculateDiscount("PREMIUM", 10, true));
    }

    @Test
    void testInvalidAndInfeasibleCases() {
        
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("NEW", 10, true));

        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("NEW", -1, false));

        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("VIP", 5, true));
    }
}
