//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
         Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });

        // Step 2: Initialize the time slots array
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slot = new boolean[maxDeadline + 1]; // Time slots to keep track of free slots
        int jobCount = 0;      // Count of jobs done
        int totalProfit = 0;   // Total profit earned

        // Step 3: Schedule jobs
        for (Job job : arr) {
            // Find a free slot for this job (start from its deadline)
            for (int i = job.deadline; i > 0; i--) {
                if (!slot[i]) {
                    slot[i] = true; // Mark this slot as occupied
                    totalProfit += job.profit; // Add profit for this job
                    jobCount++; // Increment count of jobs done
                    break;
                }
            }
        }

        // Return the result as an array [number of jobs done, total profit]
        return new int[]{jobCount, totalProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/