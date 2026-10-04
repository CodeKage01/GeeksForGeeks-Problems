class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int n = arr.length + 1;
        
        // process every user from 2->n
        
        for(int i=2;i<=n;i++){
            int[] dist = new int[n+1];
            
            int current = i;
            int jumps = 0;
            int next = 0;
            
            while(next != 1){
                next = arr[current-2];
                jumps++;
                dist[next] = jumps;
                current = next;
            }
            
            for(int j=1;j<i;j++){
                if(dist[j] > 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(dist[j]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
