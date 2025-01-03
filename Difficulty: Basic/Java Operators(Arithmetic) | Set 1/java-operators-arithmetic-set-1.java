//{ Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String [] S1 = br.readLine().trim().split(" ");
            int A = Integer.parseInt(S1[0]);
            int B = Integer.parseInt(S1[1]);
            int C = Integer.parseInt(S1[2]);
            Solution ob = new Solution();
            double[] ans = ob.FindRoots(A, B, C);
            if(ans.length == 1){
                System.out.println((int)ans[0]);
                continue;
            }
            for(int i = 0; i < ans.length; i++)
                System.out.print(String.format("%6f", ans[i]) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends



class Solution
{
    public double[]  FindRoots(int A, int B, int C)
    {
        // code here
        double D = B * B - 4.0 * A * C;

        if (D < 0) {
            // No real roots, return -1 as specified
            return new double[] { -1 };
        }

        // Calculate the roots
        double root1 = (-B + Math.sqrt(D)) / (2.0 * A);
        double root2 = (-B - Math.sqrt(D)) / (2.0 * A);

        // Ensure the smaller root comes first
        double[] roots = new double[] { root1, root2 };
        Arrays.sort(roots);

        return roots;
    }
}