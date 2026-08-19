/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int ans = Integer.MIN_VALUE;
    int maxDiff(Node root) {
        dfs(root.left, root.data);
        dfs(root.right, root.data);
        return ans;
    }
    
    private void dfs(Node root, int maxAncestor){
        if(root == null){
            return;
        }
        ans = Math.max(ans, maxAncestor - root.data);
        maxAncestor = Math.max(maxAncestor, root.data);
        
        dfs(root.left, maxAncestor);
        dfs(root.right, maxAncestor);
    }
}
