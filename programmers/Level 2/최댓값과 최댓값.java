class Solution {
	
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = -Integer.MAX_VALUE, min = Integer.MAX_VALUE, temp;
        for (String num : nums) {
        	temp = Integer.parseInt(num);
        	if (temp > max) {
        		max = temp;
        	}
        	if (temp < min) {
        		min = temp;
        	}
        }
        
        return (min + " " + max);
    }

}