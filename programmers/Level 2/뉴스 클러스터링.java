import java.util.LinkedList;

class Solution {

	public boolean hasSymbol(String s) {
		for (char c : s.toCharArray()) {
			if (c < 'A' || c > 'Z')
				return true;
		}
		return false;
	}

	public LinkedList<String> cutTwoString(String s) {
		LinkedList<String> list = new LinkedList<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (hasSymbol(s.substring(i, i + 2))) {
				continue;
			}
			list.add(s.substring(i, i + 2));
		}
		return list;
	}

	public int solution(String str1, String str2) {
		LinkedList<String> str1List = cutTwoString(str1.toUpperCase());
		LinkedList<String> str2List = cutTwoString(str2.toUpperCase());
		LinkedList<String> union = new LinkedList<>();
		LinkedList<String> intersection = new LinkedList<>();

		if (str1List.size() == 0 && str2List.size() == 0)
			return 65536;
		
		// 교집합 완성
		for (String s : str1List) {
			if (str2List.remove(s)) {
				intersection.add(s);
			}
			union.add(s);
		}
		
		// 합집합 완성
		for (String s : str2List) {
			union.add(s);
		}
		
		double result = (intersection.size() * 1.0) / union.size();
		return (int) Math.floor(result * 65536);
	}
}