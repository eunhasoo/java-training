package baekjoon.no2839;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();

		int heavy = 5, light = 3;
		int result = 0;
		while (true) {
			if (N % heavy == 0) {
				result += N / heavy;
				break;
			}
			
			N -= light;
			++result;
			
			if (N < 0) {
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
		
		scan.close();
	}

}
