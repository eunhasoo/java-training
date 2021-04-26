import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public int solution(int n, int[][] arr) {
        if (n == 1) return arr[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }

        int max = 0;
        for (int i = 1; i < arr[n].length; i++) {
            if (max < arr[n][i]) {
                max = arr[n][i];
            }
        }
        return max;
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 1; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, arr));
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}