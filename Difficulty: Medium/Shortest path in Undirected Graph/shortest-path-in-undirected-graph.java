//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Step 1: Create the adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Fill the adjacency list from the given edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Step 3: Initialize the distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // Step 4: Implement BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] > dist[node] + 1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 5: Replace unreachable distances with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
