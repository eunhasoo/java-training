// 백준 2606번

package baekjoon.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	
	static public void countNode(int start) {
		boolean[] visited = new boolean[list.length];
		int count = 0;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		while(queue.size() > 0) {
			int current = queue.remove();
			if (visited[current]) continue;
			visited[current] = true;
			for(int n : list[current]) {
				if(!visited[n] && !queue.contains(n)) {
					count++;
					queue.add(n);
				}
			}
		}
		System.out.println(count);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		StringTokenizer st;
		list = new ArrayList[N];
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<>();
		}
		while(M-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			list[a].add(b);
			list[b].add(a);
		}
		countNode(0);
	}

}
