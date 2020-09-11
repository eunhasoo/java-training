import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
    	int take = nums.length / 2;
    	Set<Integer> types = new HashSet<>();
    	for (int type : nums) {
    		types.add(type);
    		if (types.size() == take) 
    			return take;
    	}
        return types.size();
    }
}