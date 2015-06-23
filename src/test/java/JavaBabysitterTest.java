import org.junit.Test;

import static org.junit.Assert.*;

public class JavaBabysitterTest {

    private int START_TO_BED_PAY = 12;
    private int BED_TO_MIDNIGHT_PAY = 8;
    private int AFTER_MIDNIGHT_PAY = 16;

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

    @Test
    public void shouldCalculatePayForMultipleHoursBetweenStartAndEndAfterBedBeforeMidnight() {
        int expectedPay = BED_TO_MIDNIGHT_PAY * 2;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 5, 7));
    }

    @Test
    public void shouldCalculatePayForOneHourBetweenStartAndEndAfterMidnight() {
        int expectedPay = AFTER_MIDNIGHT_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(1, 1, 2));
    }

    @Test
    public void shouldCalculatePayForMultipleHoursBetweenStartAndEndAfterMidnight() {
        int expectedPay = AFTER_MIDNIGHT_PAY * 2;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(1, 1, 3));
    }

    @Test
    public void shouldBeAbleToHandleRollOverAtMidnight() {
        int expectedPay = AFTER_MIDNIGHT_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(12, 12, 1));
    }

    @Test
    public void shouldCalculatePayWhenCrossingBedtimeBeforeMidnight() {
        int expectedPay = START_TO_BED_PAY + BED_TO_MIDNIGHT_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 6, 7));
    }
}
