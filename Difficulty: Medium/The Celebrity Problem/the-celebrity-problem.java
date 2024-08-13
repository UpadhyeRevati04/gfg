//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        
        // Step 1: Find the potential celebrity
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;  // candidate knows i, so i might be the celebrity
            }
        }
        
        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // If candidate knows i or i doesn't know candidate, candidate is not a celebrity
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        
        // If candidate passes all checks, they are the celebrity
        return candidate;
    }

    // public static void main(String[] args) {
    //     int[][] mat = {
    //         {0, 1, 0},
    //         {0, 0, 0},
    //         {0, 1, 0}
    //     };
        
    //     int celebrity = findCelebrity(mat);
    //     if (celebrity == -1) {
    //         System.out.println("No celebrity in the party.");
    //     } else {
    //         System.out.println("The celebrity is at index: " + celebrity);
    //     }
    // }
}