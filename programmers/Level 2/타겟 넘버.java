import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

	class Number {
		int current;
		int index;
		
		public Number(int current, int index) {
			this.current = current;
			this.index = index;
		}
	}
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Number> queue = new ArrayDeque<>();
        queue.add(new Number(0, 0));
        while (!queue.isEmpty()) {
        	Number number = queue.remove();
        	if (number.index == numbers.length && number.current == target) {
        		answer++;
        	}
        	if (number.index < numbers.length) {
        		queue.add(new Number(number.current + numbers[number.index], number.index + 1));
        		queue.add(new Number(number.current + (numbers[number.index] * -1), number.index + 1));
        	}
        }
        return answer;
    }

}