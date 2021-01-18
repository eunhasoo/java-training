import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] alpha = new int[26];

			String input = sc.next();

			for (int i = 0; i < input.length(); i++) {
				int idx = input.charAt(i) - 97;
				++alpha[idx];
			}

			StringBuilder builder = new StringBuilder();
			
			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] >= 2) {
					alpha[i] %= 2;
				}
				
				if (alpha[i] > 0) {
					builder.append((char) (i + 97));
				}
			}

			if (builder.length() == 0) {
				System.out.printf("#%d Good\n", test_case);
			} else {
				System.out.printf("#%d %s\n", test_case, builder.toString());
			}
		}
	}
}
