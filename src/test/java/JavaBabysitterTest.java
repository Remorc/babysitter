import org.junit.Test;

import static org.junit.Assert.*;

public class JavaBabysitterTest {

    private int START_TO_BED_PAY = 12;

    @Test
    public void shouldAddTwoNumbers() {
        int expectedPay = START_TO_BED_PAY;

        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 6, 6));
    }
}
