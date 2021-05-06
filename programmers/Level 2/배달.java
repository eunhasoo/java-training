import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    ArrayList<ArrayList<Node>> vertexes;
    int[] distances;

    public int solution(int N, int[][] road, int K) {
        vertexes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            vertexes.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];

            vertexes.get(from).add(new Node(to, weight));
            vertexes.get(to).add(new Node(from, weight));
        }

        distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // 1번 마을부터 배달을 시작한다
        distances[1] = 0;
        dijkstra(1);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) ++answer;
        }
        return answer;
    }

    public void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        queue.add(new Node(start, distances[start]));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node next : vertexes.get(current.to)) {
                if (distances[next.to] > distances[current.to] + next.weight) {
                    distances[next.to] = distances[current.to] + next.weight;
                    queue.add(next);
                }
            }
        }
    }
}
