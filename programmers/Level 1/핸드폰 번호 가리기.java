class Solution {
	public String solution(String phone_number) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < phone_number.length() - 4; i++) {
			builder.append("*");
		}
		builder.append(phone_number.subSequence(phone_number.length() - 4, phone_number.length()));
		return builder.toString();
	}

	public String solution2(String phone_number) {
		char[] pn = phone_number.toCharArray();
		for (int i = 0; i < pn.length - 4; i++) {
			pn[i] = '*';
		}
		return String.valueOf(pn);
	}
}