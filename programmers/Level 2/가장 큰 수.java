import java.util.Arrays;

class Solution {
	public String solution(int[] numbers) {
		String answer = "";
		String[] numToStr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			numToStr[i] = String.valueOf(numbers[i]);
		
//		Arrays.sort(numToStr, (a, b) -> b.compareTo(a)); 	   // 9 5 34 30 3 
		Arrays.sort(numToStr, (a, b) -> (b + a).compareTo(a + b)); // 9 5 34 3 30
		
		for (String s : numToStr)
			answer = s + answer;
		if (numToStr[0].equals("0"))
			return "0";
		return answer;
	}
}