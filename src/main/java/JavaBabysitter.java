import java.util.HashMap;
import java.util.Map;

public class JavaBabysitter {

    private static int START_TO_BED_PAY = 12;
    private static int BED_TO_MIDNIGHT_PAY = 8;
    private static int AFTER_MIDNIGHT_PAY = 16;

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

        if (bed > start) {
            pay = (end - start) * START_TO_BED_PAY;
        } else if(start < 12) {
            pay = (end - start) * BED_TO_MIDNIGHT_PAY;
        } else {
            pay = (end - start) * AFTER_MIDNIGHT_PAY;
        }

        return pay;
    }
}
