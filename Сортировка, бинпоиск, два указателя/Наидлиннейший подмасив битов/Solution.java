class Solution {
    public int longestSubarray(int[] nums) {
        boolean zeroFound = false;
        int maxLength = Integer.MIN_VALUE;
        int firstCounter = 0;
        int secondCounter = 0;
        for (int elem : nums) {
            if (elem == 0) {
                if (!zeroFound) {
                    zeroFound = true;
                } else {
                    maxLength = Math.max(maxLength, firstCounter);
                    firstCounter = secondCounter;
                    secondCounter = 0;
                }
            } else {
                firstCounter++;
                if (zeroFound) {
                    secondCounter++;
                }
            }
        }
        maxLength = Math.max(maxLength, firstCounter);

        return zeroFound ? maxLength : maxLength - 1;
    }
}
