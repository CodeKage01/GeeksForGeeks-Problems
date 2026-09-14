/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node node, int k) {
        int[] freq = new int[k+1];
        
        dfs(node, 1, k, freq);
        
        int ans = 0;
        int budget = k;
        
        for(int level = 1;level <=k; level++){
            while(freq[level] > 0 && budget >= level){
                budget-= level;
                ans++;
                freq[level]--;
            }
        }
        return ans;
    }
    
    private void dfs(Node node, int level, int k, int[] freq){
        if(node == null){
            return;
        }
        
        if(level > k){
            return;
        }
        
        if(node.left == null && node.right == null){
            freq[level]++;
            return;
        }
        
        dfs(node.left, level+1, k, freq);
        dfs(node.right, level+1, k, freq);
    }
}
