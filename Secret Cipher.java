class Solution {
	public String compress(String s) {
		int n = s.length();
		int[] z = buildZ(s);
		
		StringBuilder res = new StringBuilder();
		int i = n-1;
		
		while(i >= 0){
		    int len = i+1;
		    
		    if(len % 2 == 0){
		        int half = len/2;
		        if(z[half] >= half){
		            res.append("*");
		            i = half - 1;
		            continue;
		        }
		    }
		    res.append(s.charAt(i));
		    i--;
		}
		return res.reverse().toString();
	}
	
	private int[] buildZ(String s) {
		
		int n = s.length();
		int[] z = new int[n];
		
		int left = 0;
		int right = 0;
		
		for (int i = 1; i < n; i++) {
			
			if (i <= right) {
				z[i] = Math.min(right - i + 1,
				z[i - left]);
			}
			
			while (i + z[i] < n &&
			s.charAt(z[i]) == s.charAt(i + z[i])) {
				z[i]++;
			}
			
			if (i + z[i] - 1 > right) {
				left = i;
				right = i + z[i] - 1;
			}
		}
		
		return z;
	}
}
