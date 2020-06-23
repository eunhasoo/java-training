class Solution {
	
    public int solution(int n) {
    	int bitCount = Integer.bitCount(n);
    	while (true) {
    		if (Integer.bitCount(++n) == bitCount)
    			return n;
    	}
    }
    
}