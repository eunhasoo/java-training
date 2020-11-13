package baekjoon.no14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	LinkedList<Integer>[] gears = new LinkedList[4];

	boolean check(int a, int b) {
		if (a > 3 || b > 3 || a < 0 || b < 0) return false;
		if (a < b) { // a번째 톱니바퀴 동쪽과 b번째 톱니바퀴 서쪽 비교
			return gears[a].get(2) != gears[b].get(6);
		} else {     // b번째 톱니바퀴 동쪽과 a번째 톱니바퀴 서쪽 비교
			return gears[b].get(2) != gears[a].get(6);
		}
	}
	
	void toLeft(int gearNum, boolean clockWise) {
		if (gearNum < 0 || gearNum > 3) return;

		if (check(gearNum, gearNum + 1)) {
			toLeft(gearNum - 1, !clockWise);
			rotate(gearNum, clockWise);
		}
	}
	
	void toRight(int gearNum, boolean clockWise) {
		if (gearNum < 0 || gearNum > 3) return;

		if (check(gearNum, gearNum - 1)) {
			toRight(gearNum + 1, !clockWise);
			rotate(gearNum, clockWise);
		}
	}
	
	void rotate(int gearNum, boolean clockWise) {
		if (clockWise) {
			gears[gearNum].addFirst(gears[gearNum].removeLast());
		} else {
			gears[gearNum].addLast(gears[gearNum].removeFirst());
		}
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < gears.length; i++) {
			gears[i] = new LinkedList<Integer>();
			
			for (String n : reader.readLine().split("")) {
				gears[i].add(Integer.parseInt(n));
			}
		}
		
		int K = Integer.parseInt(reader.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int gearNum = Integer.parseInt(st.nextToken()) - 1;
			boolean clockWise = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			
			toLeft(gearNum - 1, !clockWise);
			toRight(gearNum + 1, !clockWise);
			rotate(gearNum, clockWise);
		}
		
		int[][] scores = new int[][] {{0, 1}, {0, 2}, {0, 4}, {0, 8}};
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i][gears[i].get(0)];
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
