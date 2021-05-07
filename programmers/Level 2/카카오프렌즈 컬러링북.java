import java.util.ArrayDeque;

public class Solution {

    int M, N;
    int[][] picture;
    boolean[][] visited;
    ArrayDeque<Node> queue = new ArrayDeque<>();
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[] dfs() {
        int numberOfArea = 0, maxSizeOfOneArea = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue;

                ++numberOfArea;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture[i][j]));
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    public int bfs(int row, int col, int area) {
        int areaCount = 1;
        visited[row][col] = true;
        queue.add(new Node(row, col));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int rowTo = current.row + dr[i];
                int colTo = current.col + dc[i];

                if (rowTo < 0 || colTo < 0 || rowTo >= M || colTo >= N) continue;
                if (visited[rowTo][colTo] || picture[rowTo][colTo] != area) continue;

                ++areaCount;
                queue.add(new Node(rowTo, colTo));
                visited[rowTo][colTo] = true;
            }
        }

        return areaCount;
    }

    public int[] solution(int m, int n, int[][] p) {
        M = m;
        N = n;
        picture = p;
        visited = new boolean[M][N];

        return dfs();
    }
}
