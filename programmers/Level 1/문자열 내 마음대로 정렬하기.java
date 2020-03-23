import java.util.Arrays;

class Solution {
	  public String[] solution(String[] strings, int n) {
	      Arrays.sort(strings); // 오름차순으로 미리 정렬한 뒤 작업 수행
	      Arrays.sort(strings, (s1, s2) -> s1.charAt(n) - s2.charAt(n));
	      return strings;
	  }
}