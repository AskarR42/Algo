import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;
        for (int elem : arr1) {
            int l = 0;
            int r = arr2.length;
            while (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (arr2[mid] <= elem) {
                    l = mid;
                } else {
                    r = mid;
                }
            }

            if (Math.abs(elem - arr2[l]) > d && (l + 1 == arr2.length || Math.abs(elem - arr2[l + 1]) > d)) {
                count++;
            }
        }

        return count;
    }
}
