class Solution {
    class Box{
        int width;
        int length;
        int height;
        
        Box(int width, int length, int height){
            this.width = width;
            this.length = length;
            this.height = height;
        }
    }
    
    public int maxHeight(int[] height, int[] width, int[] length) {
        List<Box> boxes = new ArrayList<>();
        int n = height.length;
        
        for(int i=0;i<n;i++){
            addBox(boxes, width[i], length[i], height[i]);
            addBox(boxes, height[i], length[i], width[i]);
            addBox(boxes, height[i], width[i], length[i]);
        }
        
        int m = boxes.size();
        int[] memo = new int[m];
        
        Arrays.fill(memo, -1);
        
        int ans = 0;
        
        for(int i=0;i<m;i++){
            ans = Math.max(ans, solve(i, boxes, memo));
        }
        return ans;
    }
    
    private void addBox(List<Box> boxes, int a, int b, int h){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        boxes.add(new Box(a, b, h));
    }
    
    private int solve(int index, List<Box> boxes, int[] memo){
        if(memo[index] != -1){
            return memo[index];
        }
        Box current = boxes.get(index);
        int maxHeight = current.height;
        
        for(int i=0;i<boxes.size();i++){
            Box next = boxes.get(i);
            if(next.width < current.width && next.length < current.length){
                int height = current.height + solve(i, boxes, memo);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        return memo[index] = maxHeight;
    }
    
    
    
    
}
