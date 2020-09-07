class Solution {
	
	public int getIndex(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') ++count;
			else if (s.charAt(i) == ')') --count;
			
			if (count == 0 && i > 0) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public boolean isCorrect(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') ++count;
			else if (s.charAt(i) == ')') --count;
			
			if (count < 0) return false;
		}
		return true;
	}
	
	public String reverse(String s) {
		StringBuilder builder = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '(') builder.append(')');
			else if (c == ')') builder.append('(');
		}
		return builder.toString();
	}

	public String makeCorrect(String w) {
		if (w.length() == 0) {
			return "";
		}
		
		int cutIdx = getIndex(w);
		String u = w.substring(0, cutIdx);
		String v = w.substring(cutIdx, w.length());
		
		if (isCorrect(u)) {
			return u + makeCorrect(v);
		} else {
			String s1 = '(' + makeCorrect(v) + ')';
			String s2 = reverse(u.substring(1, u.length() - 1));
			return s1 + s2;
		}
	}
	
	public String solution(String p) {
		if (isCorrect(p)) return p;
		return makeCorrect(p);
	}
}