import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    void testDiscountCalculation() {
        // الحالات الصالحة (Valid Cases) بناءً على التقرير
        // TC1: NEW, 0 orders, No Newsletter -> 5% discount [cite: 23]
        assertEquals(5, DiscountCalculator.calculateDiscount("NEW", 0, false));

        // TC4: REGULAR, 0 orders, Newsletter -> 10% discount [cite: 23]
        assertEquals(10, DiscountCalculator.calculateDiscount("REGULAR", 0, true));

        // TC5: REGULAR, 10 orders, No Newsletter -> 13% discount [cite: 23]
        assertEquals(13, DiscountCalculator.calculateDiscount("REGULAR", 10, false));

        // TC7: PREMIUM, 0 orders, No Newsletter -> 10% discount [cite: 23]
        assertEquals(10, DiscountCalculator.calculateDiscount("PREMIUM", 0, false));

        // TC8: PREMIUM, 10 orders, Newsletter -> 15% discount [cite: 23]
        assertEquals(15, DiscountCalculator.calculateDiscount("PREMIUM", 10, true));
    }

    @Test
    void testInvalidAndInfeasibleCases() {
        // الحالات التي ترفع IllegalArgumentException [cite: 4, 37]
        
        // TC2: NEW customer with 10 orders is Infeasible [cite: 31, 64]
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("NEW", 10, true));

        // TC3, TC6, TC9: Negative orders 
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("NEW", -1, false));

        // TC10, TC11, TC12: Invalid customer type (VIP) 
        assertThrows(IllegalArgumentException.class, () -> 
            DiscountCalculator.calculateDiscount("VIP", 5, true));
    }
}
