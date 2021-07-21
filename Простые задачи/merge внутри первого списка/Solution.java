import java.util.Scanner;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            nums1[m + n - 1 - i] = nums1[m - 1 - i];
        }
        int i = n;
        int j = 0;
        int k = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m + n) {
            nums1[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
