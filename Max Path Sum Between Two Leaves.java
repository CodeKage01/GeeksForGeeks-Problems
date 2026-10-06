/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int ans;
    int leafCount;
    
    public int maxPathSum(Node root) {
        if(root == null){
            return -1;
        }
        ans = Integer.MIN_VALUE;
        leafCount = 0;
        
        dfs(root);
        
        if(leafCount < 2){
            return -1;
        }
        return ans;
    }
    
    private int dfs(Node node){
        if(node.left == null && node.right == null){
            leafCount++;
            return node.data;
        }
        
        if(node.left == null){
            return node.data + dfs(node.right);
        }
        if(node.right == null){
            return node.data + dfs(node.left);
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        ans = Math.max(ans, left + node.data + right);
        
        
        return node.data + Math.max(left, right);
    }
}
