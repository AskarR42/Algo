public class Main {

    public static void main(String[] args) {
        int x = 32;
        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
    }
}
