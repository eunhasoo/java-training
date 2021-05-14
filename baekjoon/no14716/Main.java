import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int M, N;
    int[][] banner;
    boolean[][] visited;
    int[] dr = {-1, 0, 1, 0, 1, -1, -1, 1};
    int[] dc = {0, -1, 0, 1, 1, -1, 1, -1};

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        banner = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getLetterCount());
    }

    public int getLetterCount() {
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || banner[i][j] == 0) continue;

                ++count;
                bfs(i, j);
            }
        }
        return count;
    }

    public void bfs(int row, int col) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int rowTo = current.row + dr[i];
                int colTo = current.col + dc[i];

                if (rowTo < 0 || colTo < 0 || rowTo >= M || colTo >= N) continue;
                if (visited[rowTo][colTo] || banner[rowTo][colTo] == 0) continue;

                visited[rowTo][colTo] = true;
                queue.add(new Node(rowTo, colTo));
            }
        }
    }

    class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
