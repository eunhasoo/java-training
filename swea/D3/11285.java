import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();
			
			int scoreSum = 0;
			
			for (int i = 0; i < t; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				double z = Math.sqrt((x * x) + (y * y));
				
				if (z <= 20) scoreSum += 10;
				else if (z <= 40) scoreSum += 9;
				else if (z <= 60) scoreSum += 8;
				else if (z <= 80) scoreSum += 7;
				else if (z <= 100) scoreSum += 6;
				else if (z <= 120) scoreSum += 5;
				else if (z <= 140) scoreSum += 4;
				else if (z <= 160) scoreSum += 3;
				else if (z <= 180) scoreSum += 2;
				else if (z <= 200) scoreSum += 1;
			}
			
			System.out.printf("#%d %d\n", test_case, scoreSum);
		}
	}

}
