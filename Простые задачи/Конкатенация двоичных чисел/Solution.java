class Solution {

    final int M = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 1;
        int length = 0;
        for (int i = 2; i <= n; i++) {
            length = (int) (Math.log(i) / Math.log(2)) + 1;
            result = ((result<<length) + i) % M;
        }

        return (int) result;
    }
}
