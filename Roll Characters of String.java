class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] diff = new int[n+1];
        
        for(int x:roll){
            diff[0]++;
            diff[x]--;
        }
        
        StringBuilder res = new StringBuilder();
        int prefixSum = 0;
        
        for(int i=0;i<n;i++){
            prefixSum+= diff[i];
            
            int current = s.charAt(i) - 'a';
            int updated = (current + prefixSum) % 26;
            
            res.append((char)('a' + updated));
        }
        return res.toString();
    }
}
