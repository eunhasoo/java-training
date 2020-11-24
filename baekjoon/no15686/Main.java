package baekjoon.no15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	int M; // 최대 고를 수 있는 치킨집 개수
	List<Point> chickenPoints = new ArrayList<>(); // 치킨집 좌표 저장용
	List<Point> homePoints = new ArrayList<>(); // 집 좌표 저장용
	Deque<Point> selectedChickenPoints = new ArrayDeque<>(); // 선택된 치킨집 좌표 저장용
	int answer = Integer.MAX_VALUE;

	int calcDist(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p2.y - p2.y);
	}

	void dfs(int start, int count) {
		if (count == M) {
			int sum = 0;
			
			for (Point homePoint : homePoints) {
				int distMin = Integer.MAX_VALUE;
				
				for (Point chickenPoint : selectedChickenPoints) {
					int dist = calcDist(homePoint, chickenPoint);
					if (distMin > dist) distMin = dist;
				}
				
				sum += distMin;
				
				if (answer < sum) return;
			}
			
			answer = sum;
			return;
		}

		for (int i = start; i < chickenPoints.size(); i++) {
			selectedChickenPoints.addFirst(chickenPoints.get(i));
			dfs(i + 1, count + 1);
			selectedChickenPoints.removeFirst();
		}
	}
	
	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(reader.readLine());

			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());

				if (map[y][x] == 1) {
					homePoints.add(new Point(y, x));
				} else if (map[y][x] == 2) {
					chickenPoints.add(new Point(y, x));
				}
			}
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
