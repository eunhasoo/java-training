package baekjoon.no10552;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	int dfs(int[] favor, int start) {
		if (favor[start] == 0) return 0;
		
		boolean[] visited = new boolean[favor.length];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(favor[start]);
		visited[start] = true;
		int standUp = 1;
		while (!queue.isEmpty()) {
			int current = queue.remove();
			
			// 싸이클인 경우 탐색 종료
			if (visited[current]) return -1;
			
			// 현재 채널을 비선호하는 노인이 더 이상 없는 경우 카운트값 리턴
			if (favor[current] == 0) return standUp;
			
			queue.add(favor[current]);
			visited[current] = true;
			++standUp;
		}
		
		return -1;
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노인 수
		int M = Integer.parseInt(st.nextToken()); // 채널 개수
		int P = Integer.parseInt(st.nextToken()); // 초기 채널 번호
		int[] favor = new int[100002];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			int favorite = Integer.parseInt(st.nextToken());
			int hated = Integer.parseInt(st.nextToken());
			if (favor[hated] == 0) // 가장 어린 사람만 일어나면 되므로 값이 존재하는 경우 갱신하지 않음
				favor[hated] = favorite;
		}
		System.out.println(dfs(favor, P));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
