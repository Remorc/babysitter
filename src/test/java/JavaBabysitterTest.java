import org.junit.Test;

import static org.junit.Assert.*;

public class JavaBabysitterTest {

    private int START_TO_BED_PAY = 12;
    private int BED_TO_MIDNIGHT_PAY = 8;

    @Test
    public void shouldCalculatePayForOneHourBetweenStartAndEndBeforeBed() {
        int expectedPay = START_TO_BED_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 6, 6));
    }

    @Test
    public void shouldCalculatePayForMultipleHoursBetweenStartAndEndBeforeBed() {
        int expectedPay = START_TO_BED_PAY * 2;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 7, 7));
    }

    @Test
    public void shouldCalculatePayForOneHourBetweenStartAndEndAfterBedBeforeMidnight() {
        int expectedPay = BED_TO_MIDNIGHT_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 5, 6));
    }
}
