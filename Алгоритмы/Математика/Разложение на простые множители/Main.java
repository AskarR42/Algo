import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> factors(int n) {
        List<Integer> f = new ArrayList<>();
        for (int x = 2; x * x <= n; x++) {
            while (n % x == 0) {
                f.add(x);
                n /= x;
            }
        }
        if (n > 1) {
            f.add(n);
        }

        return f;
    }
}
