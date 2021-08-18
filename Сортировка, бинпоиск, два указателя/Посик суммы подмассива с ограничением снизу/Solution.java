class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int length = 1;
        int sum = nums[0];

        while (true) {
            if (sum >= target) {
                minLength = Math.min(minLength, length);
                if (i == j && j < nums.length - 1) {
                    j++;
                    length++;
                    sum += nums[j];
                } else {
                    i++;
                    length--;
                    sum -= nums[i - 1];
                }
            } else {
                if (j < nums.length - 1) {
                    j++;
                    length++;
                    sum += nums[j];
                } else {
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
