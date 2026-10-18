class Solution {
    int[] state;
    int[] arr;
    int n;
    public int goodIndices(int[] arr) {
        this.arr = arr;
        n = arr.length;
        state = new int[n];
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(state[i] == 0){
                solve(i);
            }
        }
        
        for(int i=0;i<n;i++){
            if(state[i] == 1){
                count++;
            }
        }
        return count;
    }
    
    private int solve(int i){
        if(i < 0 || i >= n){
            return 1;
        }
        if(state[i] == 1 || state[i] == 2){
            return state[i];
        }
        if(arr[i] == 0){
            state[i] = 2;
            return 2;
        }
        if(state[i] == 3){
            return 2;
        }
        state[i] = 3;
        
        int next = i + arr[i];
        int res = solve(next);
        state[i] = res;
        return res;
    }
}

/*
0 -> not visited
1 -> good
2 -> bad
3 -> currently in dfs 
*/
