//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.ListIterator;

class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of total number of testcases
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {

            // Taking the string as input
            String str = sc.nextLine();
            Solution ob = new Solution();
            // Calling the unique_substring method
            // and printing the result
            System.out.println(ob.unique_substring(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int unique_substring(String s) {
        // Your code here
        int n = s.length();
        
        // Step 1: Build suffix array
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
        }
        Arrays.sort(suffixes); // Sort suffixes lexicographically
        
        // Step 2: Build LCP array (Longest Common Prefix)
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            lcp[i] = longestCommonPrefix(suffixes[i - 1], suffixes[i]);
        }
        
        // Step 3: Calculate total unique substrings
        int totalSubstrings = 0;
        for (int i = 0; i < n; i++) {
            totalSubstrings += suffixes[i].length(); // All substrings of this suffix
            totalSubstrings -= lcp[i];              // Remove overlapping substrings
        }
        
        return totalSubstrings;
    } private static int longestCommonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    }