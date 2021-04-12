public class Solution {

	public String decimalToTernary(int n) {
		StringBuilder builder = new StringBuilder();
		while (n >= 1) {
			builder.append(n % 3);
			n /= 3;
		}
		return builder.toString();
	}
	
	public int ternaryToDecimal(String n) {
		int result = 0, position = 0;
		for (int i = n.length() - 1; i >= 0; i--) {
			result += (n.charAt(i) - '0') * (int) Math.pow(3, position++);
		}
		return result;
	}
	
	public int solution(int n) {
		return ternaryToDecimal(decimalToTernary(n));
	}

}
