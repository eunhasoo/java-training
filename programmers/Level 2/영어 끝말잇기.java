import java.util.HashSet;
import java.util.Set;

class Solution {
	public int[] solution(int n, String[] words) {
		Set<String> wordSet = new HashSet<>();
		int turn = 1, person = 1;
		boolean flag = false;
		
		for (int i = 0; i < words.length; i++) {
			if (person > n) {
				person = 1;
				turn++;
			}

			// 끝말잇기 규칙에 어긋나는지 검사
			if (wordSet.contains(words[i]) || words[i].length() < 2) {
				flag = true;
				break;
			} else if (i > 0 && !words[i].startsWith(words[i-1].charAt(words[i-1].length() - 1) + "")) {
				flag = true;
				break;
			}

			// 규칙 pass
			wordSet.add(words[i]);
			++person;
		}
		
		if (!flag) { // 문제없이 끝말잇기 성공시
			return new int[] { 0, 0 };
		}
		return new int[] { person, turn };
	}
}