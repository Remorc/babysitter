public class JavaBabysitter {

    private static int START_TO_BED_PAY = 12;
    private static int BED_TO_MIDNIGHT_PAY = 8;

    public static int calculatePay (int start, int bed, int end) {
        int pay = 0;

        if (bed > start) {
            pay = (end - start) * START_TO_BED_PAY;
        } else {
            pay = BED_TO_MIDNIGHT_PAY;
        }

        return pay;
    }
}
