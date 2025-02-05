//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

class Main {

    
// } Driver Code Ends
// User function Template for Java

public static int nthDay(int d, int n) {
    // write your code here
        return (d - n % 7 + 7) % 7;

}

//{ Driver Code Starts.

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int d = scn.nextInt();
            int n = scn.nextInt();
            System.out.println(nthDay(d, n));
        }
        scn.close();
    }
}
// } Driver Code Ends