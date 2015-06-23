import java.util.HashMap;
import java.util.Map;

public class JavaBabysitter {

    private static int START_TO_BED_PAY = 12;
    private static int BED_TO_MIDNIGHT_PAY = 8;
    private static int AFTER_MIDNIGHT_PAY = 16;
    private static int MIDNIGHT = 12;

    private static Map<Integer, Integer> map;
    static {
        map = new HashMap<>();
        map.put(1, 13);
        map.put(2, 14);
        map.put(3, 15);
        map.put(4, 16);
    }

    public static int calculatePay (int startTime, int bedTime, int endTime) {
        int pay = 0;
        int start = map.getOrDefault(startTime, startTime);
        int bed = map.getOrDefault(bedTime, bedTime);
        int end = map.getOrDefault(endTime, endTime);

        pay += calculateStartToBedPay(start, bed);
        pay += calculateBedToMidnightPay(bed, end);
        pay += calculateAfterMidnightPay(start, end);

        return pay;
    }

    private static int calculateAfterMidnightPay(int start, int end) {
        int pay = 0;

        if (end > MIDNIGHT){
            pay += (end - start) * AFTER_MIDNIGHT_PAY;
        }
        return pay;
    }

    private static int calculateBedToMidnightPay(int bed, int end) {
        int pay = 0;

        if (end > bed && end < MIDNIGHT) {
            pay += (end - bed) * BED_TO_MIDNIGHT_PAY;
        }
        return pay;
    }

    private static int calculateStartToBedPay(int start, int bed) {
        int pay = 0;

        if (start < bed) {
            pay += (bed - start) * START_TO_BED_PAY;
        }
        return pay;
    }
}
