// User function Template for Java

class Solution {
    public void mergeArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int gap = (m + n + 1) / 2;

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < (m + n)) {
                // Fetch values at i and j from nums1 or nums2
                int a, b;

                // Determine a
                if (i < m) a = nums1[i];
                else a = nums2[i - m];

                // Determine b
                if (j < m) b = nums1[j];
                else b = nums2[j - m];

                // Swap if out of order
                if (a > b) {
                    if (i < m && j < m) {
                        // Swap within nums1
                        int temp = nums1[i];
                        nums1[i] = nums1[j];
                        nums1[j] = temp;
                    } else if (i < m && j >= m) {
                        // Swap between nums1 and nums2
                        int temp = nums1[i];
                        nums1[i] = nums2[j - m];
                        nums2[j - m] = temp;
                    } else {
                        // Swap within nums2
                        int temp = nums2[i - m];
                        nums2[i - m] = nums2[j - m];
                        nums2[j - m] = temp;
                    }
                }
                i++;
                j++;
            }

            // Update the gap
            if (gap == 1) gap = 0;
            else gap = (gap + 1) / 2;
        }
    }
}

