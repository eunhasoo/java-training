package baekjoon.no11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void BFS(ArrayList<Integer>[] nodeList, int[] parents) {
		boolean[] isVisited = new boolean[nodeList.length];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while(queue.size() > 0) {
			int current = queue.remove();
			if(isVisited[current]) {
				continue;
			}
			isVisited[current] = true;
			for(int child : nodeList[current]) {
				if (isVisited[child]) {
					continue;
				}
				parents[child] = current;
				queue.add(child);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer;
		int N = Integer.valueOf(reader.readLine());
		int[] parents = new int[N];
		ArrayList<Integer>[] nodeList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		for(int i=0; i <(N-1); i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int vertex1 = Integer.valueOf(tokenizer.nextToken()) - 1;
			int vertex2 = Integer.valueOf(tokenizer.nextToken()) - 1;
			nodeList[vertex1].add(vertex2);
			nodeList[vertex2].add(vertex1);
		}
		BFS(nodeList, parents);
		for(int i=1; i<N; i++) {
			writer.write(parents[i]+1+"\n");
		}
		writer.flush();
	}

}