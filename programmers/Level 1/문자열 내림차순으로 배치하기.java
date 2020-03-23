import java.util.Arrays;

public class Solution {

	public String solution(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
// 1)		StringBuilder bulider = new StringBuilder();
//		for (int i = arr.length - 1; i >= 0; i--) {
//			bulider.append(arr[i]);
//		}
//		return bulider.toString();
		
// 2)		체이닝으로 코드 최소화
		return new StringBuilder(new String(arr)).reverse().toString(); 
	}
}