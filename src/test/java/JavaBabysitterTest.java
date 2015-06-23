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

    @Test
    public void shouldCalculatePayWhenCrossingMidnight() {
        int expectedPay = BED_TO_MIDNIGHT_PAY + AFTER_MIDNIGHT_PAY;
        assertEquals(expectedPay, JavaBabysitter.calculatePay(11, 11, 1));
    }

    @Test
    public void shouldCalculatePayForFullNightOfWork() {
        int expectedPay = (START_TO_BED_PAY * 4) + (BED_TO_MIDNIGHT_PAY * 3) + (AFTER_MIDNIGHT_PAY * 4);
        assertEquals(expectedPay, JavaBabysitter.calculatePay(5, 9, 4));
    }

    @Test
    public void shouldCalculatePayWhenGoingToBedBeforeStartTime() {
        int expectedPay = (BED_TO_MIDNIGHT_PAY * 2) + (AFTER_MIDNIGHT_PAY * 4);
        assertEquals(expectedPay, JavaBabysitter.calculatePay(10, 5, 4));
    }

    @Test
    public void shouldCalculatePayWhenGoingToBedAfterMidnight() {
        int expectedPay = (START_TO_BED_PAY * 2) + (AFTER_MIDNIGHT_PAY * 4);
        assertEquals(expectedPay, JavaBabysitter.calculatePay(10, 1, 4));
    }
}
