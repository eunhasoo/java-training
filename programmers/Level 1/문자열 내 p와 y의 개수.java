class Solution {
	boolean solution(String s) {
		int pCount = 0, yCount = 0;
		for (char c : s.toLowerCase().toCharArray()) {
			if (c == 'p') ++pCount;
			if (c == 'y') ++yCount;
		}
		return (pCount == 0 && yCount == 0) || (pCount == yCount);
	}
}