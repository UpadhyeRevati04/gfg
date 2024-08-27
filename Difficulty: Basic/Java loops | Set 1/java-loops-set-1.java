//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0)
        {
            int N = scn.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> sum = ob.getSum(N);
            System.out.println(sum.get(0)+" "+sum.get(1));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> getSum(int N){
        // code here
        int evensum = 0;
        int oddsum = 0;
        for(int i =1; i<= N;i++){
            if(i%2==0){
                evensum += i;
            }
            else{
                oddsum +=i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(evensum);
        result.add(oddsum);
        
        return result;
    }
}