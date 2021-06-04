import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] castle = new char[N][M];
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];

        for (int i = 0; i < N; i++) {
            castle[i] = reader.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (castle[i][j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int rowCount = 0, colCount = 0;
        for (int i = 0; i < N; i++) {
            if (!row[i]) ++rowCount;
        }
        for (int i = 0; i < M; i++) {
            if (!col[i]) ++colCount;
        }

        System.out.println(Math.max(rowCount, colCount));
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
