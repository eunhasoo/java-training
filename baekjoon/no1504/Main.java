package baekjoon.no1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	class Edge {
		int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	List<Edge>[] vertexes;
	final int INF = 800000; // 최대 정점수 800 * 최대 거리 1000

	int getShortestPath(int start, int end) {
		PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
		int[] dist = new int[vertexes.length];
		Arrays.fill(dist, INF);
		queue.add(new Edge(start, 0));
		dist[start] = 0;
		while (!queue.isEmpty()) {
			Edge now = queue.remove();
			if (now.vertex == end) {
				return now.weight;
			}
			for (Edge next : vertexes[now.vertex]) { // 현재 정점과 연결된 정점들 중에서
				if (dist[next.vertex] > dist[now.vertex] + next.weight) { // 연결된 정점이 최단 거리로 성립하면
					dist[next.vertex] = dist[now.vertex] + next.weight; // 거리값 갱신
					queue.add(new Edge(next.vertex, dist[next.vertex]));
				}
			}
		}
		return INF;
	}

	@SuppressWarnings("unchecked")
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		vertexes = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			vertexes[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			vertexes[a].add(new Edge(b, c));
			vertexes[b].add(new Edge(a, c));
		}
		st = new StringTokenizer(reader.readLine());
		int pathA = Integer.parseInt(st.nextToken()) - 1;
		int pathB = Integer.parseInt(st.nextToken()) - 1;
		int pAFirst = getShortestPath(0, pathA) + getShortestPath(pathA, pathB)
						+ getShortestPath(pathB, N - 1);
		int pBFirst = getShortestPath(0, pathB) + getShortestPath(pathB, pathA)
						+ getShortestPath(pathA, N - 1);
		if (pAFirst >= INF || pBFirst >= INF) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(pAFirst, pBFirst));
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
