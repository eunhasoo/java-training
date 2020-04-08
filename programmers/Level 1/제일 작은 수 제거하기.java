import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int[] solution(int[] arr) {
		if (arr.length == 1)
			return new int[] { -1 };
		List<Integer> list = new ArrayList<>();
		for (int n : arr) {
			list.add(n);
		}
		list.remove(Collections.min(list));

		int[] answer = new int[list.size()];
		int index = 0;
		for (int n : list) {
			answer[index++] = n;
		}
		return answer;
	}
}