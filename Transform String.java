class Solution {
    int transform(String s1, String s2) {
        int n = s1.length();
        if(n!= s2.length()){
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c:s2.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for(int count:map.values()){
            if(count != 0){
                return -1;
            }
        }
        
        int i = n-1;
        int j = n-1;
        
        while(i >= 0 && j >= 0){
            if(s1.charAt(i) == s2.charAt(j)){
                i--;
                j--;
            }else{
                i--;
            }
        }
        return j+1;
    }
}
