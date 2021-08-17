import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        Arrays.sort(nums);
        int l = 0;
        int counter = 0;
        int prev = Integer.MAX_VALUE;
        for (int r = 1; r < nums.length; r++) {
            while (l < r && nums[r] - nums[l] > k) {
                l++;
            }

            if (l < r && prev != nums[l] && nums[r] - nums[l] == k) {
                counter++;
                prev = nums[l];
            }
        }

        return counter;
    }
}
