import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		int[] answer;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				list.add(arr[i]);
		}
		if (list.size() == 0) {
			answer = new int[]{-1};
		} else {
			answer = new int[list.size()];
			Collections.sort(list);
			for(int i = 0; i < list.size(); i++)
				answer[i] = list.get(i);
		}
		return answer;
	}
}