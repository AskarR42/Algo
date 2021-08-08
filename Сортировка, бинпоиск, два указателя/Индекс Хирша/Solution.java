class Solution {
    public int hIndex(int[] citations) {
        int left = -1;
        int right = citations.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (citations.length - mid <= citations[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return citations.length - right;
    }
}
