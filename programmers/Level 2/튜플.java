import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s/* "{{20,110},{20}}" */) {
    	String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ")// "  20,111 , 20  "
    			.trim().split(" , "); 			      // [["20,111"], ["20"]]
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        Set<String> duplicateChecker = new HashSet<>();
        int[] answer = new int[arr.length];
        int index = 0;
        for (String set : arr) {
        	for (String element : set.split(",")) {
        		if (duplicateChecker.add(element)) {
        			answer[index++] = Integer.parseInt(element);
        		}
        	}
        }
        return answer;
    }
}