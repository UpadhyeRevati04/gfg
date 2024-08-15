//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverseList(head);
        
        // Step 2: Add 1 to the reversed list
        Node current = head;
        int carry = 1;  // We need to add 1, so we initialize carry to 1
        
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;  // Update the node with the last digit of the sum
            carry = sum / 10;  // Update carry
            
            if (carry == 0) {
                break;  // No carry left to propagate, we can stop
            }
            
            if (current.next == null && carry > 0) {
                // If we're at the last node and there is still carry, add a new node
                current.next = new Node(carry);
                carry = 0;  // Reset carry after adding new node
            }
            
            current = current.next;
        }
        
        // Step 3: Reverse the list back to its original order
        head = reverseList(head);
        
        return head;
    }
    
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's pointer
            prev = current;  // Move pointers one position ahead
            current = next;
        }
        
        return prev;  // New head of the reversed list
    }
}