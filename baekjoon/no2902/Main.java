package baekjoon.no2902;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public void run() {
		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scan.nextLine(), "-");
		StringBuilder builder = new StringBuilder();
		while (st.hasMoreTokens()) {
			builder.append(st.nextToken().charAt(0));
		}
		System.out.println(builder);
		scan.close();
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
