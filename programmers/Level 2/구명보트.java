import java.util.Arrays;

class Solution {
	
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer, start, end;
        answer = start = 0;
        end = people.length - 1;
        while (start <= end) {
        	if (people[start] + people[end] <= limit) {
        		start++;
        	}
        	end--;
        	answer++;
        }
        
        return answer;
    }

}