package baekjoon.no5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
	int current;
	int count;
	
	public Node(int current, int count) {
		this.current = current;
		this.count = count;
	}
}

public class Main {
	static int totalFloor, curFloor, destFloor;
	
	static String BFS(int up, int down) {
		boolean[] isVisited = new boolean[totalFloor + 1];
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(curFloor, 0));
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			int current = node.current;
			int btnCount = node.count;
			if (current < 1 || current > totalFloor) { // 범위체크를 비교배열보다 먼저 검사해야 런타임 에러가 나지 않음
				continue;
			}
			if (isVisited[current]) { 
				continue;
			}
			isVisited[current] = true;
			if (current == destFloor) {
				return btnCount + "";
			}
			
			// up, down이 0이면 무한루프에 빠질 수 있으므로 체크한다
			if (up > 0)
				queue.add(new Node(current + up, btnCount + 1));
			if (down > 0)
				queue.add(new Node(current - down, btnCount + 1));
		}
		return "use the stairs";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		totalFloor = Integer.valueOf(st.nextToken());
		curFloor = Integer.valueOf(st.nextToken());
		destFloor = Integer.valueOf(st.nextToken());
		int up = Integer.valueOf(st.nextToken());
		int down = Integer.valueOf(st.nextToken());
		System.out.println(BFS(up, down));
	}

}
