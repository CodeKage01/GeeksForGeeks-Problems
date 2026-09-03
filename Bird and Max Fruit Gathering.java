class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        
        // We can visit all trees
        if(m >= n){
            int total = 0;
            for(int x:arr){
                total+=x;
            }
            return total;
        }

        // First window
        int sum = 0;
        for(int i=0;i<m;i++){
            sum+= arr.get(i);
        }
        
        int ans = sum;
        
        // Remaining n - 1 windows
        for(int window = 1;window<n;window++){
            int sub = window - 1;
            sum-= arr.get(sub);
            
            int add = (window + m - 1)%n;
            sum+= arr.get(add);
            
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
