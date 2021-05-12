import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int[] result = new int[N + M];

        int i, j, idx;
        i = j = idx = 0;
        while (idx < N + M) {
            if (i == N) {
                while (j < M)
                    result[idx++] = B[j++];
                continue;
            }

            if (j == M) {
                while (i < N)
                    result[idx++] = A[i++];
                continue;
            }

            if (A[i] > B[j]) {
                result[idx] = B[j++];
            } else {
                result[idx] = A[i++];
            }

            idx++;
        }

        StringBuilder builder = new StringBuilder();
        for (int n : result)
            builder.append(n).append(' ');
        System.out.println(builder);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}