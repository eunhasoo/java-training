import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int[][] cost;
    boolean[][] visited;
    int[] dr = {0, 0, 1, -1, 0};
    int[] dc = {0, 1, 0, 0, -1};
    int minCostSum = 20000;

    public boolean checkRange(int row, int col) {
        for (int i = 0; i < 5; i++) {
            int rowTo = row + dr[i];
            int colTo = col + dc[i];

            if (rowTo < 0 || colTo < 0 || rowTo >= N || colTo >= N) return false;
            if (visited[rowTo][colTo]) return false;
        }

        return true;
    }

    public void dfs(int idx, int costSum, int count) {
        if (count == 3) {
            minCostSum = Math.min(minCostSum, costSum);
            return;
        }

        for (int i = idx; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!checkRange(i, j)) continue;

                int temp = 0;
                for (int k = 0; k < 5; k++) {
                    int rowTo = i + dr[k];
                    int colTo = j + dc[k];
                    visited[rowTo][colTo] = true;
                    temp += cost[rowTo][colTo];
                }

                dfs(i, costSum + temp, count + 1);

                // 되돌리기
                for (int k = 0; k < 5; k++) {
                    int rowTo = i + dr[k];
                    int colTo = j + dc[k];
                    visited[rowTo][colTo] = false;
                }
            }
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        cost = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(minCostSum);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
