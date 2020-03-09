package baekjoon.no11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] vertex;
	static boolean[] visited;

	static int getComponentCount(int N) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i] == false) {
				DFS(i);
				++count;
			}
		}
		return count;
	}

	static void DFS(int index) {
		visited[index] = true;
		for (int child : vertex[index]) {
			if (!visited[child]) {
				DFS(child);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.valueOf(tokenizer.nextToken());
		int M = Integer.valueOf(tokenizer.nextToken());
		visited = new boolean[N];
		vertex = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			vertex[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int u = Integer.valueOf(tokenizer.nextToken()) - 1;
			int v = Integer.valueOf(tokenizer.nextToken()) - 1;
			vertex[u].add(v);
			vertex[v].add(u);
		}
		System.out.println(getComponentCount(N));
	}

}
