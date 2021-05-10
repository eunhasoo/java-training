import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int R, C;
    char[][] map;
    int[][] fire;
    int[][] jh;
    List<Node> fireList = new ArrayList<>();

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fire = new int[R][C];
        jh = new int[R][C];

        // 방문과 거리 체크를 동시에 할 수 있도록 -1으로 초기화한다
        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jh[i], -1);
        }

        int jhRow = 0, jhCol = 0;
        for (int i = 0; i < R; i++) {
            String s = reader.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'F') {
                    fireList.add(new Node(i, j));
                    fire[i][j] = 0;
                }

                if (map[i][j] == 'J') {
                    jh[i][j] = 0;
                    jhRow = i;
                    jhCol = j;
                }
            }
        }

        // 불을 먼저 번지도록 한 뒤 번진 거리와 지훈이의 이동 거리를 비교한다.
        onFire();

        int result = escape(jhRow, jhCol);
        System.out.println(result >= 0 ? result : "IMPOSSIBLE");
    }

    public void onFire() {
        Queue<Node> queue = new ArrayDeque<>();
        for (Node fire : fireList) {
            queue.add(fire);
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int rowTo = current.row + dr[i];
                int colTo = current.col + dc[i];

                // 범위를 초과하거나, 방문했거나, 벽인 곳은 이동 불가
                if (rowTo < 0 || colTo < 0 || rowTo >= R || colTo >= C) continue;
                if (fire[rowTo][colTo] >= 0 || map[rowTo][colTo] == '#') continue;

                fire[rowTo][colTo] = fire[current.row][current.col] + 1;
                queue.add(new Node(rowTo, colTo));
            }
        }
    }

    public int escape(int row, int col) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int rowTo = current.row + dr[i];
                int colTo = current.col + dc[i];

                // 범위를 초과한 경우가 최단 거리로 탈출할 수 있다는 뜻이 된다
                if (rowTo < 0 || colTo < 0 || rowTo >= R || colTo >= C) {
                    return jh[current.row][current.col] + 1;
                }

                // 방문했거나, 벽이거나, 불이 번진 거리가 이동하려는 거리보다 같거나 작으면 이동할 수 없다
                if (jh[rowTo][colTo] >= 0 || map[rowTo][colTo] != '.') continue;
                if (fire[rowTo][colTo] != -1 && fire[rowTo][colTo] <= jh[current.row][current.col] + 1) continue;

                jh[rowTo][colTo] = jh[current.row][current.col] + 1;
                queue.add(new Node(rowTo, colTo));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
