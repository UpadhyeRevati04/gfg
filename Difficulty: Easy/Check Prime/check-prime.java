//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

class Main {

    
// } Driver Code Ends
//User function Template for Java

public static boolean prime(int n){
    
    //Write your code here
    //returns a boolean value 
    int count=0;
    if(n <=1){
        return false;
    }
    else{
        for (int i = 1; i <= n; i++) {

            if (n % i == 0)
                count++;
        }

        if (count > 2)
                return false;
        else
                return true;
    }
}

//{ Driver Code Starts.

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0) {
            int n = scn.nextInt();
            boolean ans = prime(n);
            if(ans)
            System.out.println("True");
            else
            System.out.println("False");
        
System.out.println("~");
}
        scn.close();
    }
}
// } Driver Code Ends