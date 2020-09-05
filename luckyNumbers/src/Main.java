public class Main {
    private static boolean isLucky(int n) {
        while (n > 0) {
            if (n % 10 == 4) {
                return false;
            }

            if (n % 100 == 13) {
                return false;
            }

            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 20;
        int luckyNumbersCount = 1;
        int luckyNumber = 0;
        int i = 1;

        while (luckyNumbersCount <= n) {
            if (isLucky(i)) {
                luckyNumbersCount++;
                luckyNumber = i;
            }
            i++;
        }

        System.out.println(luckyNumber);
    }
}
