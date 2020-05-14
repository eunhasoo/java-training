import java.util.HashMap;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int value = 0;
		for (char key : skill.toCharArray())
			map.put(key, value++); 
		
		int count; 
		boolean pass;
		char c;
		for (int i = 0; i < skill_trees.length; i++) {
			count = 0; // value(순서)와 일치하는지 비교용 변수
			pass = true; // 선행스킬 없는 스킬트리인 경우를 위해 true로 선언
			for (int j = 0; j < skill_trees[i].length(); j++) {
				c = skill_trees[i].charAt(j);
				if (map.get(c) != null) {
					if (map.get(c) == count) { // 스킬트리 순서가 맞으면
						++count; // 다음 순서와 비교를 위해 count 변수 증가
						continue;
					}
					// 아니면 해당 스킬트리 순서 탐색 끝냄
					pass = false;
					break;
				}
			}
			if (pass) ++answer;
		}
		return answer;
	}
}