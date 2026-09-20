/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root1);
        q2.add(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            int size1 = q1.size();
            int size2 = q2.size();
            
            if(size1 != size2){
                return false;
            }
            
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            
            for(int i=0;i<size1;i++){
                Node cur1 = q1.poll();
                map1.put(cur1.data, map1.getOrDefault(cur1.data, 0) + 1);
                
                if(cur1.left != null){
                    q1.add(cur1.left);
                }
                if(cur1.right != null){
                    q1.add(cur1.right);
                }
            }
            
            for(int i=0;i<size2;i++){
                Node cur2 = q2.poll();
                map2.put(cur2.data, map2.getOrDefault(cur2.data, 0) + 1);
                
                if(cur2.left != null){
                    q2.add(cur2.left);
                }
                if(cur2.right != null){
                    q2.add(cur2.right);
                }
            }
            
            if(!map1.equals(map2)){
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
