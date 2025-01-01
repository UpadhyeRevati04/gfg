//{ Driver Code Starts
//Initial Template for Javaimport java.io.*;

import java.util.Scanner;

interface in1
{
    void display(int p);
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        int k= sc.nextInt();
        testClass p = new testClass();
        p.display(k);
        
System.out.println("~");
}
    }
}


// } Driver Code Ends
//User function Template for Java

class testClass implements in1
{
    public void display(int k)
    {   
        // Add your code here.
        int count = 0;
        for (int i = 2; i <= k; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Not prime
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // Not prime
            }
        }
        return true; // Prime
    }
}

//{ Driver Code Starts.

// } Driver Code Ends