import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    public int[] solution(int[] numbers) {
        SortedSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
            	set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
        	answer[i] = iterator.next();
        }
        
        return answer;
    }
}