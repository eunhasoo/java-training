package baekjoon.no1065;

import java.util.Scanner;

public class Main {
	
	public boolean isHansu(int n) { 
		int hundreds = n / 100;	
		int tens = (n / 10) % 10;
		int ones = n % 10;
		
		return ((ones - tens) == (tens - hundreds));
	}
	
	public int countingHansu(int N) {
		int count = 99; // 시작 카운팅 값 초기화
		for (int i = 100; i <= N; i++) { // 100부터 시작
			if (isHansu(i)) ++count;
		}
		return count;
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		if (N < 100) { // ~99까지(한/두자릿수)는 비교대상이 되는 수가 없어 모두 한수가 된다
			System.out.println(N);
		} else {
			System.out.println(countingHansu(N));
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
