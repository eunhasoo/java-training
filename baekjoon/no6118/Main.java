package baekjoon.no6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	class Barn {
		int num, distance;

		public Barn(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}

	List<Barn>[] barns;
	int[] dists;
	int DIST = 0;

	void getShortestPath() {
		boolean[] visited = new boolean[barns.length];
		dists = new int[barns.length];
		Arrays.fill(dists, Integer.MAX_VALUE);
		Queue<Barn> queue = new ArrayDeque<>();
		visited[0] = true; // *
		queue.add(new Barn(0, 0));
		dists[0] = 0;
		while (!queue.isEmpty()) {
			Barn now = queue.remove();
			for (Barn next : barns[now.num]) {
				if (visited[next.num])
					continue;
				if (dists[next.num] > dists[now.num] + next.distance) {
					dists[next.num] = dists[now.num] + next.distance;
					DIST = dists[next.num]; // 최종 거리 저장
				}
				visited[next.num] = true; // *
				queue.add(new Barn(next.num, dists[next.num]));
			}
		}
		// *큐에 넣기 전에 방문 체크를 해주는 것이 좋다. <참고 https://www.acmicpc.net/board/view/47952#comment-82540>
	}

	@SuppressWarnings("unchecked")
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken()); // 헛간의 개수
		int M = Integer.parseInt(st.nextToken()); // 연결된 헛간의 길 수
		barns = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			barns[i] = new ArrayList<>();
		}
		while (M-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			barns[a].add(new Barn(b, 1));
			barns[b].add(new Barn(a, 1));
		}
		getShortestPath();
		int count = 0;
		int idx = Integer.MAX_VALUE;
		for (int i = 0; i < dists.length; i++) {
			if (DIST == dists[i]) { // 거리가 일치하는 헛간 수 세기
				++count;
				if (idx > i) { // 제일 처음 일치하는 헛간 번호 저장
					idx = i + 1;
				}
			}
		}
		System.out.printf("%d %d %d", idx, DIST, count);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
