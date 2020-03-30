class Solution {

	public String solution(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') { // 공백으로 단어 분리
				count = 0;
				continue;
			}
			if (count % 2 == 0) { // 단어별 짝수 인덱스를 대문자로
				chars[i] -= 32;
			}
			count++;
		}
		return String.valueOf(chars);
	}

}