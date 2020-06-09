class Solution {
	public String solution(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		boolean flag = true;
		
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (ch == ' ') {
				flag = true;
				continue;
			}
			if (!flag) continue;
			
			if (ch >= 'a' && ch <= 'z') { // 공백 이후 만난 첫 번째 소문자만 대문자로 바꾸기
				arr[i] = (char) (ch - 32);
			}
			flag = false;
		}
		
		return new String(arr);
	}
}