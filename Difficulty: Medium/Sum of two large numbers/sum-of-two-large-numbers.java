//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String s1, String s2) {
        // code here
        if (s1.isEmpty()) return s2;
        if (s2.isEmpty()) return s1;
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry =0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            sum %= 10;
            result.append((char) ('0' + sum));
            i--;
            j--;
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        result.reverse();
        
        return result.toString();
    }
}