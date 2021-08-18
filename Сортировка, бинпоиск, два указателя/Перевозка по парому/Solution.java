class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = weights[0];
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
        }

        int l = maxWeight - 1;
        int r = Integer.MAX_VALUE;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if ((mid == maxWeight || countDays(weights, mid - 1) > days) && countDays(weights, mid) == days) {
                return mid;
            } else if (countDays(weights, mid) > days) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }

    private int countDays(int[] weights, int weight) {
        int counter = 0;
        int currWeight = 0;
        for (int w : weights) {
            if (currWeight + w > weight) {
                counter++;
                currWeight = w;
            } else {
                currWeight += w;
            }
        }

        return ++counter;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;
        System.out.println(solution.shipWithinDays(weights, days));
    }
}
