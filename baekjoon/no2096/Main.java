import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] map = new int[n + 1][3];
        int[][] minCache = new int[2][3]; // 해당 줄과 바로 전줄까지의 min 합 저장
        int[][] maxCache = new int[2][3]; // 해당 줄과 바로 전줄까지의 max 합 저장

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            int current = i % 2;
            int prev = (i - 1) % 2;

            maxCache[current][0] = Math.max(maxCache[prev][0], maxCache[prev][1]) + map[i][0];
            maxCache[current][1] = Math.max(maxCache[prev][0], Math.max(maxCache[prev][1], maxCache[prev][2])) + map[i][1];
            maxCache[current][2] = Math.max(maxCache[prev][1], maxCache[prev][2]) + map[i][2];

            minCache[current][0] = Math.min(minCache[prev][0], minCache[prev][1]) + map[i][0];
            minCache[current][1] = Math.min(minCache[prev][0], Math.min(minCache[prev][1], minCache[prev][2])) + map[i][1];
            minCache[current][2] = Math.min(minCache[prev][1], minCache[prev][2]) + map[i][2];
        }

        int maximum = Math.max(maxCache[n % 2][0], Math.max(maxCache[n % 2][1], maxCache[n % 2][2]));
        int minimum = Math.min(minCache[n % 2][0], Math.min(minCache[n % 2][1], minCache[n % 2][2]));

        System.out.printf("%d %d", maximum, minimum);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}