class Node{
    int data;
    int index;
    Node left, right;
    
    Node(int d, int i){
        data = d;
        index = i;
        left = right = null;
    }
    
    Node(Node l, Node r){
        data = l.data + r.data;
        index = Math.min(l.index, r.index);
        left = l;
        right = r;
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        int n = s.length();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->{
            if(a.data != b.data){
                return a.data - b.data;
            }
            return a.index - b.index;
        });
        
        for(int i=0;i<n;i++){
            pq.add(new Node(f[i], i));
        }
        if(n == 1){
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }
        
        while(pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left, right));
        }
        
        Node root = pq.poll();
        ArrayList<String> res = new ArrayList<>();
        
        generateCode(root, "", res);
        return res;
        
    }
    
    private void generateCode(Node root, String code ,ArrayList<String> ans){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(code.length() == 0) code = "0";
            ans.add(code);
            return;
        }
        generateCode(root.left, code+"0", ans);
        generateCode(root.right, code+"1", ans);
    }
}
