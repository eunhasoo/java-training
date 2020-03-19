import java.util.ArrayList;

class Solution {

	public int[] solution(int[] answers) {
		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] count = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (one[i % one.length] == answers[i])
				count[0]++;
			if (two[i % two.length] == answers[i])
				count[1]++;
			if (three[i % three.length] == answers[i])
				count[2]++;
		}

		ArrayList<Integer> indexes = new ArrayList<>();
		int max = Math.max(count[0], Math.max(count[1], count[2]));
		for (int i = 0; i < 3; i++) {
			if (count[i] == max) {
				indexes.add(i + 1);
			}
		}

		int[] answer = new int[indexes.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = indexes.get(i);
		}
		return answer;
	}
}
