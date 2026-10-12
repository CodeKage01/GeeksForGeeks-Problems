class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] diff = new int[n];
        
        for(int j:updates){
            diff[j-1]++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i=0;i<n;i++){
            count+= diff[i];
            ans.add(count);
        }
        return ans;
        
    }
}
