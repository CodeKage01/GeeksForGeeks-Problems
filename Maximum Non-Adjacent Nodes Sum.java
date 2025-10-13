/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Pair{
    int include;
    int exclude;
    
    Pair(int inc,int exc){
        include = inc;
        exclude = exc;
    }
}
class Solution {
    public int getMaxSum(Node root) {
        Pair ans = solve(root);
        return Math.max(ans.include, ans.exclude);
    }
    
    private Pair solve(Node node){
        if(node == null){
            return new Pair(0,0);
        }
        
        Pair left = solve(node.left);
        Pair right = solve(node.right);
        
        int include = node.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include,left.exclude) + Math.max(right.include,right.exclude);
        
        return new Pair(include, exclude);
    }
}
