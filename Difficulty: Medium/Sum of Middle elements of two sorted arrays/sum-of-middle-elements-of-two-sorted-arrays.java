//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int m = arr1.length;
        int n = arr2.length;
        int totalLength = m+n;
        int[] merged = new int[totalLength];
        int i =0,j=0,k=0;
         while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
         while (i < m) {
            merged[k++] = arr1[i++];
        }
         while (j < n) {
            merged[k++] = arr2[j++];
        }
          if (totalLength % 2 == 0) {
            int mid1 = totalLength / 2 - 1;
            int mid2 = totalLength / 2;
            return merged[mid1] + merged[mid2];
        } else {
            int mid = totalLength / 2;
            return 2 * merged[mid];
        }
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends