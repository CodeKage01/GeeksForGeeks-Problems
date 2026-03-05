class Solution {
    public static String minWindow(String s, String p) {
        if(s.length() < p.length()) return "";
        
        int[] need = new int[26];
        int[] window = new int[26];
        for(char c:p.toCharArray()){
            need[c-'a']++;
        }
        
        int left=0,right=0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while(right < s.length()){
            char ch = s.charAt(right);
            window[ch-'a']++;
            
            if(need[ch-'a'] > 0 && window[ch-'a'] <= need[ch-'a']){
                count++;
            }
            
            while(count == p.length()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window[leftChar-'a']--;
                
                if(need[ch-'a'] > 0 && window[leftChar-'a'] < need[leftChar-'a']){
                    count--;
                }
                left++;
            }
            right++;
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start+minLen);
    }
}
