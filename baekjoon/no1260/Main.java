// 백준 1260번

package baekjoon.no1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static void DFS(ArrayList<Integer>[] list, int current, ArrayDeque<Integer> queue) {
		queue.add(current);
		System.out.printf("%d ", current + 1);
		Collections.sort(list[current]);
		for(Integer i : list[current]) {
			if (!queue.contains(i))
				DFS(list, i, queue);
		}
		
	}
	
	static void BFS(ArrayList<Integer>[] list, int vertex) {
		boolean[] isVisited = new boolean[list.length];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(vertex);
		while(queue.size() > 0) {
			int current = queue.remove();
			System.out.printf("%d ", current + 1);
			isVisited[current] = true;
			Collections.sort(list[current]);
			for(Integer i : list[current]) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		while(M-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;
			list[v1].add(v2);
			list[v2].add(v1);
		}
		DFS(list, V, new ArrayDeque<>());
		System.out.println();
		BFS(list, V);
	}

}
