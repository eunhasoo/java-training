import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
	
	class Node {
		int vertex;
		int distance;
		
		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
	
	public int solution(int n, int[][] edge) {
		ArrayList<Integer>[] vertexes = new ArrayList[n];
		for (int i = 0; i < n; i++) 
			vertexes[i] = new ArrayList<>();
		for (int[] e : edge) {
			vertexes[e[0] - 1].add(e[1] - 1);
			vertexes[e[1] - 1].add(e[0] - 1);
		}
		int answer = BFS(n, 0, vertexes);
		return answer;
	}
	
	public int BFS(int n, int start, ArrayList<Integer>[] vertexes) {
		boolean[] visited = new boolean[n];
		ArrayDeque<Node> queue = new ArrayDeque<>();
		int max = 0, count = 0;
		queue.add(new Node(start, count));
		visited[start] = true;
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (max <= current.distance) {
				if (max == current.distance) count++;
				if (max < current.distance) {
					max = current.distance;
					count = 1;
				}
			}
			for (int vertex : vertexes[current.vertex]) {
				if (!visited[vertex]) {
					queue.add(new Node(vertex, current.distance + 1));
					visited[vertex] = true;
				}
			}
		}
		return count;
	}
}