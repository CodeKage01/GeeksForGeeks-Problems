class Solution {
    public String findLongestWord(String s, List<String> d) {
        ArrayList<ArrayList<Integer>> pos = new ArrayList<>();
        
        for(int i=0;i<26;i++){
            pos.add(new ArrayList<>());
        }
        
        // store positions of every character
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            pos.get(ch-'a').add(i);
        }
        
        String ans = "";
        
        for(String word: d){
            if(isSubsequence(word, pos)){
                if(word.length() > ans.length()){
                    ans = word;
                }else if(word.length() == ans.length() && word.compareTo(ans) < 0){
                    ans = word;
                }
            }
        }
        return ans;
    }
    
    private boolean isSubsequence(String word, ArrayList<ArrayList<Integer>> pos){
        int prev = -1;
        
        for(char ch: word.toCharArray()){
            ArrayList<Integer> list = pos.get(ch-'a');
            
            // find first posiiton > prev
            int index = binarySearch(list, prev);
            if(index == list.size()){
                return false;
            }
            prev = list.get(index);
        }
        return true;
    }
    
    private int binarySearch(ArrayList<Integer> list, int target){
        int low = 0, high = list.size();
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(list.get(mid) <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    
    
}
