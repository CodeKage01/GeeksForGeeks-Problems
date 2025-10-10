/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                Node node = q.poll();
                level.add(node.data);
                
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            
            if(!leftToRight){
                Collections.reverse(level);
            }
            res.addAll(level);
            
            leftToRight = !leftToRight;
        }
        
        return res;
        
    }
}
