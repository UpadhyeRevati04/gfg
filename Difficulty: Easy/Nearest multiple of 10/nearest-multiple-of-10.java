//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
import java.math.BigInteger;
class Solution {
    public static String roundToNearest(String s) {
        // Count leading zeros
        int leadingZeros = 0;
        while (leadingZeros < s.length() && s.charAt(leadingZeros) == '0') {
            leadingZeros++;
        }

        // Extract the numeric part
        String numericPart = s.substring(leadingZeros);
        if (numericPart.isEmpty()) {
            return "0"; // If the string was all zeros, return "0"
        }

        BigInteger num = new BigInteger(numericPart);  // Convert to BigInteger
        BigInteger remainder = num.mod(BigInteger.TEN);  // Find remainder

        // Round to the nearest multiple of 10
        if (remainder.compareTo(BigInteger.valueOf(5)) <= 0) {
            num = num.subtract(remainder);  // Round down
        } else {
            num = num.add(BigInteger.TEN.subtract(remainder));  // Round up
        }

        // Convert back to string
        String roundedNumber = num.toString();

        // Append leading zeros back
        return "0".repeat(leadingZeros) + roundedNumber;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends