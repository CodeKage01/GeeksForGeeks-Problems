/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int ans = 1;
    
    public int longestConsecutive(Node root) {
        if(root == null) return -1;
        
        solve(root, root.data-1, 0);
        
        return ans == 1 ? -1 : ans;
    }
    
    private void solve(Node node, int parentVal, int len){
        if(node == null){
            return;
        }
        if(node.data == parentVal + 1){
            len++;
        }else{
            len = 1;
        }
        ans = Math.max(ans, len);
        
        solve(node.left, node.data, len);
        solve(node.right, node.data, len);
    }
}
