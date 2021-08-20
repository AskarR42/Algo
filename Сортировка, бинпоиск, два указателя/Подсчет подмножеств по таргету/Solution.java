import java.util.Arrays;

class Solution {
    int M = 1000000007;

    public int numSubseq(int[] nums, int target) {
        int counter = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i;
            int r = nums.length;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= target - nums[i]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (i - l == 0) {
                if (2 * nums[l] <= target) {
                    counter = (counter + 1) % M;
                }
            } else {
                counter = (counter % M + binpow(l - i) % M) % M;
            }
        }

        return counter;
    }

    private int binpow(int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return ((binpow(n - 1) % M) * 2) % M;
        } else {
            long b = binpow(n / 2) % M;
            return (int) ((b * b) % M);
        }
    }
}
