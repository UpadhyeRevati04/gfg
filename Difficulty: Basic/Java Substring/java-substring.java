//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String S = in.next();
            int L = in.nextInt();
            int R = in.nextInt();
            Solution ob = new Solution();

            System.out.println(ob.javaSub(S, L, R));
        }
    }
}
// } Driver Code Ends


// User function template for Java
class Solution {
    static String javaSub(String S, int L, int R) {
        // code here
        StringBuilder str = new StringBuilder();
        for(int i= L;i<=R;i++){
            str.append(S.charAt(i));
        }
        return str.toString();
    }
}