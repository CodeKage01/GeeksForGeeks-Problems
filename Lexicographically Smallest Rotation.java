class Solution {
    public String lexiString(String s) {
        int n = s.length();
        String doubled = s + s;
        
        int i = 0;
        int j = 1;
        int k = 0;
        
        while(i < n && j < n && k < n){
            if(doubled.charAt(i+k) == doubled.charAt(j+k)){
                k++;
            }else if(doubled.charAt(i+k) > doubled.charAt(j+k)){
                i = i + k + 1;
                if(i == j){
                    i++;
                }
                k = 0;
            }else{
                j = j + k + 1;
                if(i == j){
                    j++;
                }
                k = 0;
            }
        }
        int start = Math.min(i, j);
        return doubled.substring(start, start + n);
    }
}
