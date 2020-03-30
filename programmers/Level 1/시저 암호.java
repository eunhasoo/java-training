class Solution {

	public String solution(String s, int n) {
		StringBuilder builder = new StringBuilder();
		boolean[] caseFlag = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90) { // 대문자면 true 표시
				caseFlag[i] = true;
			}
		}

		String ss = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			int c = (int) ss.charAt(i);

			if (c == 32) { // char이 공백이면 그냥 append
				builder.append((char) c);
				continue;
			}

			c = c + n;
			if (c > 122) // 범위를 넘어가면 값 수정
				c = c - 26;

			builder.append(caseFlag[i] ? (char) (c - 32) : (char) c);
		}

		return builder.toString();
	}

}