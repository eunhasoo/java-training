class Solution {

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		StringBuilder builder;
		for (int i = 0; i < n; i++) {
			builder = new StringBuilder();
			String bin = Integer.toBinaryString(arr1[i] | arr2[i]);
			int len = bin.length();
			while (len != n) { // 자리 맞추기
				++len;
				builder.append(' ');
			}
			for (char c : bin.toCharArray()) {
				if (c == '0')
					builder.append(' ');
				if (c == '1')
					builder.append('#');
			}
			answer[i] = builder.toString();
		}
		return answer;
	}

}