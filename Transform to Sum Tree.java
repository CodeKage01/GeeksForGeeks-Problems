/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        solve(root);
    }
    
    private int solve(Node root){
        if(root == null) return 0;
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int oldValue = root.data;
        
        root.data = left + right;
        
        return oldValue + left + right;
    }
}
