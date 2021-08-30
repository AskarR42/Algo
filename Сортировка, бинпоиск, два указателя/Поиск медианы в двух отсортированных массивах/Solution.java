class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int realMedianInMergedArray = (n + m + 1) / 2;
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            int leftASize = mid;
            int leftBSize = realMedianInMergedArray - mid;

            int x1 = leftASize > 0 ? nums1[leftASize - 1] : Integer.MIN_VALUE;
            int y1 = leftASize < n ? nums1[leftASize] : Integer.MAX_VALUE;
            int x2 = leftBSize > 0 ? nums2[leftBSize - 1] : Integer.MIN_VALUE;
            int y2 = leftBSize < m ? nums2[leftBSize] : Integer.MAX_VALUE;

            if (x1 <= y2 && x2 <= y1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2.0;
                } else {
                    return Math.max(x1, x2);
                }
            } else if (x1 > y2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return 0.0;
    }
}
