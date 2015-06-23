public class JavaBabysitter {

    private static int START_TO_BED_PAY = 12;

    public static int calculatePay (int start, int bed, int end) {
        return (end - start) * START_TO_BED_PAY;
    }
}
