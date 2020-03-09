package baekjoon.no15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] vertex;
	static int[] subTreeCounts;

	static int DFS(int current, int parent) {
		int sum = 0;
		for (int child : vertex[current]) {
			if (child == parent) {
				continue;
			}
			sum += DFS(child, current);
		}
		// 구한 하위 서브트리 개수로부터 자기 자신을 더해 리턴한다
		return subTreeCounts[current] = sum + 1;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.valueOf(tokenizer.nextToken());
		int R = Integer.valueOf(tokenizer.nextToken()) - 1;
		int Q = Integer.valueOf(tokenizer.nextToken());
		vertex = new ArrayList[N];
		subTreeCounts = new int[N];
		for (int i = 0; i < N; i++) {
			vertex[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < (N - 1); i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int U = Integer.valueOf(tokenizer.nextToken()) - 1;
			int V = Integer.valueOf(tokenizer.nextToken()) - 1;
			vertex[U].add(V);
			vertex[V].add(U);
		}
		
		DFS(R, -1); // 각 정점별로 서브트리 수를 구한다
		
		for (int i = 0; i < Q; i++) {
			int v = Integer.valueOf(reader.readLine()) - 1;
			System.out.println(subTreeCounts[v]);
		}
	}
}
