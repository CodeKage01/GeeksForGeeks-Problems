class Solution {
    public int findIndex(String s) {
        int close = 0;
        
        for(char c:s.toCharArray()){
            if(c == ')'){
                close++;
            }
        }
        
        int open = 0;
        
        if(open == close){
            return 0;
        }
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close--;
            }
            if(open == close){
                return i+1;
            }
        }
        return s.length();
    }
}
