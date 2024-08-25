//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to count the number of pairs such that x^y > y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y); // Sort the y array for binary search

        // Precompute counts of specific small values in y
        int[] count = new int[5];
        for (int num : y) {
            if (num < 5) {
                count[num]++;
            }
        }

        long totalPairs = 0;

        // Iterate over each element in x[]
        for (int i = 0; i < M; i++) {
            totalPairs += countForX(x[i], y, count, N);
        }

        return totalPairs;
    }

    // Helper function to count valid pairs for a given x
    private long countForX(int x, int[] y, int[] count, int N) {
        if (x == 0) return 0; // No valid pairs when x is 0
        if (x == 1) return count[0]; // Only pairs with y=0 are valid when x=1

        // Find the index of the first element in y[] that is greater than x
        int idx = findFirstGreaterThan(y, x, N);
        long validPairs = N - idx; // All elements after idx will satisfy x^y > y^x

        // Add pairs where y = 0 or y = 1
        validPairs += count[0] + count[1];

        // Special case adjustments:
        if (x == 2) {
            validPairs -= count[3] + count[4]; // Remove pairs where y=3 or y=4
        }
        if (x == 3) {
            validPairs += count[2]; // Add pairs where y=2 (because 3^2 > 2^3)
        }

        return validPairs;
    }

    // Helper function to perform binary search to find the first index with value greater than x
    private int findFirstGreaterThan(int[] y, int x, int N) {
        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (y[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
