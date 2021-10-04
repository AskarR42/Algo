public class Main {

    private static int[] gcd(int a, int b) {
        if (b == 0) {
            return new int[]{1, 0, a};
        } else {
            int[] tie = gcd(b, a % b);
            int x = tie[0];
            int y = tie[1];
            int g = tie[2];
            return new int[]{y, x - a / b * y, g};
        }
    }
}
