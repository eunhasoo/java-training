import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if ((M & (1 << i)) == 0) {
					flag = true;
					break;
				}
			}
			
			System.out.printf("#%d %b", test_case, (flag ? "OFF" : "ON"));
		}
		
		sc.close();
	}
}