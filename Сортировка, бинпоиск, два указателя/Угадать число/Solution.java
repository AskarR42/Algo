public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) <= 0) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }
}
