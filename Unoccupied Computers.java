class Solution {
    public int solve(int n, String s) {
        int[] state = new int[26];
        
        int computers = n;
        int ans = 0;
        
        for(char ch:s.toCharArray()){
            int index = ch - 'A';
            
            // first occurence
            if(state[index] == 0){
                if(computers > 0){
                    computers--;
                    state[index] = 1;
                }else{
                    ans++;
                    state[index] = 2;
                }
            }
            // second occurence
            else if(state[index] == 1){
                computers++;
                state[index] = 0;
            }
            // second occurence of a rejected customer
            else{
                state[index] = 0;
            }
        }
        return ans;
    }
}
