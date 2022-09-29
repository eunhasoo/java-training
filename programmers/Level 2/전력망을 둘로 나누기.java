import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<Integer>[] nodes;

    public int solution(int n, int[][] wires) {
        int answer = 100;

        // 송전탑 만들기
        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        // 송전탑 연결하기
        for (int i = 0; i < wires.length; i++) {
            nodes[wires[i][0]].add(wires[i][1]);
            nodes[wires[i][1]].add(wires[i][0]);
        }

        // 탐색
        for (int i = 0; i < wires.length; i++) {
            int count1 = bfs(wires[i][0], wires[i][1], n);
            int count2 = bfs(wires[i][1], wires[i][0], n);

            answer = Math.min(answer, Math.abs(count1 - count2));
        }

        return answer;
    }

    public int bfs(int start, int cut, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        int count = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            ++count;

            Integer now = queue.poll();
            visited[now] = true;
            for (int next : nodes[now]) {
                if (visited[next] || next == cut) continue;
                queue.add(next);
            }
        }

        return count;
    }
}
