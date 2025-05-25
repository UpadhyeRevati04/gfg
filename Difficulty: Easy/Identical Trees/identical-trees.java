/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

class Solution {
    // Function to check if two trees are identical.
    boolean isIdentical(Node p, Node q) {
        // Code Here
        if (p == null && q == null) return true;
        if (p == null || q == null || p.data != q.data) return false;
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
}