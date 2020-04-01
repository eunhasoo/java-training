package baekjoon.no1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	class Node {
		int vertex, distance;

		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
	List<Node>[] vertexes;
	int[] weights;

	void dijkstra(int start) {
		boolean[] visited = new boolean[vertexes.length];
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
		queue.add(new Node(start, 0));
		weights[start] = 0; // 가중치 0(자기자신)부터 시작
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (visited[current.vertex]) { // 이미 방문한 정점이라면 작업 패스
				continue;
			}
			visited[current.vertex] = true;
			for (Node next : vertexes[current.vertex]) { // 간선으로 이어진 정점들 중에서
				if (weights[next.vertex] > weights[current.vertex] + next.distance) { // 해당 정점으로의 거리가 짧으면 배열값 갱신 후 큐에 넣는다
					weights[next.vertex] = weights[current.vertex] + next.distance;
					queue.add(new Node(next.vertex, weights[next.vertex]));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int V = Integer.valueOf(st.nextToken()); // 정점의 개수
		int E = Integer.valueOf(st.nextToken()); // 간선의 개수
		vertexes = new ArrayList[V]; // 해당 정점과 연결된 간선 정보를 담은 리스트
		weights = new int[V]; // 시작 정점부터 각 정점으로의 최단 경로를 저장할 배열
		for (int i = 0; i < V; i++) {
			vertexes[i] = new ArrayList<>();
		}
		int start = Integer.valueOf(reader.readLine()) - 1;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(reader.readLine());
			int u = Integer.valueOf(st.nextToken()) - 1;
			int v = Integer.valueOf(st.nextToken()) - 1;
			int w = Integer.valueOf(st.nextToken());
			vertexes[u].add(new Node(v, w));
		}
		Arrays.fill(weights, Integer.MAX_VALUE);
		dijkstra(start); // 최단 경로 배열을 완성
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < V; i++) {
			if (weights[i] == Integer.MAX_VALUE) { // 연결 정보가 없다면(=초기값 그대로) INF 출력
				builder.append("INF\n");
				continue;
			}
			builder.append(weights[i] + "\n");
		}
		System.out.println(builder);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
