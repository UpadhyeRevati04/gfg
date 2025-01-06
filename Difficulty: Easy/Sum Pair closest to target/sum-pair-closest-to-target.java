//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if array has fewer than 2 elements, return empty list
        if (arr == null || arr.length < 2) {
            return result;
        }

        // Sort the array
        Arrays.sort(arr);

        // Initialize variables
        int closestSum = Integer.MAX_VALUE; // To track the closest sum to the target
        int maxAbsDiff = Integer.MIN_VALUE; // To track maximum absolute difference

        int left = 0, right = arr.length - 1;

        // Two-pointer approach
        while (left < right) { // `left < right` because we need pairs, not a single element
            int sum = arr[left] + arr[right];

            // Check if the current sum is closer to the target
            if (Math.abs(target - sum) < Math.abs(target - closestSum) ||
                (Math.abs(target - sum) == Math.abs(target - closestSum) && (arr[right] - arr[left] > maxAbsDiff))) {

                // Update closest sum and result pair
                closestSum = sum;
                maxAbsDiff = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }

            // Adjust pointers based on the current sum
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
        
    }
}