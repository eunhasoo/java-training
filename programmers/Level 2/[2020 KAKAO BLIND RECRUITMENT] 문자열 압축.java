class Solution {
	
	public int solution(String s) {
		int minStrLength = s.length();
		int maxCutLength = s.length() / 2; // 압축 가능한 문자열 최대 길이
		for (int cut = 1; cut <= maxCutLength; cut++) {
			String res = compressString(s, cut);
			minStrLength = Math.min(minStrLength, res.length());
		}
		return minStrLength;
	}

	public String compressString(String origin, int cut) {
		int count = 1;
		StringBuilder result = new StringBuilder(); // 문자열 삽입 반복 작업에 StringBuilder가 메모리 효율적
		String before, next;
		before = origin.substring(0, cut);
		for (int i = cut; (i + cut) <= origin.length(); i += cut) {
			if (i + cut >= origin.length()) {
				next = origin.substring(i);
			} else {
				next = origin.substring(i, i + cut);
			}

			if (before.equals(next)) {
				++count;
			} else {
				if (count == 1) {
					result.append(before);
				} else {
					result.append(count).append(before);
					count = 1;
				}
				before = next;
			}
		}

		// 반복문에서 처리 못한 부분 마지막 부분 삽입
		if (count != 1) {
			result.append(count).append(before);
		} else {
			result.append(before);
		}
		
		if (origin.length() % cut != 0) { // cut으로 정확히 쪼개지지 않은 경우 남는 문자열은 따로 삽입 필요
			result.append(origin.substring(origin.length() - (origin.length() % cut)));
		}
		
		return result.toString();
	}
}