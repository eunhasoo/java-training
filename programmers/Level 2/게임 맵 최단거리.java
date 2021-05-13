import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    int n, m;
    int[][] map;
    int[][] distance;

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int bfs(int row, int col) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int rowTo = current.row + dr[i];
                int colTo = current.col + dc[i];

                if (rowTo == n - 1 && colTo == m - 1) {
                    return distance[current.row][current.col] + 1;
                }
                if (rowTo < 0 || colTo < 0 || rowTo >= n || colTo >= m) continue;
                if (distance[rowTo][colTo] >= 0 || map[rowTo][colTo] == 0) continue;

                queue.add(new Node(rowTo, colTo));
                distance[rowTo][colTo] = distance[current.row][current.col] + 1;
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map = maps;
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        distance[0][0] = 1;
        return bfs(0, 0);
    }
}